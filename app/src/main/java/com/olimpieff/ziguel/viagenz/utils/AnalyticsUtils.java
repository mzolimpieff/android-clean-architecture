package com.olimpieff.ziguel.viagenz.utils;

import android.util.Log;

/**
 * Created by Matheus on 10/07/17.
 */

public class AnalyticsUtils {

    private static final String TAG = "AnalyticsUtils";

    public static void sendApplicationStartEvent() {
        sendEvent(assembleAnalyticsEvent("applicationStart", DeviceUtils.getModel(), DeviceUtils.getManufacturer(), DeviceUtils.getAndroidVersion()));
    }

    public static void sendItemClicked(String name) {
        String event = "ItemClicked | ItemName: "+ name;
        sendEvent(assembleAnalyticsEvent(event, DeviceUtils.getModel(), DeviceUtils.getManufacturer(), DeviceUtils.getAndroidVersion()));
    }

    public static void sendBuyClickedEvent(String name, double value) {
        String event = "BuyClicked | ItemName: "+ name + " | ItemValue: " + String.valueOf(value);
        sendEvent(assembleAnalyticsEvent(event, DeviceUtils.getModel(), DeviceUtils.getManufacturer(), DeviceUtils.getAndroidVersion()));
    }

    private static String assembleAnalyticsEvent(String event, String deviceModel, String deviceManufacturer, String androidVersion) {
        return "Event: "+event+" |"+"DeviceModel: "+deviceModel+" |DeviceManufacturer: "+deviceManufacturer+" |AndroidVersion: " +androidVersion;
    }

    private static void sendEvent(String event) {
        //TODO: enviar para plataforma de analytics, não informada.
        Log.d(TAG, event);
    }
}
