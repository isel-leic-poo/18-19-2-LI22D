package edu.isel.adeetc.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Scanner;

import edu.isel.adeetc.poo.Img;
import edu.isel.adeetc.poo.Tile;
import edu.isel.adeetc.tictactoe.model.Board;
import edu.isel.adeetc.tictactoe.model.Coordinate;
import edu.isel.adeetc.tictactoe.model.Player;
import edu.isel.adeetc.tictactoe.view.BoardView;
import edu.isel.adeetc.tictactoe.view.ImageTile;
import edu.isel.adeetc.tictactoe.view.TileTouchAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String MODEL_STATE = "edu.isel.adeetc.tictactoe.MainActivity.MODEL_STATE";
    private static final String NEXT_TO_MOVE = "edu.isel.adeetc.tictactoe.MainActivity.NEXT_TO_MOVE";
    private static final String P1_ID = "edu.isel.adeetc.tictactoe.MainActivity.P1_ID";
    private static final String P2_ID = "edu.isel.adeetc.tictactoe.MainActivity.P2_ID";

    private Player playerToMove, p1, p2;
    private Class<?> p1ViewType, p2ViewType;
    private Board model;

    private void initViewTypes() {
        Scanner in = null;
        try {
            in = new Scanner(getAssets().open("view_type.config"));
            p1ViewType = Class.forName(in.nextLine());
            p2ViewType = Class.forName(in.nextLine());
        } catch (Exception e) {
            // The asset content is not usable, therefore the APK is invalid.
            throw new Error();
        } finally {
            if (in != null)
                in.close();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewTypes();

        if (savedInstanceState != null) {
            model = new Board();
            p1 = new Player(model, savedInstanceState.getString(P1_ID));
            p2 = new Player(model, savedInstanceState.getString(P2_ID));
            model.loadSavedState(savedInstanceState.getString(MODEL_STATE), p1, p2);

            String next = savedInstanceState.getString(NEXT_TO_MOVE);
            playerToMove = next.equals(p1.getId()) ? p1 : p2;
        }
        else {
            model = new Board();
            p1 = new Player(model, "p1");
            p2 = new Player(model, "p2");
            playerToMove = p1;
        }


        final BoardView boardView = findViewById(R.id.boardView);
        try {
            boardView.initModel(model, p1, p2, p1ViewType, p2ViewType);
        } catch (Exception impossible) {
            // The asset content is not usable, therefore the APK is invalid.
            throw new Error();
        }

        boardView.setListener(new TileTouchAdapter() {
            @Override
            public boolean onClick(int xTile, int yTile) {

                if (model.hasMoveAt(xTile, yTile) || model.hasGameEnded())
                    return false;

                model.setMoveAt(xTile, yTile, playerToMove);
                playerToMove = playerToMove == p1 ? p2 : p1;
                return true;
            }
        });

        model.addListener(new Board.ChangeAdapter() {
            @Override
            public void andTheWinnerIs(Player winner) {
                Toast.makeText(
                        MainActivity.this,
                        "The winner is " + winner.getId(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MODEL_STATE, model.getSaveState());
        outState.putString(P1_ID, p1.getId());
        outState.putString(P2_ID, p2.getId());
        outState.putString(NEXT_TO_MOVE, playerToMove.getId());
    }
}
