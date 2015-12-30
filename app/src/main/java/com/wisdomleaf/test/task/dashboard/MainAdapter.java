package com.wisdomleaf.test.task.dashboard;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wisdomleaf.test.task.R;
import com.wisdomleaf.test.task.country.CountryFragment;
import com.wisdomleaf.test.task.music.MusicFragment;
import com.wisdomleaf.test.task.utils.Constants;

/**
 * Created by chethan on 29-12-2015.
 */
public class MainAdapter extends FragmentPagerAdapter {

    private String[] tabs;
    private Context context;

    public MainAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.tabs = context.getResources().getStringArray(R.array.dash_board_tabs);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CountryFragment();
            case 1:
                return new MusicFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return Constants.NUMBER_OF_TABS;
    }
}
