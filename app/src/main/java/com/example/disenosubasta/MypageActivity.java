package com.example.disenosubasta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {
    private ImageButton loginBtn, joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (ImageButton) findViewById(R.id.loginBtn);
        joinBtn = (ImageButton) findViewById(R.id.joinBtn);
    }

    public void title(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.homeBtn:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
                break;
        }
    }
}
