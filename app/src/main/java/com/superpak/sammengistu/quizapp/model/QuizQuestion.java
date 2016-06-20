package com.superpak.sammengistu.quizapp.model;


public class QuizQuestion {

    private int mPicForQuestion;
    private String mQuestion;
    private String mAnswerOne;
    private String mAnswerTwo;
    private String mAnswerThree;
    private int mAnswer;

    public QuizQuestion(int picForQuestion, String question,
                        String answerOne, String answerTwo, String answerThree,
                        int answer) {
        mPicForQuestion = picForQuestion;
        mQuestion = question;
        mAnswerOne = answerOne;
        mAnswerTwo = answerTwo;
        mAnswerThree = answerThree;
        mAnswer = answer;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public int getPicForQuestion() {
        return mPicForQuestion;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getAnswerOne() {
        return mAnswerOne;
    }

    public String getAnswerTwo() {
        return mAnswerTwo;
    }

    public String getAnswerThree() {
        return mAnswerThree;
    }
}
