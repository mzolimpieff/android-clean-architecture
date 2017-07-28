package com.olimpieff.ziguel.viagenz.travelpackage;

/**
 * Created by Ziguel on 7/8/17.
 */

interface TravelPackageView {
    void setTitle(String title);
    void setDescription(String description);
    void setFormattedValue(String formattedValue);
    void setLocationImage(String imageUrl);
    void showSnackBarBuy(String message);
}
