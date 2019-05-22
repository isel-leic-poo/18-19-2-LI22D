package edu.isel.adeetc.tictactoe.view;


import android.content.Context;
import android.util.AttributeSet;

import edu.isel.adeetc.poo.Tile;
import edu.isel.adeetc.poo.TilePanel;
import edu.isel.adeetc.tictactoe.model.Board;
import edu.isel.adeetc.tictactoe.model.Player;

/**
 * Represents a UI component that displays the tic-tac-toe game board. Each game board position is
 * displayed by using a {@link MoveTile} instance.
 */
public class BoardView extends TilePanel {

    private Tile createTile(Board.Move move) {
        if (move == null)
            return new EmptyTile();

        return move.player.getId().equals(player1.getId()) ?
            new CrossedTile(move) : new RoundedTile(move);
    }

    private Board board;
    private Player player1, player2;

    public BoardView(Context context) {
        super(context);
        setSize(10,10);
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initModel(Board model, Player p1, Player p2) {
        this.board = model;
        this.player1 = p1;
        this.player2= p2;

        for(int x = 0; x < board.getSide(); ++x) {
            for (int y = 0; y < board.getSide(); ++y) {
                Board.Move move = board.getMoveAt(x, y);
                setTile(x, y, createTile(move));
            }
        }

        model.addListener(new Board.ChangeAdapter() {
            @Override
            public void boardChanged(Board board, int x, int y) {
                final Board.Move move = board.getMoveAt(x, y);
                setTile(x, y, createTile(move));
            }
        });

    }
}
