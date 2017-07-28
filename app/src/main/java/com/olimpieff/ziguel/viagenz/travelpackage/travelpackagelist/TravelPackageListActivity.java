package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.olimpieff.ziguel.data.travelpackage.GetTravelPackagesRepository;
import com.olimpieff.ziguel.viagenz.R;
import com.olimpieff.ziguel.viagenz.UIThread;
import com.olimpieff.ziguel.viagenz.domain.base.ThreadExecutor;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListCallback;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListInteractor;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListRepositoryContract;

import java.util.ArrayList;

public class TravelPackageListActivity extends AppCompatActivity implements TravelPackageListView {
    private TravelPackageListPresenter mPresenter;
    private TravelPackageListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_package_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.travel_package_list_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Interactor com repositorio mocado, sem necessidade de request
//        GetTravelPackageListInteractor interactor = new GetTravelPackageListInteractor(
//                ThreadExecutor.getInstance(),
//                UIThread.getInstance(),
//                new GetTravelPackageListRepositoryContract() {
//                    @Override
//                    public void getTravelPackageList(GetTravelPackageListCallback callback) {
//                        ArrayList<TravelPackageEntity> travelPackageEntities = new ArrayList<>();
//
//                        for (int i = 0; i < 10; i++) {
//                            TravelPackageEntity entity = new TravelPackageEntity();
//                            entity.name = "travel " + i;
//                            entity.description = "description travel " + i;
//                            entity.locationImageUrl = "http://cdn.coresites.factorymedia.com/mpora_new/wp-content/uploads/2015/09/iStock_000040603646_Small-680x465.jpg";
//                            entity.value = 3000;
//                            travelPackageEntities.add(entity);
//                        }
//
//                        callback.onSuccess(travelPackageEntities);
//                    }
//                }
//        );

        //interactor com request
        GetTravelPackageListInteractor interactor = new GetTravelPackageListInteractor(
                ThreadExecutor.getInstance(),
                UIThread.getInstance(),
                new GetTravelPackagesRepository(this)
        );

        mPresenter = new TravelPackageListPresenter(this, this, interactor);
        mAdapter = new TravelPackageListAdapter(this, mPresenter);
        recyclerView.setAdapter(mAdapter);
        mPresenter.onViewCreated();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onViewResumed();
    }

    @Override
    public void updateListContent(ArrayList<TravelPackageListViewModel> travelPackageListViewModels) {
        mAdapter.update(travelPackageListViewModels);
    }

    @Override
    public void showContentUnavailable() {

    }
}
