package com.teojincheng.walkingapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Service that runs the stopwatch
 */

public class StopWatchService extends Service {

    private String TAG = "walkingApp";
    private String S_INTENT_KEY = "sKey";
    private String START_WATCH = "start";
    private String STOP_WACTH = "stop";
    StopWatch stopWatch = new StopWatch();

    public StopWatchService() {

    }

    public class LocalBinder extends Binder {
        StopWatchService getService() {
            return StopWatchService.this;
        }
    }

    private final IBinder mBinder = new LocalBinder();


    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /*
    When the service is started, start stopwatch.
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
        stopWatch.start();


        return START_STICKY;
    }

    /* return how much time has passed in seconds */
    public long getElapsedTime() {
        return stopWatch.getElapsedTime();
    }


    @Override
    public boolean stopService(Intent name) {
        stopWatch.stop();
        return super.stopService(name);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopWatch.stop();
    }
}
