package com.wisdomleaf.test.task.country;

import java.util.ArrayList;

/**
 * Created by chethan on 30-12-2015.
 */
public class CountryModel {
  public ArrayList<CountryDataModel> countries = new ArrayList<CountryDataModel>();

    public ArrayList<CountryDataModel> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<CountryDataModel> countries) {
        this.countries = countries;
    }
}
