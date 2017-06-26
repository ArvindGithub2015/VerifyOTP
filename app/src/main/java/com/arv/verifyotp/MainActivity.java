package com.arv.verifyotp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arv.verifyotp.simpleintegration.MainSmsActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, MainSmsActivity.class));
        finish();

        Log.d("Arv","ARV-->");
    }
}
