package com.example.disenosubasta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;


public class JoinActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ImageButton joinBtn;
    private EditText name, id, password, password_chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        joinBtn = (ImageButton) findViewById(R.id.joinBtn);
        name = (EditText) findViewById(R.id.name);
        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
        password_chk = (EditText) findViewById(R.id.password_check);

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()) {
                    if (!id.getText().toString().isEmpty()) {
                        if (!password.getText().toString().isEmpty() && password.getText().toString().equals(password_chk.getText().toString())) {
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference();

                            User user = new User(id.getText().toString(), name.getText().toString(), password.getText().toString());
//                            myRef.child("account").child(id.getText().toString()).setValue(user);

                            myRef.child("account").orderByChild("id").equalTo(id.getText().toString()).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // This method is called once with the initial value and again
                                    // whenever data at this location is updated.
                                    Map<String, String> value = (Map) dataSnapshot.getValue();
                                    Log.d(TAG, "Value is: " + value.keySet());
                                }

                                @Override
                                public void onCancelled(DatabaseError error) {
                                    // Failed to read value
                                    Log.w(TAG, "Failed to read value.", error.toException());
                                }
                            });

                        } else {
                            Toast.makeText(getApplicationContext(), "Password Check Error", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Id Error", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Name Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void title(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.homeBtn:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.mypageBtn:
                intent = new Intent(this, MypageActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                break;
        }
    }

    public class User {
        public String name;
        public String id;
        public String password;

        public User() {

        }

        public User(String id, String name, String password) {
            this.name = name;
            this.id = id;
            this.password = password;
        }
    }
}
