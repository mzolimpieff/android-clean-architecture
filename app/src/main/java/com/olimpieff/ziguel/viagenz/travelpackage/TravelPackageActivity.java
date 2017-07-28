package com.olimpieff.ziguel.viagenz.travelpackage;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.olimpieff.ziguel.viagenz.R;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;

public class TravelPackageActivity extends AppCompatActivity implements TravelPackageView {

    public static final String TRAVEL_PACKAGE_EXTRA = "TRAVEL";
    private TravelPackagePresenter mPresenter;
    private TextView mTitle;
    private TextView mDescription;
    private ImageView mLocationImage;
    private TextView mValue;
    private CoordinatorLayout mViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_package);

        mViewContainer = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mTitle = (TextView) findViewById(R.id.travel_package_title);
        mDescription = (TextView) findViewById(R.id.travel_package_description);
        mValue = (TextView) findViewById(R.id.travel_package_value);
        mLocationImage = (ImageView) findViewById(R.id.travel_package_image);

        if (!getIntent().hasExtra(TRAVEL_PACKAGE_EXTRA)) {
            Toast.makeText(this, "activity sem entidade", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        TravelPackageEntity travelPackageEntity = (TravelPackageEntity) getIntent().getSerializableExtra(TRAVEL_PACKAGE_EXTRA);

        mPresenter = new TravelPackagePresenter(travelPackageEntity, this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.buyButtonClicked();
            }
        });

        mPresenter.onViewCreated();
    }

    @Override
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void setDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public void setFormattedValue(String formattedValue) {
        mValue.setText(formattedValue);
    }

    @Override
    public void setLocationImage(String imageUrl) {
        Glide.with(this).load(imageUrl).into(mLocationImage);
    }

    @Override
    public void showSnackBarBuy(String message) {
        Snackbar.make(mViewContainer, message, Snackbar.LENGTH_LONG).show();
    }
}
