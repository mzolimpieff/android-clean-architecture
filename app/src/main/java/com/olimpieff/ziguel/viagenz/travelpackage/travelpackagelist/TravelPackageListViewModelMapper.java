package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import android.support.annotation.NonNull;

import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/8/17.
 */
class TravelPackageListViewModelMapper {
    static ArrayList<TravelPackageListViewModel> fromEntity(@NonNull ArrayList<TravelPackageEntity> travelPackageEntities) {
        ArrayList<TravelPackageListViewModel> viewModelList = new ArrayList<>();

        for (TravelPackageEntity travelPackageEntity : travelPackageEntities) {
            TravelPackageListViewModel viewModel = new TravelPackageListViewModel();
            viewModel.title = travelPackageEntity.name;
            viewModel.imageUrl = travelPackageEntity.locationImageUrl;
            viewModel.value = moneyfy(travelPackageEntity.value);

            viewModelList.add(viewModel);
        }
        return viewModelList;
    }

    private static String moneyfy(double value) {
        return "R$" + String.format("%.2f", value);
    }
}
