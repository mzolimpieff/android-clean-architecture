package com.olimpieff.ziguel.viagenz.domain.base;

/**
 * Created by Ziguel on 7/8/17.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
