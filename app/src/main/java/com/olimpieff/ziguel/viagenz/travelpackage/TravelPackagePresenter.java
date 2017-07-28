package com.olimpieff.ziguel.viagenz.travelpackage;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;
import com.olimpieff.ziguel.viagenz.utils.AnalyticsUtils;

/**
 * Created by Ziguel on 7/8/17.
 */

class TravelPackagePresenter {

    private final TravelPackageEntity mEntity;
    private final TravelPackageView mView;

    TravelPackagePresenter(TravelPackageEntity travelPackageEntity, TravelPackageView view) {
        mEntity = travelPackageEntity;
        mView = view;
    }

    void onViewCreated() {
        mView.setDescription(mEntity.description);
        mView.setTitle(mEntity.name);
        mView.setFormattedValue(String.format("R$%.2f", mEntity.value));
        mView.setLocationImage(mEntity.locationImageUrl);
    }

    void buyButtonClicked() {
        AnalyticsUtils.sendBuyClickedEvent(mEntity.name, mEntity.value);
        mView.showSnackBarBuy("Comprar clicado, valor: " + String.valueOf(mEntity.value));
    }
}
