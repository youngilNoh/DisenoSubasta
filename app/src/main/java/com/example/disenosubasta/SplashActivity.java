package com.example.disenosubasta;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        } finally {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
