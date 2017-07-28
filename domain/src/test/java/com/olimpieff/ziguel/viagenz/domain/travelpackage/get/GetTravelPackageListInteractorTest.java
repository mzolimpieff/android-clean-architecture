package com.olimpieff.ziguel.viagenz.domain.travelpackage.get;


import com.olimpieff.ziguel.viagenz.domain.base.MainThread;
import com.olimpieff.ziguel.viagenz.domain.base.ThreadExecutor;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

/**
 * Created by Matheus on 10/07/17.
 */
public class GetTravelPackageListInteractorTest {
    private static final long TIMEOUT = 300;
    private GetTravelPackageListCallback mCallback = Mockito.mock(GetTravelPackageListCallback.class);
    private final Throwable mThrowable = new Throwable("mock");
    private ArrayList<TravelPackageEntity> mEntities = new ArrayList<>();

    private MainThread mMainThread = new MainThread() {
        @Override
        public void post(Runnable runnable) {
            runnable.run();
        }
    };

    @Test
    public void getTravelPackageListInteractorSuccess() {
        GetTravelPackageListRepositoryContract repo = new GetTravelPackageListRepositoryContract() {
            @Override
            public void getTravelPackageList(GetTravelPackageListCallback callback) {
                callback.onSuccess(mEntities);
            }
        };

        GetTravelPackageListInteractor interactor = new GetTravelPackageListInteractor(ThreadExecutor.getInstance(), mMainThread, repo);
        interactor.getTravelPackageList(mCallback);

        Mockito.verify(mCallback, Mockito.timeout(TIMEOUT).times(0)).onError(mThrowable);
        Mockito.verify(mCallback, Mockito.timeout(TIMEOUT).times(1)).onSuccess(mEntities);
    }

    @Test
    public void getTravelPackageListInteractorFailure() {
        GetTravelPackageListRepositoryContract repo = new GetTravelPackageListRepositoryContract() {
            @Override
            public void getTravelPackageList(GetTravelPackageListCallback callback) {
                callback.onError(mThrowable);
            }
        };

        GetTravelPackageListInteractor interactor = new GetTravelPackageListInteractor(ThreadExecutor.getInstance(), mMainThread, repo);
        interactor.getTravelPackageList(mCallback);

        Mockito.verify(mCallback, Mockito.timeout(TIMEOUT).times(1)).onError(mThrowable);
        Mockito.verify(mCallback, Mockito.timeout(TIMEOUT).times(0)).onSuccess(mEntities);
    }
}