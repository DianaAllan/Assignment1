package com.example.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Question> questions ;
    private int NumCorrect;
    private int NumInCorrect;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumCorrect() {
        return NumCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        NumCorrect = numCorrect;
    }

    public int getNumInCorrect() {
        return NumInCorrect;
    }

    public void setNumInCorrect(int numInCorrect) {
        NumInCorrect = numInCorrect;
    }

    public int getTotalQuestions() {
        return TotalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        TotalQuestions = totalQuestions;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public Question getCurrentQu() {
        return CurrentQu;
    }

    public void setCurrentQu(Question currentQu) {
        CurrentQu = currentQu;
    }

    private int TotalQuestions;
    private int Score;
    private Question CurrentQu;

    public Quiz(){
        NumCorrect =0;
        NumInCorrect =0;
        TotalQuestions=0;
        Score=0;
        CurrentQu= new Question(10);
        questions = new ArrayList<Question>();
    }

    public void NewQu(){
        CurrentQu = new Question(TotalQuestions*2 +5);
        TotalQuestions++;
        questions.add(CurrentQu);
    }

    public boolean checkAnswer(int SubAnswer){
        boolean Correct;
        if(CurrentQu.getAnswer()==SubAnswer){
            NumCorrect++;
            Correct=true;
        } else {
            NumInCorrect++;
            Correct=false;
        }
        Score = NumCorrect*10 - NumInCorrect *20;
        return Correct;
    }



}
