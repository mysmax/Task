package com.wisdomleaf.test.task.music;

import com.wisdomleaf.test.task.utils.Constants;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by chethan on 30-12-2015.
 */
public interface MusicApi {
    @GET(Constants.MUSIC_URL)
    Call<MusicModel> getMusicData();
}
