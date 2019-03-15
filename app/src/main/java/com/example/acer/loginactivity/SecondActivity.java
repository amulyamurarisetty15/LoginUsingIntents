package com.example.acer.loginactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends MainActivity {
    EditText ev1,ev2;
    Button but1;
    String s1,s2;
    SharedPreferences sp;
    private String spFile="com.example.acer.loginactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ev1=findViewById(R.id.mail2);
        ev2=findViewById(R.id.pass2);
        but1=findViewById(R.id.ok);
        sp=getApplicationContext().getSharedPreferences(spFile,MODE_PRIVATE);
        ev1.setText(sharedPreferences.getString("MailId",""));
        ev2.setText(sharedPreferences.getString("Password2",""));

    }
    public void done(View view) {
        s1=ev1.getText().toString();
        s2=ev2.getText().toString();
        Intent i = getIntent();
        if ((i.hasExtra("mail")) && (i.hasExtra("password"))) {
            if ((s1.equals(i.getStringExtra("mail")))&&(s2.equals(i.getStringExtra("password"))) ){

                Toast.makeText(this, "Success to continue...", Toast.LENGTH_SHORT).show();
            }

             else{
                Toast.makeText(this, "Sorry enter details properly!!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        s1=ev1.getText().toString();
        s2=ev2.getText().toString();


        editor.putString("MailId", st1);
        editor.putString("Password2",st2);
        editor.commit();
    }
}
