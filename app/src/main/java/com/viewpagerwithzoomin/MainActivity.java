package com.viewpagerwithzoomin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExtendedViewPager viewpager_images = (ExtendedViewPager)findViewById(R.id.viewpager_event_images);
        int []imageList = {R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3};

        AdapterEventImages adapterEventImages = new AdapterEventImages(MainActivity.this, imageList);
        if (adapterEventImages != null)
        {
            viewpager_images.setAdapter(adapterEventImages);
            adapterEventImages.notifyDataSetChanged();
        }
    }
}
