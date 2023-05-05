package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public EditText SEmail;
    EditText name;
    SharedPreferences sharedPreferences;
    Button Save;

    private static final String SHARED_PREF = "myPref";
    private static final String Email = "email";
    private static final String namee = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        Save = (Button)findViewById(R.id.start11);
        SEmail = (EditText) findViewById(R.id.Email);
        name = (EditText) findViewById(R.id.name);

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);







        Save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                String username = SEmail.getText().toString();
                String namee1 = name.getText().toString();

                if(username.equals("")||namee1.equals("")) {
                    if (username.equals("")) {
                        SEmail.setError("Field can't be empty");
                    }
                    if (namee1.equals("")) {
                        name.setError("Field can't be empty");
                    }
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(Email,username);
                        editor.putString(namee,namee1);
                        editor.apply();
                        Intent intent  = new Intent(getApplicationContext(), WelcomeActivity.class);
                        startActivity(intent);
                    }
                }

        });


    }
}