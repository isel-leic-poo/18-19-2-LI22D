package edu.isel.adeetc.poo;

import edu.isel.adeetc.poo.model.Board;
import edu.isel.adeetc.poo.model.Coordinate;
import edu.isel.adeetc.poo.model.Player;
import edu.isel.adeetc.poo.view.BoardView;
import edu.isel.adeetc.poo.view.CrossedTile;
import edu.isel.adeetc.poo.view.MessageView;
import edu.isel.adeetc.poo.view.RoundedTile;
import isel.leic.pg.Console;
import isel.poo.console.Window;

import static isel.leic.pg.Console.BLACK;
import static isel.leic.pg.Console.GRAY;

public class Main {

    private static final int TILES_COUNT = 3;
    private static final int TILE_SIDE = 3;
    private static final int BOARD_SIDE = TILE_SIDE * TILES_COUNT;
    private static final int MESSAGE_HEIGHT = 1;
    private static final int WINDOW_HEIGHT = BOARD_SIDE + MESSAGE_HEIGHT;
    private static final int WINDOW_WIDTH = BOARD_SIDE;

    private static boolean isValidCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < TILES_COUNT;
    }

    private static Window initConsole() {
        Window window = new Window("Tic-Tac-Toe", WINDOW_HEIGHT, WINDOW_WIDTH, BLACK);
        Console.disableMouseEvents();
        Console.exit(true);
        return window;
    }

    private static int getMoveCoordinate() {
        char coordinate = 0;
        do { coordinate = Console.waitChar(0); }
        while(!Character.isDigit(coordinate) || !isValidCoordinate(coordinate - '0'));
        return coordinate - '0';
    }

    private static Coordinate getMoveCoordinates(String baseMessage, MessageView messageView) {
        final int x = getMoveCoordinate();
        messageView.setMessage(baseMessage + x);
        final int y = getMoveCoordinate();
        messageView.setMessage(baseMessage + x + "," + y);
        return new Coordinate(x, y);
    }

    public static void main(String[] args) {
        Window window = initConsole();
        final Board board = new Board();
        final Player p1 = new Player(board, "P1");
        final Player p2 = new Player(board, "P2");


        final BoardView boardView = new BoardView(board, TILE_SIDE);
        final MessageView messageView = new MessageView(boardView.getHeight(), 0, MESSAGE_HEIGHT, BOARD_SIDE, GRAY);
        window.getContent()
                .addView(boardView)
                .addView(messageView)
                .repaint();

        board.addListener(new Board.ChangeListener() {
            @Override
            public void boardChanged(Board board, int x, int y) {
                Board.Move move = board.getMoveAt(x, y);
                boardView.setTile(x, y, move.player == p1 ?
                        new RoundedTile(move) : new CrossedTile(move));
            }

            @Override
            public void andTheWinnerIs(Player winner) {
                messageView.setMessage("Winner is " + winner.getId());
            }
        });

        Player currentPlayer = p1;
        while (!board.hasGameEnded()) {
            messageView.setMessage(currentPlayer.getId() + ":");
            Coordinate move = getMoveCoordinates(currentPlayer.getId() + ":", messageView);
            currentPlayer.doMove(move.x, move.y);
            currentPlayer = currentPlayer == p1 ? p2 : p1;
            Console.sleep(3000);
        }

        window.close();
    }
}
