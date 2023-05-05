package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView emailtxt,nametxt;
    Button start;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF = "myPref";
    private static final String Email = "email";
    private static final String namee = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        emailtxt = findViewById(R.id.Email1);
        nametxt = findViewById(R.id.name1);

        start = findViewById(R.id.start11);

        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        String name = sharedPreferences.getString(namee,null);
        String email = sharedPreferences.getString(Email,null);


            emailtxt.setText(" Your Email : " + email);
            nametxt.setText(" Welcome To My Assignment2 : " + name);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), MainStartActivity.class);
                startActivity(intent);
            }
        });


    }
}