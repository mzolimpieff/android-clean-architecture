package com.olimpieff.ziguel.viagenz.travelpackage.travelpackagelist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.olimpieff.ziguel.viagenz.R;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/8/17.
 */

public class TravelPackageListAdapter extends RecyclerView.Adapter<TravelPackageViewHolder> {
    private final Context mContext;
    private final TravelPackageClickListener mClickListener;
    private ArrayList<TravelPackageListViewModel> mTravels;

    public TravelPackageListAdapter(Context mContext, TravelPackageClickListener mClickListener) {
        this.mContext = mContext;
        this.mClickListener = mClickListener;
    }

    @Override
    public TravelPackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_travel_package, parent, false);
        return new TravelPackageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TravelPackageViewHolder holder, final int position) {
        TravelPackageListViewModel viewModel = mTravels.get(position);

        holder.mTitle.setText(viewModel.title);
        holder.mValue.setText(viewModel.value);
        holder.mProgress.setVisibility(View.VISIBLE);
        if (viewModel.imageUrl != null)
            Glide.with(mContext.getApplicationContext())
                   .load(viewModel.imageUrl).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    holder.mProgress.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    holder.mProgress.setVisibility(View.GONE);
                    return false;
                }
            }).into(holder.mImageView);

        holder.mClickableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onClickTravelPackage(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mTravels != null)
            return mTravels.size();
        return 0;
    }

    public void update(ArrayList<TravelPackageListViewModel> viewModels) {
        this.mTravels = viewModels;
        notifyDataSetChanged();
    }
}
