package com.superpak.sammengistu.quizapp.activities;

import com.superpak.sammengistu.quizapp.QuizConstants;
import com.superpak.sammengistu.quizapp.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This Activity displays the score
 */
public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_score);

        TextView scoreTextView = (TextView) findViewById(R.id.your_score_message_text_view);

        SharedPreferences sharedPreferences =
            getSharedPreferences(QuizConstants.SHARED_PREFERENCE_NAME, 0);

        String userName = sharedPreferences.getString(QuizConstants.USER_NAME, "");
        int score = sharedPreferences.getInt(QuizConstants.CURRENT_SCORE, 0);

        scoreTextView.setText("Hey " + userName + "!" + "\n  Your score is = " + score + "/6");

        Toast.makeText(this, "Your score is " + score + "/6", Toast.LENGTH_LONG).show();
    }
}
