package com.wisdomleaf.test.task.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wisdomleaf.test.task.R;

import java.util.ArrayList;

/**
 * Created by chethan on 30-12-2015.
 */
public class CountryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CountryDataModel>  countryList;

    public CountryAdapter(Context context, ArrayList<CountryDataModel> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @Override

    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View country;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            country = new View(context);
            country = inflater.inflate(R.layout.item_country, null);
            ImageView countryFlag = (ImageView) country.findViewById(R.id.country_flag);
            Picasso.with(context)
                    .load(countryList.get(i).getFlag())
                    .placeholder(R.drawable.ic_place_holder)
                    .error(android.R.drawable.stat_notify_error)
                    .fit().centerCrop()
                    .into(countryFlag);
            TextView countryName = (TextView) country.findViewById(R.id.txt_country_name);
            countryName.setText(countryList.get(i).getCountryname());
            TextView contryLanguage = (TextView) country.findViewById(R.id.txt_country_language);
            contryLanguage.setText(countryList.get(i).getLanguage());
            TextView countryCapital = (TextView) country.findViewById(R.id.txt_country_capital);
            countryCapital.setText(countryList.get(i).getCapital());
            TextView countryCurrencyName = (TextView) country.findViewById(R.id.txt_country_currency_name);
            countryCurrencyName.setText(countryList.get(i).getCurrency().getCurrencyname());
            TextView countryCurrencyCode = (TextView) country.findViewById(R.id.txt_country_currency_code);
            countryCurrencyCode.setText(countryList.get(i).getCurrency().getCode());


        } else {
            country = (View) view;
        }
        return country;
    }
}
