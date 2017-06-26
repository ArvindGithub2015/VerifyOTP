package com.arv.verifyotp.simpleintegration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arv.verifyotp.MainActivity;
import com.arv.verifyotp.R;

public class MainSmsActivity extends AppCompatActivity {

    EditText ed_otp;
    TextView tv_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sms);

        ed_otp = (EditText)findViewById(R.id.ed_otp);

        tv_otp = (TextView)findViewById(R.id.tv_otp);

    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.i("Arv", "senderNum: ");

            final Bundle bundle = intent.getExtras();

            arv(bundle);
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");
                //Do whatever you want with the code here
                ed_otp.setText(message);
            }
        }
    };

    private void arv(Bundle bundle){
        for(String key : bundle.keySet()){
            Log.d("ARV","Arv-->"+bundle.getString(key));   //later parse it as per your required type
        }
    }

    @Override
    public void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

}
