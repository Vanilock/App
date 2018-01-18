package com.vanilock.android.mircastle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Pain on 14.04.2017.
 */

public class ItemsMainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view_main, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.first_activity, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.zal_image);
            name = (TextView) itemView.findViewById(R.id.zal_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Intent intent;
                    Context context = v.getContext();

                    switch (getAdapterPosition()){
                        case 0:
                            intent =  new Intent(context, Exhibit1Activity.class);
                            break;
                        case 1:
                            intent =  new Intent(context, Exhibit2Activity.class);
                            break;
                        case 2:
                            intent =  new Intent(context, Exhibit3Activity.class);
                            break;
                        case 3:
                            intent =  new Intent(context, Exhibit4Activity.class);
                            break;
                        case 4:
                            intent =  new Intent(context, Exhibit5Activity.class);
                            break;
                        case 5:
                            intent =  new Intent(context, Exhibit6Activity.class);
                            break;
                        case 6:
                            intent =  new Intent(context, Exhibit7Activity.class);
                            break;
                        default:
                            intent =  new Intent(context, MainActivity.class);
                            break;

                    }
                    context.startActivity(intent);
                }
            });




        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 7;

        private final String[] mZal;

        private final Drawable[] mZalPictures;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mZal = resources.getStringArray(R.array.zal);

            TypedArray a = resources.obtainTypedArray(R.array.zal_picture);
            mZalPictures = new Drawable[a.length()];
            for (int i = 0; i < mZalPictures.length; i++) {
                mZalPictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mZalPictures[position % mZalPictures.length]);
            holder.name.setText(mZal[position % mZal.length]);

        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
