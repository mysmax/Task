package com.wisdomleaf.test.task.country;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wisdomleaf.test.task.R;
import com.wisdomleaf.test.task.utils.Common;
import com.wisdomleaf.test.task.utils.Constants;
import com.wisdomleaf.test.task.utils.NetworkAlert;

import java.util.logging.Logger;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by chethan on 29-12-2015.
 */
public class CountryFragment extends Fragment {
    private ListView countryView;
    private Context context;
    private ProgressDialog dialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        dialog = ProgressDialog.show(getActivity(), "Loading...", "Please wait...", true);
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            callWebService();
        } else {
            NetworkAlert alert = new NetworkAlert();
            alert.show(getActivity().getFragmentManager(), "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        countryView = (ListView) view.findViewById(R.id.country_list_view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void callWebService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.COUNTRY_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CountryApi countryApi = retrofit.create(CountryApi.class);
        Call<CountryModel> call = countryApi.getCountryData();
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Response<CountryModel> response, Retrofit retrofit) {
                dialog.dismiss();
                CountryAdapter adapter = new CountryAdapter(context,response.body().getCountries());
                countryView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                if (dialog != null) dialog.dismiss();
                Log.e("CountryFragment", "" + t.getMessage().toString());
            }
        });
    }

}
