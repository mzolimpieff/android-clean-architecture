package com.olimpieff.ziguel.viagenz;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;
import com.olimpieff.ziguel.viagenz.travelpackage.TravelPackageActivity;

/**
 * Created by Ziguel on 7/9/17.
 */

public class ScreenManager {
    public static void goToTravelPackageDetail(Context context, TravelPackageEntity entity) {
        Intent intent = new Intent(context, TravelPackageActivity.class);
        intent.putExtra(TravelPackageActivity.TRAVEL_PACKAGE_EXTRA, entity);

        ActivityCompat.startActivity(context, intent, null);
    }
}
