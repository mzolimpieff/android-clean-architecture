package com.olimpieff.ziguel.viagenz.domain.travelpackage.get;

import com.olimpieff.ziguel.viagenz.domain.base.Interactor;
import com.olimpieff.ziguel.viagenz.domain.base.InteractorExecutor;
import com.olimpieff.ziguel.viagenz.domain.base.MainThread;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/8/17.
 */

public class GetTravelPackageListInteractor extends Interactor implements GetTravelPackageListCallback {
    private GetTravelPackageListCallback mCallback;
    private final GetTravelPackageListRepositoryContract mRepositoryContract;

    public GetTravelPackageListInteractor(InteractorExecutor interactorExecutor, MainThread mainThread, GetTravelPackageListRepositoryContract repository) {
        super(interactorExecutor, mainThread);
        mRepositoryContract = repository;
    }

    @Override
    public void run() {
        mRepositoryContract.getTravelPackageList(this);
    }

    public void getTravelPackageList(GetTravelPackageListCallback callback) {
        this.mCallback = callback;
        this.mInteractorExecutor.run(this);
    }


    @Override
    public void onSuccess(final ArrayList<TravelPackageEntity> travelPackageEntities) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuccess(travelPackageEntities);
            }
        });
    }

    @Override
    public void onError(final Throwable t) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onError(t);
            }
        });
    }
}
