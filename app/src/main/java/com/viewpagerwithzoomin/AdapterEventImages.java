package com.viewpagerwithzoomin;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class AdapterEventImages extends PagerAdapter
{
    public static final String TAG = "[AdapterEventImages]";

    private Context mContext;
    Activity activity;
    int [] imageList;

    public AdapterEventImages(Activity mContext, int [] imageList) {
        this.mContext = mContext;
        activity = mContext;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.event_image_pager, container, false);

        final ImageView image = (ImageView)itemView.findViewById(R.id.iv_event_pager);
        image.setImageResource(imageList[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
