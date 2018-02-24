package com.example.android.snookercounter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    static final String currentScoreOne = "currentScore_1";
    static final String currentScoreTwo = "currentScore_2";
    static final String frameScoreOne = "frameScore_1";
    static final String frameScoreTwo = "frameScore_2";

    private int curScore1 = 0;
    private int curScore2 = 0;
    private int frameScore1 = 0;
    private int frameScore2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // display saved score
        displayScore1(curScore1);
        displayScore2(curScore2);
        displayFrameScore1(frameScore1);
        displayFrameScore2(frameScore2);

        // set on click listener for buttons that add points
        findViewById(R.id.btn_add1_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add2_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add3_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add4_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add5_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add6_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add7_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_foul_p1).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add1_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add2_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add3_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add4_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add5_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add6_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_add7_p2).setOnClickListener(globalOnClickListener);
        findViewById(R.id.btn_foul_p2).setOnClickListener(globalOnClickListener);
    }

    /**
     * save and restore score
     */
    @Override
    public void onSaveInstanceState(Bundle outstate) {
        // Save the user's current game state
        outstate.putInt(currentScoreOne, curScore1);
        outstate.putInt(currentScoreTwo, curScore2);
        outstate.putInt(frameScoreOne, frameScore1);
        outstate.putInt(frameScoreTwo, frameScore2);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outstate);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        curScore1 = savedInstanceState.getInt(currentScoreOne);
        curScore2 = savedInstanceState.getInt(currentScoreTwo);
        frameScore1 = savedInstanceState.getInt(frameScoreOne);
        frameScore2 = savedInstanceState.getInt(frameScoreTwo);

        displayScore1(curScore1);
        displayScore2(curScore2);
        displayFrameScore1(frameScore1);
        displayFrameScore2(frameScore2);
    }



    // Set global on click listener for the buttons that add points


    final View.OnClickListener globalOnClickListener = new View.OnClickListener() {
      public void onClick(final View v) {
          switch (v.getId()) {
              // points player 1
              case R.id.btn_add1_p1:
                  addPointsToPlayer1(1);
                  break;
              case R.id.btn_add2_p1:
                  addPointsToPlayer1(2);
                  break;
              case R.id.btn_add3_p1:
                  addPointsToPlayer1(3);
                  break;
              case R.id.btn_add4_p1:
                  addPointsToPlayer1(4);
                  break;
              case R.id.btn_add5_p1:
                  addPointsToPlayer1(5);
                  break;
              case R.id.btn_add6_p1:
                  addPointsToPlayer1(6);
                  break;
              case R.id.btn_add7_p1:
                  addPointsToPlayer1(7);
                  break;
              case R.id.btn_foul_p1:
                  addPointsToPlayer2(4);
                  break;
              // point player 2
              case R.id.btn_add1_p2:
                  addPointsToPlayer2(1);
                  break;
              case R.id.btn_add2_p2:
                  addPointsToPlayer2(2);
                  break;
              case R.id.btn_add3_p2:
                  addPointsToPlayer2(3);
                  break;
              case R.id.btn_add4_p2:
                  addPointsToPlayer2(4);
                  break;
              case R.id.btn_add5_p2:
                  addPointsToPlayer2(5);
                  break;
              case R.id.btn_add6_p2:
                  addPointsToPlayer2(6);
                  break;
              case R.id.btn_add7_p2:
                  addPointsToPlayer2(7);
                  break;
              case R.id.btn_foul_p2:
                  addPointsToPlayer1(4);
                  break;
          }
      }
    };


    /**
     * Adds chosen number of points to player 1.
     *
     * @param numberOfPoints how many points to add
     */
    public void addPointsToPlayer1(int numberOfPoints) {
        curScore1 = curScore1 + numberOfPoints;
        displayScore1(curScore1);
    }

    /**
     * Adds chosen number of points to player 2.
     *
     * @param numberOfPoints how many points to add
     */
    public void addPointsToPlayer2(int numberOfPoints) {
        curScore2 = curScore2 + numberOfPoints;
        displayScore2(curScore2);
    }

    /**
     * Displays the given score for player1.
     */
    public void displayScore1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txt_score_p1);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for player2.
     */
    public void displayScore2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txt_score_p2);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets frame = sets curScore1 a curScore2 to zero.
     */
    public void resetFrame(View v) {
        curScore1 = 0;
        curScore2 = 0;
        displayScore1(curScore1);
        displayScore2(curScore2);
    }

    /**
     * Ends frame = compares curScore1 with curScore two and adds 1 frame-point to winning team.
     * Resets the frame.
     */
    public void endFrame(View v) {
        if (curScore1 > curScore2) {
            frameScore1 = frameScore1 + 1;
            displayFrameScore1(frameScore1);
            resetFrame(v);
        } else if (curScore2 > curScore1) {
            frameScore2 = frameScore2 + 1;
            displayFrameScore2(frameScore2);
            resetFrame(v);
            // in case of a draw
        } else {
            displayFrameScore1(frameScore1);
            displayFrameScore2(frameScore2);
            resetFrame(v);
        }
    }

    /**
     * Displays the frame score for player1.
     */
    public void displayFrameScore1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txt_frame_score_p1);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the frame score for player2.
     */
    public void displayFrameScore2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txt_frame_score_p2);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets game = sets all scores to zero.
     */
    public void resetGame(View v) {
        frameScore1 = 0;
        frameScore2 = 0;
        displayFrameScore1(frameScore1);
        displayFrameScore2(frameScore2);
        resetFrame(v);
    }
}
