package com.example.disenosubasta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void title(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.mypageBtn:
                intent = new Intent(this, MypageActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
