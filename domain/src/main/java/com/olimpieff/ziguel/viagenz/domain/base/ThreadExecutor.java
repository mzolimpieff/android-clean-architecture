package com.olimpieff.ziguel.viagenz.domain.base;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ziguel on 7/8/17.
 */

public class ThreadExecutor implements InteractorExecutor {
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();
    private static ThreadExecutor INSTANCE;
    private final ThreadPoolExecutor threadPoolExecutor;

    private ThreadExecutor() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    public static ThreadExecutor getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ThreadExecutor();
        return INSTANCE;
    }

    @Override
    public void run(Interactor interactor) {
        if(interactor != null) {
            threadPoolExecutor.submit(interactor);
        }
    }
}
