package com.olimpieff.ziguel.viagenz.domain.base;

/**
 * Created by Ziguel on 7/8/17.
 */

public abstract class Interactor implements Runnable{
    protected final InteractorExecutor mInteractorExecutor;
    protected final MainThread mMainThread;

    public Interactor(InteractorExecutor interactorExecutor, MainThread mainThread) {
        this.mInteractorExecutor = interactorExecutor;
        this.mMainThread = mainThread;
    }
}
