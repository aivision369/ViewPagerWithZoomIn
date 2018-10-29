package com.viewpagerwithzoomin;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class AdapterEventImages extends PagerAdapter {


    private Context mContext;
    private int [] imageList;
    private OnTouchListener onTouchListener;
    private boolean isEnabledPagePadding;

    protected AdapterEventImages(Context mContext, int[] imageList, OnTouchListener onTouchListener, boolean isEnabledPagePadding) {
        this.mContext = mContext;
        this.imageList = imageList;
        this.onTouchListener = onTouchListener;
        this.isEnabledPagePadding =isEnabledPagePadding;
    }

    @Override
    public int getCount() {
        return imageList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.event_image_pager, container, false);

        final TouchImageView image = (TouchImageView)itemView.findViewById(R.id.iv_event_pager);
        image.setImageResource(imageList[position]);
        container.addView(itemView);
        if (isEnabledPagePadding){
            image.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (image.getCurrentZoom() > 1.0) {
                        onTouchListener.onTouch(true);
                    } else {

                        onTouchListener.onTouch(false);
                    }
                    return false;
                }
            });
        }
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    interface  OnTouchListener{
        void onTouch(boolean isZoom);
    }
}
