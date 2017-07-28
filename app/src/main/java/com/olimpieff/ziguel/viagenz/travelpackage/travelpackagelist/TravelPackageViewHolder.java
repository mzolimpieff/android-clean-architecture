package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.olimpieff.ziguel.viagenz.R;

/**
 * Created by Ziguel on 7/8/17.
 */

public class TravelPackageViewHolder extends RecyclerView.ViewHolder {
    TextView mTitle;
    TextView mValue;
    ImageView mImageView;
    ProgressBar mProgress;
    View mClickableView;

    public TravelPackageViewHolder(View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.travel_package_item_name);
        mValue = (TextView) itemView.findViewById(R.id.travel_package_item_value);
        mImageView = (ImageView) itemView.findViewById(R.id.travel_package_item_image);
        mProgress = (ProgressBar) itemView.findViewById(R.id.progress);
        mClickableView = itemView;
    }

}
