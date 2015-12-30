package com.wisdomleaf.test.task.country;

import java.util.ArrayList;

/**
 * Created by chethan on 30-12-2015.
 */
public class CountryDataModel {
    private String countryname;
    private String flag;
    private String language;
    private String capital;
    private Currency currency;

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public class Currency {
        private String code;
        private String currencyname;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCurrencyname() {
            return currencyname;
        }

        public void setCurrencyname(String currencyname) {
            this.currencyname = currencyname;
        }
    }
}
