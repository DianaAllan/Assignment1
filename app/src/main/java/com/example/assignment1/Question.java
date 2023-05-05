package com.example.assignment1;

import java.util.Random;

public class Question {

    private int Num1;
    private int Num2;
    private int [] AnswerArray;
    private int Position;
    private int answer;
    private int UpperLimit;
    private String Qu;


    public Question(int UpperLimit){
        this.UpperLimit= UpperLimit;
        Random RandNum = new Random();
        this.Num1 = RandNum.nextInt(UpperLimit);
        this.Num2 = RandNum.nextInt(UpperLimit);
        this.answer= this.Num1-Num2;
        this.Qu = Num1 + " - " + Num2 + " = ";

        this.Position= RandNum.nextInt(4);
        this.AnswerArray = new int[] {0,1,2,3} ;
        this.AnswerArray[0] = answer +1;
        this.AnswerArray[1] = answer;
        this.AnswerArray[2] = answer -2;
        this.AnswerArray[3] = answer +2;

        this.AnswerArray = shuffleArray(this.AnswerArray);
        AnswerArray [Position]=answer;
    }

    private int [] shuffleArray(int [] arr){
        int index, temp;
        Random RandNum = new Random();
        for (int i = arr.length -1 ; i>0 ; i--){
            index= RandNum.nextInt(i+1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
      return arr;
    }

    public int getNum1() {
        return Num1;
    }

    public void setNum1(int num1) {
        Num1 = num1;
    }

    public int getNum2() {
        return Num2;
    }

    public void setNum2(int num2) {
        Num2 = num2;
    }

    public int[] getAnswerArray() {
        return AnswerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        AnswerArray = answerArray;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public int getUpperLimit() {
        return UpperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        UpperLimit = upperLimit;
    }

    public String getQu() {
        return Qu;
    }

    public void setQu(String qu) {
        Qu = qu;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
