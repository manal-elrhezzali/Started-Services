package me.elrhezzalimanal.startedservicesdemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;


public class ExampleOfIntentService extends IntentService {
    private static final String TAG = "ExampleOfIntentService";

//    /**
//     * Creates an IntentService.  Invoked by your subclass's constructor.
//     *
//     * @param name Used to name the worker thread, important only for debugging.
//     */
//    public ExampleOfIntentService(String name) {
//        super(name);
//    }


    public ExampleOfIntentService() {
        super("Download thread");
    }

    //executes task in a background thread to avoid blocking user from interacting with UI,
    // note that the max time allowed to block user is 5 seconds
    // (time > 5s => ANR : app not responding  dialog)
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (null != intent) {
            int number = intent.getIntExtra("number", -1);
            for (int i = 0; i < number; i++) {
                Log.d(TAG, "onHandleIntent: " + "value of i was " + i);
                SystemClock.sleep(1000);
            }
        }

    }
}