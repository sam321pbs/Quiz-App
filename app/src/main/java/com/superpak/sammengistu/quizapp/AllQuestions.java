package com.superpak.sammengistu.quizapp;

import com.superpak.sammengistu.quizapp.model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class AllQuestions {

    private static List<QuizQuestion> mAllQuizQuestions;

    public AllQuestions() {
        mAllQuizQuestions = new ArrayList<>();
        createQuestionsAndAddToList();
    }

    public static QuizQuestion getQuizQuestion(int pos){
        return mAllQuizQuestions.get(pos);
    }

    private void createQuestionsAndAddToList() {
        QuizQuestion quizQuestion1 = new QuizQuestion(
            R.drawable.canteloupe_and_cross_section, "What fruit is this?",
            "Watermelon", "Cantalope", "Honeydew", 1);

        QuizQuestion quizQuestion2 = new QuizQuestion(
            R.drawable.don_cheadle, "Who is this celebrity?",
            "Don Chadel", "Will Smith", "Matt Damon", 0);

        QuizQuestion quizQuestion3 = new QuizQuestion(
            0, "Is lemon a fruit?",
            "It is a fruit", "Not a fruit", "It's a meat", 0);

        QuizQuestion quizQuestion4 = new QuizQuestion(
            0, "What was Elvis Praselys middle name?",
            "Fred", "Joe", "Aaron", 2);

        QuizQuestion quizQuestion5 = new QuizQuestion(
            0, "What is the real meaning of the word Pita",
            "Fish", "To Fly", "Bread", 2);

        QuizQuestion quizQuestion6 = new QuizQuestion(
            0, "What companys does disney own? Check all that apply.",
            "Espn", "NBA", "Pixar", 13);

        mAllQuizQuestions.add(quizQuestion1);
        mAllQuizQuestions.add(quizQuestion2);
        mAllQuizQuestions.add(quizQuestion3);
        mAllQuizQuestions.add(quizQuestion4);
        mAllQuizQuestions.add(quizQuestion5);
        mAllQuizQuestions.add(quizQuestion6);
    }
}
