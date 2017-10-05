package com.out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;
import com.out.R;

public class testActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onTestButtonClick(View view) {
        String firebaseUserId = FirebaseInstanceId.getInstance().getToken();
        Intent intent = new Intent(testActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
