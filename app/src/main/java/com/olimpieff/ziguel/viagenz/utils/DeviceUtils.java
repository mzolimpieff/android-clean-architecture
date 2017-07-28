package com.olimpieff.ziguel.viagenz.utils;


import android.os.Build;

/**
 * Created by Matheus on 10/07/17.
 */

public class DeviceUtils {
    public static String getManufacturer() {
        return android.os.Build.MANUFACTURER;
    }

    public static String getModel() {
        return android.os.Build.MODEL;
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }
}
