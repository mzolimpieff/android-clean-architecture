package com.olimpieff.ziguel.data.travelpackage;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.TravelPackageEntity;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListCallback;
import com.olimpieff.ziguel.viagenz.domain.travelpackage.get.GetTravelPackageListRepositoryContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ziguel on 7/10/17.
 */

public class GetTravelPackagesRepository implements GetTravelPackageListRepositoryContract {


    private static final String TAG = "GetTravelsRepository";
    private final Context mContext;

    public GetTravelPackagesRepository(Context context) {
        mContext = context;
    }

    @Override
    public void getTravelPackageList(final GetTravelPackageListCallback callback) {
        final String url = "http://private-e36fd8-viagenz.apiary-mock.com/travels";

        JsonArrayRequest getRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "onResponse: " + response.toString());

                        ArrayList<TravelPackageEntity> entities = new ArrayList<>();

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                TravelPackageEntity entity = new TravelPackageEntity();
                                entity.name = object.getString("name");
                                entity.description = object.getString("description");
                                entity.value = object.getDouble("value");
                                entity.locationImageUrl = object.getString("locationImageUrl");
                                entities.add(entity);
                            } catch (JSONException e) {
                                callback.onError(e);
                            }

                            callback.onSuccess(entities);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onError: "+ error.toString());
                        callback.onError(error);
                    }
        });

        Volley.newRequestQueue(mContext).add(getRequest);
    }
}
