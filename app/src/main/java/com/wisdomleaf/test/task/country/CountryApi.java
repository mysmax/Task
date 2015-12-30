package com.wisdomleaf.test.task.country;

import com.wisdomleaf.test.task.utils.Constants;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by chethan on 30-12-2015.
 */
public interface CountryApi {
    @GET(Constants.COUNTRY_URL)
    Call<CountryModel> getCountryData();
}
