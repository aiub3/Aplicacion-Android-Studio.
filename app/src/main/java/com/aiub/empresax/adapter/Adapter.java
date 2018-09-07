package com.aiub.empresax.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.aiub.empresax.fragments.FirstFragment;
import com.aiub.empresax.fragments.SecondFragment;
import com.aiub.empresax.fragments.ThirdFragment;


public class Adapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public Adapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}

