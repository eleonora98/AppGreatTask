package com.example.appgreattask.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.appgreattask.ImagesFragment.ImagesFragment;
import com.example.appgreattask.NumbersFragment.NumbersFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;

    public TabsAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ImagesFragment imagesFragment = new ImagesFragment();
                return imagesFragment;
            case 1:
                NumbersFragment numbersFragment = new NumbersFragment();
                return numbersFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

