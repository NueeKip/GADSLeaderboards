package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



public class SplashScreen extends AppCompatActivity {



    Thread background = new Thread() {
        public void run() {
            try {
                // Thread will sleep for 5 seconds
                sleep(5*1000);

                // After 5 seconds redirect to another intent
                Intent i=new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);

                //Remove activity
                finish();
            } catch (Exception e) {
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        background.start();
    }
}