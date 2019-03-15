package com.example.acer.loginactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1,e2,e3;
    Button b1;
    SharedPreferences sharedPreferences;
    private String spFileName="com.example.acer.loginactivity";

    String st1,st2,st3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.name);
        e2 = findViewById(R.id.mail);
        e3 = findViewById(R.id.password);
        b1 = findViewById(R.id.sub);
        sharedPreferences=getApplicationContext().getSharedPreferences(spFileName,MODE_PRIVATE);
       ed1.setText(sharedPreferences.getString("Name",""));
        e2.setText(sharedPreferences.getString("Mail",""));
        e3.setText(sharedPreferences.getString("Password",""));

    }

    public void submit(View view) {
        st1=e2.getText().toString();
        st2=e3.getText().toString();

            Intent i = new Intent(getApplicationContext(), SecondActivity.class);
            i.putExtra("mail",st1);
            i.putExtra("password",st2);
            startActivity(i);
        }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        st1=e2.getText().toString();
        st2=e3.getText().toString();
        st3=ed1.getText().toString();

        editor.putString("Name",st3);
        editor.putString("Mail", st1);
        editor.putString("Password",st2);
        editor.commit();
    }
}
