package com.olimpieff.ziguel.viagenz.toolbar;

import android.content.Context;

/**
 * Created by Ziguel on 7/10/17.
 */
public class ToolbarPresenter {

    private final ToolbarView mView;

    public ToolbarPresenter(ToolbarView view) {
        mView = view;
    }

    public void onBackClicked() {
        mView.goBack();
    }
}
