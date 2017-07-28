package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/8/17.
 */
public interface TravelPackageListView {
    void updateListContent(ArrayList<TravelPackageListViewModel> travelPackageListViewModels);

    void showContentUnavailable();
}
