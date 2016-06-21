package com.superpak.sammengistu.quizapp.activities;

import com.superpak.sammengistu.quizapp.QuizConstants;
import com.superpak.sammengistu.quizapp.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.enter_name_edit_text);

        Button mStartQuizButton = (Button) findViewById(R.id.start_quiz_button);

        mStartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startQuiz();
            }
        });
    }

    /**
     * Checks if the user entered a name then stores the name into a shared preference
     * then starts activity
     */
    private void startQuiz (){
        String nameOfUser = mNameEditText.getText().toString();
        if (!nameOfUser.equals("")){

            SharedPreferences sharedPreferences = getSharedPreferences(
                QuizConstants.SHARED_PREFERENCE_NAME, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(QuizConstants.USER_NAME, nameOfUser);

            editor.apply();

            Intent intent = new Intent(WelcomeActivity.this,
                QuestionWithRadioButtonActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.enter_name, Toast.LENGTH_SHORT).show();
        }
    }
}
