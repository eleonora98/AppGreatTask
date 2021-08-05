package com.example.appgreattask.MainTabsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appgreattask.Adapters.TabsAdapter;
import com.example.appgreattask.R;
import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        initTabs();
    }

    private void initTabs(){

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        TabLayout.Tab tab1 = tabLayout.newTab().setText(getString(R.string.images_fragment));
        tabLayout.addTab(tab1);
        TabLayout.Tab tab2 = tabLayout.newTab().setText(getString(R.string.numbers_fragment));
        tabLayout.addTab(tab2);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setTabsAdapter(tabLayout);
    }

    private void setTabsAdapter(TabLayout tabLayout){
        final ViewPager viewPager =(ViewPager)findViewById(R.id.view_pager);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}