package com.olimpieff.ziguel.viagenz;

import android.app.Application;

import com.olimpieff.ziguel.viagenz.utils.AnalyticsUtils;

/**
 * Created by Matheus on 10/07/17.
 */

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AnalyticsUtils.sendApplicationStartEvent();
    }
}
