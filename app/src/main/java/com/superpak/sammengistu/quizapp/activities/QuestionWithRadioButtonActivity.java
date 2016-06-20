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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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
    private SharedPreferences mSharedPreferences;

    private final String TAG = "QuestionWithActivity";

    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_question_with_image);
        initializeView();
        new AllQuestions();

        mSharedPreferences = getSharedPreferences(QuizConstants.SHARED_PREFERANCE_NAME, 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(QuizConstants.CURRENT_SCORE, 0);
        editor.apply();

        setUpQuestion();

       setListenerForRadioButtons();

        mNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check that an answer was selected
                boolean answered = false;
                for (RadioButton radioButton : mCurrentRadioButtons){
                    if (radioButton.isChecked()){
                        answered = true;
                    }
                }

                if (answered) {
                   handleAnswer();
                } else {
                    Toast.makeText(QuestionWithRadioButtonActivity.this,
                        "Please select an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void handleAnswer (){
        for (int i = 0; i < mCurrentRadioButtons.size(); i++) {
            if (i == mCurrentQuestion.getAnswer()) {
                if (mCurrentRadioButtons.get(i).isChecked()) {

                    mCurrentScore = mSharedPreferences.getInt(QuizConstants.CURRENT_SCORE, 0);

                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putInt(QuizConstants.CURRENT_SCORE, ++mCurrentScore);
                    editor.apply();

                    Log.i(TAG, "current score = " + mCurrentScore);
                }
            }
        }
        mCurrentQuestionPosition++;
        setUpQuestion();
    }

    private void setListenerForRadioButtons() {
        mAnswerOneRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mAnswerTwoRadioButton.setChecked(false);
                mAnswerThreeRadioButton.setChecked(false);
            }
        });

        mAnswerTwoRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mAnswerOneRadioButton.setChecked(false);
                mAnswerThreeRadioButton.setChecked(false);
            }
        });

        mAnswerThreeRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mAnswerOneRadioButton.setChecked(false);
                mAnswerTwoRadioButton.setChecked(false);
            }
        });
    }

    /**
     * Retrieves the next question in the question list and displays it
     */
    private void setUpQuestion() {
        clearRadioButton();
        mCurrentQuestion = AllQuestions.getQuizQuestion(mCurrentQuestionPosition);
        if (mCurrentQuestion.getPicForQuestion() != 0){
            mPicForQuestion.setImageResource(mCurrentQuestion.getPicForQuestion());
        } else {
            mPicForQuestion.setImageDrawable(null);
        }

        mQuestionTextView.setText(mCurrentQuestion.getQuestion());
        mAnswerOneRadioButton.setText(mCurrentQuestion.getAnswerOne());
        mAnswerTwoRadioButton.setText(mCurrentQuestion.getAnswerTwo());
        mAnswerThreeRadioButton.setText(mCurrentQuestion.getAnswerThree());
    }

    private void clearRadioButton() {
        for (RadioButton radioButton : mCurrentRadioButtons){
            radioButton.setChecked(false);
        }
    }


    private void initializeView() {
        mCurrentRadioButtons = new ArrayList<>();

        mPicForQuestion = (ImageView) findViewById(R.id.image_view_to_show);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mAnswerOneRadioButton = (RadioButton) findViewById(R.id.radioButton);
        mAnswerTwoRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        mAnswerThreeRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        mNextQuestion = (Button) findViewById(R.id.next_question);

        mCurrentRadioButtons.add(mAnswerOneRadioButton);
        mCurrentRadioButtons.add(mAnswerTwoRadioButton);
        mCurrentRadioButtons.add(mAnswerThreeRadioButton);
    }

}
