package com.olimpieff.ziguel.viagenz;

import android.os.Handler;
import android.os.Looper;

import com.olimpieff.ziguel.viagenz.domain.base.MainThread;

/**
 * Created by Ziguel on 7/8/17.
 */

public class UIThread implements MainThread {
    private static UIThread sMainThread;
    private Handler mHandler;

    private UIThread() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static UIThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new UIThread();
        }

        return sMainThread;
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
