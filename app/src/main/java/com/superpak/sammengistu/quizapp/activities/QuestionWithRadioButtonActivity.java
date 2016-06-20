package com.superpak.sammengistu.quizapp.activities;

import com.superpak.sammengistu.quizapp.AllQuestions;
import com.superpak.sammengistu.quizapp.QuizConstants;
import com.superpak.sammengistu.quizapp.R;
import com.superpak.sammengistu.quizapp.model.QuizQuestion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class QuestionWithRadioButtonActivity extends AppCompatActivity {

    private ImageView mPicForQuestion;
    private TextView mQuestionTextView;
    private RadioButton mAnswerOneRadioButton;
    private RadioButton mAnswerTwoRadioButton;
    private RadioButton mAnswerThreeRadioButton;
    private Button mNextQuestion;
    private QuizQuestion mCurrentQuestion;
    private int mCurrentQuestionPosition;
    private List<RadioButton> mCurrentRadioButtons;
    private int mCurrentScore;

    private final String TAG = "QuestionWithActivity";

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_question_with_image);
        new AllQuestions();


        mNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: check that an answer was selected
                for (int i = 0; i <mCurrentRadioButtons.size(); i++){
                    if (i == mCurrentQuestion.getAnswer()){

                        SharedPreferences sharedPreferences =
                            getSharedPreferences(QuizConstants.SHARED_PREFERANCE_NAME, 0);

                        mCurrentScore = sharedPreferences.getInt(QuizConstants.CURRENT_SCORE, 0);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt(QuizConstants.CURRENT_SCORE, mCurrentScore++);
                        editor.apply();

                        Log.i(TAG, "current score = " + mCurrentScore);
                    }
                }

                mCurrentQuestionPosition++;
            }
        });

    }

}
