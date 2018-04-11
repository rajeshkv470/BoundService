package com.example.jakku.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyService connectservice;
    boolean isBound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                //binding service from activtiy  to my service through a service connection
                bindService(intent, connect, Context.BIND_AUTO_CREATE);
//            }
//        });
 }

    public void showTime(View view){
        String currenttime = connectservice.getCurrentTime();
        TextView text = (TextView) findViewById(R.id.textview1);
        text.setText(currenttime);
    }
// Service connection from Myservice to Activity
   private ServiceConnection connect = new ServiceConnection() {
       @Override
       public void onServiceConnected(ComponentName name, IBinder service) {
          MyService.MyLocalBinder binder = (MyService.MyLocalBinder) service;
           connectservice = binder.getService();
           isBound = true;

       }

       @Override
       public void onServiceDisconnected(ComponentName name) {
            isBound = false;
       }
   };
}
