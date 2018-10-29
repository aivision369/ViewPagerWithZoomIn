package com.viewpagerwithzoomin;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int[] imageList = {R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3};
    private ViewPager viewpagerImages;
    AdapterEventImages adapterEventImages;
    private boolean isEnabledPagePadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpagerImages = (ViewPager) findViewById(R.id.viewpager_event_images);
        isEnabledPagePadding = true;
        setViewpagerSetting(!isEnabledPagePadding);
        adapterEventImages = new AdapterEventImages(MainActivity.this, imageList, onTouchListener, isEnabledPagePadding);
        viewpagerImages.setAdapter(adapterEventImages);
        adapterEventImages.notifyDataSetChanged();

    }

    AdapterEventImages.OnTouchListener onTouchListener = new AdapterEventImages.OnTouchListener() {
        @Override
        public void onTouch(boolean isZoom) {
            if (isZoom) {
                setViewpagerSetting(true);
            } else {
                setViewpagerSetting(false);
            }
        }
    };

    private void setViewpagerSetting(boolean isZoomed) {
        if (isZoomed) {
            viewpagerImages.setPadding(0, 0, 0, 0);
            viewpagerImages.setClipChildren(false);
            viewpagerImages.setPageMargin(0);
        } else {
            viewpagerImages.setPadding(20, 0, 20, 0);
            viewpagerImages.setClipChildren(false);
            viewpagerImages.setPageMargin(30);
        }
    }
}
