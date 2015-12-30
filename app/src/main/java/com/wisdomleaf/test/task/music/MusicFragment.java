package com.wisdomleaf.test.task.music;

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
import com.wisdomleaf.test.task.country.CountryAdapter;
import com.wisdomleaf.test.task.country.CountryApi;
import com.wisdomleaf.test.task.country.CountryModel;
import com.wisdomleaf.test.task.utils.Constants;
import com.wisdomleaf.test.task.utils.NetworkAlert;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.SimpleXmlConverterFactory;

/**
 * Created by chethan on 29-12-2015.
 */
public class MusicFragment extends Fragment {
    private ListView musicView;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
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
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        musicView = (ListView) view.findViewById(R.id.music_list_view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void callWebService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MUSIC_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        MusicApi countryApi = retrofit.create(MusicApi.class);
        Call<MusicModel> call = countryApi.getMusicData();
        call.enqueue(new Callback<MusicModel>() {
            @Override
            public void onResponse(Response<MusicModel> response, Retrofit retrofit) {
                MusicAdapter adapter = new MusicAdapter(context,response.body().getSong());
                musicView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

                Log.e("MusicFragment", "" + t.getMessage().toString());
            }
        });
    }
}
