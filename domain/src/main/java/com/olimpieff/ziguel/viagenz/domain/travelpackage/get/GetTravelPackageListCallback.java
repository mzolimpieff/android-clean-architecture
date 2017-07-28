package com.olimpieff.ziguel.viagenz.domain.travelpackage.get;

import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/8/17.
 */
public interface GetTravelPackageListCallback {
    void onSuccess(ArrayList<TravelPackageEntity> travelPackageEntities);

    void onError(Throwable t);
}
