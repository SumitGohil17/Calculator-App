package com.example.intercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Create a new thread for handling the splash screen delay
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // Sleep for 2000 milliseconds (2 seconds)
                    sleep(2000);

                    // Start the MainActivity and finish the current activity
                    startActivity(new Intent(splashScreen.this, MainActivity.class));
                    finish();

                } catch (Exception e) {
                    // Handle any exceptions that might occur during the thread execution
                    e.printStackTrace();
                }
                // Ensure the superclass's run method is called
                super.run();
            }
        };

        // Start the thread
        thread.start();
    }
}
