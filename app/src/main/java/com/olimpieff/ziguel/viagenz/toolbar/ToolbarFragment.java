package com.olimpieff.ziguel.viagenz.toolbar;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.olimpieff.ziguel.viagenz.R;

/**
 * Created by Ziguel on 7/10/17.
 */

public class ToolbarFragment extends Fragment implements ToolbarView {

    private ToolbarPresenter mPresenter;
    private ImageView mBack;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ToolbarPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_toolbar, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBack = (ImageView) view.findViewById(R.id.toolbar_back_button);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onBackClicked();
            }
        });
    }

    @Override
    public void goBack() {
        getActivity().finish();
    }
}
