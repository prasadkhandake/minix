package com.example.minix;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class homer extends AppCompatActivity {
    private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homer);

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new homerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
    private class homerAdapter extends FragmentStatePagerAdapter {
        public homerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return new HomeFragment();
        }
        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
