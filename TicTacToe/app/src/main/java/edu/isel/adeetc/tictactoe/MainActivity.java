package edu.isel.adeetc.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import edu.isel.adeetc.poo.Img;
import edu.isel.adeetc.tictactoe.model.Board;
import edu.isel.adeetc.tictactoe.model.Coordinate;
import edu.isel.adeetc.tictactoe.model.Player;
import edu.isel.adeetc.tictactoe.view.BoardView;
import edu.isel.adeetc.tictactoe.view.ImageTile;
import edu.isel.adeetc.tictactoe.view.TileTouchAdapter;

public class MainActivity extends AppCompatActivity {

    private Player playerToMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BoardView boardView = findViewById(R.id.boardView);
        final Board model = new Board();
        final Player p1 = new Player(model, "p1");
        final Player p2 = new Player(model, "p2");
        boardView.initModel(model, p1, p2);

        playerToMove = p1;

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

}
