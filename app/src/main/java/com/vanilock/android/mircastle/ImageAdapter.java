package com.vanilock.android.mircastle;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
/**
 * Created by Pain on 18.04.2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array


    // Constructor


    public ImageAdapter(Context context) {
        mContext = context;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup) {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mThumbIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(200, 200));

        i.setScaleType(ImageView.ScaleType.FIT_XY);


        return i;
    }

    public Integer[] mThumbIds = {
            R.drawable.j, R.drawable.k,
            R.drawable.l, R.drawable.m,
            R.drawable.n, R.drawable.o,
            R.drawable.p, R.drawable.q,
            R.drawable.q1, R.drawable.q2,
            R.drawable.q3, R.drawable.q4,
            R.drawable.q5, R.drawable.q6,
            R.drawable.q7, R.drawable.q8,
            R.drawable.q9, R.drawable.r,
            R.drawable.s, R.drawable.t,
            R.drawable.u, R.drawable.v,
            R.drawable.w, R.drawable.w1,
            R.drawable.w2, R.drawable.w3,
            R.drawable.w4, R.drawable.w5,
            R.drawable.x, R.drawable.y,
            R.drawable.z};
}
