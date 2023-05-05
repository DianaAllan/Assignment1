package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MathGame extends AppCompatActivity {

    Button Start,A,B,C,D;
    TextView textView1 , textView2, textView3, textView4;
    ProgressBar timer;
    Quiz q = new Quiz();
    int SecRem=30;
    CountDownTimer timer1= new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            SecRem--;
            textView1.setText(Integer.toString(SecRem)+" Sec");
            timer.setProgress(30-SecRem);
        }

        @Override
        public void onFinish() {
            A.setEnabled(false);
            B.setEnabled(false);
            C.setEnabled(false);
            D.setEnabled(false);
            textView4.setText("Time Is Up! "+ q.getNumCorrect()+"/"+(q.getTotalQuestions()-1) );

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Start.setVisibility(View.VISIBLE);
                }
            },4000);


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Start = findViewById(R.id.start);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        textView1 = findViewById(R.id.textView1);
        textView3 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView4);
        timer = findViewById(R.id.timer);



        View.OnClickListener startBtn = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Button StartBtt = (Button) v;
                StartBtt.setVisibility(View.INVISIBLE);
                SecRem =30;
                q= new Quiz();
                nextTurn();
                timer1.start();
            }
        };


        View.OnClickListener answerButtonClickListenet = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Button clicked = (Button) v;
                int answerSelected = Integer.parseInt(clicked.getText().toString()) ;
                q.checkAnswer(answerSelected);
                textView3.setText(Integer.toString(q.getScore())+" Points");
                nextTurn();
            }
        };

        Start.setOnClickListener(startBtn);
        A.setOnClickListener(answerButtonClickListenet);
        B.setOnClickListener(answerButtonClickListenet);
        C.setOnClickListener(answerButtonClickListenet);
        D.setOnClickListener(answerButtonClickListenet);


    }

    private void nextTurn() {
        q.NewQu();
        int [] answer = q.getCurrentQu().getAnswerArray();
        A.setText(Integer.toString(answer[0]));
        B.setText(Integer.toString(answer[1]));
        C.setText(Integer.toString(answer[2]));
        D.setText(Integer.toString(answer[3]));

        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);

        textView2.setText(q.getCurrentQu().getQu());
        textView4.setText(q.getNumCorrect()+"/"+(q.getTotalQuestions()-1));

    }
}




