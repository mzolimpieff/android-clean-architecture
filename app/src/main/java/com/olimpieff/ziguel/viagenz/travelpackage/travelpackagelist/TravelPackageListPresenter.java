package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import android.content.Context;

import com.olimpieff.ziguel.viagenz.ScreenManager;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListCallback;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListInteractor;
import com.olimpieff.ziguel.viagenz.utils.AnalyticsUtils;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/8/17.
 */

public class TravelPackageListPresenter implements GetTravelPackageListCallback, TravelPackageClickListener {
    private final TravelPackageListView mView;
    private GetTravelPackageListInteractor mGetTravelPackageListInteractor;
    private Context mContext;
    private ArrayList<TravelPackageEntity> travelPackageEntities;

    public TravelPackageListPresenter(TravelPackageListView mView, Context context, GetTravelPackageListInteractor getTravelPackageListInteractor) {
        this.mView = mView;
        this.mContext = context;
        this.mGetTravelPackageListInteractor = getTravelPackageListInteractor;
    }

    public void onViewCreated() {
        this.mGetTravelPackageListInteractor.getTravelPackageList(this);
    }

    @Override
    public void onSuccess(ArrayList <TravelPackageEntity> travelPackageEntities) {
        this.travelPackageEntities = travelPackageEntities;
        ArrayList<TravelPackageListViewModel> viewModels = TravelPackageListViewModelMapper.fromEntity(travelPackageEntities);
        mView.updateListContent(viewModels);

    }

    @Override
    public void onError(Throwable t) {
        mView.showContentUnavailable();
    }

    @Override
    public void onClickTravelPackage(final int position) {
        TravelPackageEntity entity = travelPackageEntities.get(position);
        AnalyticsUtils.sendItemClicked(entity.name);
        ScreenManager.goToTravelPackageDetail(mContext, entity);
    }

    public void onViewResumed() {
        this.mGetTravelPackageListInteractor.getTravelPackageList(this);
    }
}
