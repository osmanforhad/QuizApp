package com.osmanforhad.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mQuestiontext;
    private Button mTrueButton, mFalseButton, mNextButton;

    private int mCurrentIndex=0;

    private TrueFalse[] mQuestions = new TrueFalse[]{
            new TrueFalse(R.string.question_one,  false),
            new TrueFalse(R.string.question_two,  true),
            new TrueFalse(R.string.question_three,  false),
            new TrueFalse(R.string.question_four,  true),
            new TrueFalse(R.string.question_five,  false),
            new TrueFalse(R.string.question_six,  true),
            new TrueFalse(R.string.question_seven,  true),
            new TrueFalse(R.string.question_eight,  false)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calling the Method
        setupUIViews();
    }

    //Method for setupUI
    private void setupUIViews(){
        mQuestiontext = (TextView)findViewById(R.id.question_text_view);
        final int Question = mQuestions[mCurrentIndex].getmQuestion();
        mQuestiontext.setText(Question);

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling the method with boolean parameter
                checkAnswer(true);
            }
        });

        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling the method with boolean parameter
                checkAnswer(false);
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                int question = mQuestions[mCurrentIndex].getmQuestion();
                mQuestiontext.setText(question);
            }
        });
    }

    //Method for Display Text Through the user click
    private void checkAnswer(boolean userPressed){
        boolean answer = mQuestions[mCurrentIndex].ismTrueQuestion();
        if (userPressed == answer){
            Toast.makeText(MainActivity.this, R.string.true_message, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(MainActivity.this, R.string.false_message, Toast.LENGTH_LONG).show();

        }
    }
}
