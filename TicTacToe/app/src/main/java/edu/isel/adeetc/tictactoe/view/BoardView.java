package edu.isel.adeetc.tictactoe.view;


import android.content.Context;
import android.util.AttributeSet;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.isel.adeetc.poo.Tile;
import edu.isel.adeetc.poo.TilePanel;
import edu.isel.adeetc.tictactoe.model.Board;
import edu.isel.adeetc.tictactoe.model.Player;

/**
 * Represents a UI component that displays the tic-tac-toe game board. Each game board position is
 * displayed by using a {@link MoveTile} instance.
 */
public class BoardView extends TilePanel {

    private Tile createTile(Board.Move move, Class<?> p1TileType, Class<?> p2TileType) throws Exception {
        if (move == null)
            return new EmptyTile();

        final Class<?> tileType = move.player.getId().equals(player1.getId()) ?
                p1TileType : p2TileType;

        final Constructor<?> ctor = tileType.getConstructor(Board.Move.class);
        return (Tile) ctor.newInstance(move);
    }

    private Board board;
    private Player player1, player2;

    public BoardView(Context context, Board board) {
        super(context);
        this.board = board;
        setSize(board.getSide(), board.getSide());
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BoardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initModel(Board model, Player p1, Player p2, final Class<?> p1TileType, final Class<?> p2TileType) throws Exception {
        this.board = model;
        this.player1 = p1;
        this.player2= p2;

        for(int x = 0; x < board.getSide(); ++x) {
            for (int y = 0; y < board.getSide(); ++y) {
                Board.Move move = board.getMoveAt(x, y);
                setTile(x, y, createTile(move, p1TileType, p2TileType));
            }
        }

        model.addListener(new Board.ChangeAdapter() {
            @Override
            public void boardChanged(Board board, int x, int y) {
                try {
                    final Board.Move move = board.getMoveAt(x, y);
                    setTile(x, y, createTile(move, p1TileType, p2TileType));
                } catch (Exception impossible) {
                    // The exception cannot be thrown because it would already have been thrown
                    // when the view was initialized. If it occurs, something very wrong is at foot.
                    throw new Error();
                }
            }
        });

    }
}
