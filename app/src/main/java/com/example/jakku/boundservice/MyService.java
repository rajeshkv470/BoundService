package com.example.jakku.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    // IBinder is used to communication between service and activity
    private final IBinder mybinder = new MyLocalBinder();

    // This is class of Binder, If you want use IBinder you need write  a class
    class MyLocalBinder extends Binder{
        //Myservice is the service doing in background getting that service to binder
        MyService getService(){
            return MyService.this;
        }
    }
    public MyService() {
    }

    public String getCurrentTime(){
        SimpleDateFormat date = new SimpleDateFormat("HH:mm:SS", Locale.US);
        return (date.format(new Date()));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mybinder;
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
