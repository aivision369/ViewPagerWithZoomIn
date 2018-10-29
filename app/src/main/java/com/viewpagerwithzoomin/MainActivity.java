package com.viewpagerwithzoomin;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private int[] imageList = {R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3, R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3};
    private ViewPager viewpagerImages;
    AdapterEventImages adapterEventImages;
    private boolean isEnabledPagePadding;
    private int padding =20;
    private RelativeLayout rlParentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpagerImages = (ViewPager) findViewById(R.id.viewpager_event_images);
        rlParentMain = (RelativeLayout) findViewById(R.id.rl_parent_main);
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
            rlParentMain.setPadding(0,0,0,0);
        } else {
            rlParentMain.setPadding(padding,0,padding,0);
        }
    }

}
