package com.example.minix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    private List<Slide> slides;
    private Context context;
    private LayoutInflater layoutInflater;

    public PagerAdapter(List<Slide> slides, Context context){
        this.slides = slides;
        this.context = context;
        layoutInflater =
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }
}
