package com.vanilock.android.mircastle;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pain on 19.04.2017.
 */

public class DetailHistoryActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] exhibit = resources.getStringArray(R.array.history);
        collapsingToolbar.setTitle(exhibit[postion % exhibit.length]);

        String[] exhibitDetails = resources.getStringArray(R.array.details_history);
        TextView exhibitDetail = (TextView) findViewById(R.id.exhibit_detail);
        exhibitDetail.setText(exhibitDetails[postion % exhibitDetails.length]);



        TypedArray exhibitPictures = resources.obtainTypedArray(R.array.history_picture);
        ImageView exhibitPicutre = (ImageView) findViewById(R.id.image);
        exhibitPicutre.setImageDrawable( exhibitPictures.getDrawable(postion %  exhibitPictures.length()));

        exhibitPictures.recycle();
    }
}