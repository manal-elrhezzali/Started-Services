package me.elrhezzalimanal.startedservicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class ExampleOfService extends Service {
    private static final String TAG = "ExampleOfService";

    private int startId = -1;

    public ExampleOfService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    //Executed in the thread which calls the ExampleOfService so make sur that it doesn't block the UI thread
    //This method receives all the intent and calls to the service and it hands them to the onBind method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.startId = startId;
        if (null != intent) {
            int number = intent.getIntExtra("number", -1);
            if (number != -1) {
               //create a thread on your own , the onStartCommand runs in the background
                // which means it is not visible to the user , it runs on the UI thread
                // so to run it on a worker thread
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < number; i++) {
                            Log.d(TAG, "onHandleIntent: " + "value of i was " + i);
                            SystemClock.sleep(1000);
                        }
                    }
                });
                thread.start();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
    //use it to stop the service
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();//cancels all of the calls to this service
        stopSelf(startId);//to stop a service that has this startId
    }
}