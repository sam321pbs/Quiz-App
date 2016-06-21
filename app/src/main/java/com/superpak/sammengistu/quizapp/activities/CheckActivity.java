package com.superpak.sammengistu.quizapp.activities;

import com.superpak.sammengistu.quizapp.AllQuestions;
import com.superpak.sammengistu.quizapp.QuizConstants;
import com.superpak.sammengistu.quizapp.R;
import com.superpak.sammengistu.quizapp.model.QuizQuestion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private CheckBox mAnswerOne;
    private CheckBox mAnswerTwo;
    private CheckBox mAnswerThree;
    private List<CheckBox> mCheckBoxes;
    private QuizQuestion mCurrentQuizQuestion;
    private Button mDoneButton;

    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_chack_all_that_apply);
        initializeView();
        mCurrentQuizQuestion = AllQuestions.getQuizQuestion(5);
        setViewTexts();

        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                    getSharedPreferences(QuizConstants.SHARED_PREFERENCE_NAME, 0);

                if (checkAnswer()) {
                    int currentScore = sharedPreferences.getInt(QuizConstants.CURRENT_SCORE, 0);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(QuizConstants.CURRENT_SCORE, ++currentScore);
                    editor.apply();
                }

                Intent intent = new Intent(CheckActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Sets the the question text
     * Sets the possible answers for the question
     */
    private void setViewTexts() {
        mQuestionTextView.setText(mCurrentQuizQuestion.getQuestion());
        mAnswerOne.setText(mCurrentQuizQuestion.getAnswerOne());
        mAnswerTwo.setText(mCurrentQuizQuestion.getAnswerTwo());
        mAnswerThree.setText(mCurrentQuizQuestion.getAnswerThree());
    }

    private boolean checkAnswer() {
        return mCheckBoxes.get(0).isChecked() && mCheckBoxes.get(2).isChecked()
            && !mCheckBoxes.get(1).isChecked();
    }

    private void initializeView() {
        mCheckBoxes = new ArrayList<>();

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mAnswerOne = (CheckBox) findViewById(R.id.checkBox1);
        mAnswerTwo = (CheckBox) findViewById(R.id.checkBox2);
        mAnswerThree = (CheckBox) findViewById(R.id.checkBox3);
        mDoneButton = (Button) findViewById(R.id.done_button);

        mCheckBoxes.add(mAnswerOne);
        mCheckBoxes.add(mAnswerTwo);
        mCheckBoxes.add(mAnswerThree);
    }
}
