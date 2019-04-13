package com.example.minix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    private List<Slide> slides;
    private Context context;
    private LayoutInflater layoutInflater;
    private int custom_position = 0;

    public PagerAdapter(List<Slide> slides, Context context){
        this.slides = slides;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) { return view==0; }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        Slide slide = slides.get(position);
        View itemView = layoutInflater.inflate(R.layout.slider_item_layout,container, false);
        ImageView mImage = itemView.findViewById(R.id.sliderImage);
        TextView mTitle = itemView.findViewById(R.id.slider_subtitle);
        m
        // return super.instantiateItem(container, position);
    }
}
