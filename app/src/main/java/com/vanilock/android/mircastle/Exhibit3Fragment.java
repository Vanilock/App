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

/**
 * Created by Pain on 15.04.2017.
 */

public class Exhibit3Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        Exhibit3Fragment.ContentAdapter adapter = new Exhibit3Fragment.ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_exhibit3, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, Exhibit3DetailActivity.class);
                    intent.putExtra(Exhibit3DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });




        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<Exhibit3Fragment.ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 5;

        private final String[] mExhibit;
        private final String[] mExhibitDesc;
        private final Drawable[] mExhibitPictures;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mExhibit = resources.getStringArray(R.array.exhibit_podval);
            mExhibitDesc = resources.getStringArray(R.array.podval_desc);
            TypedArray a = resources.obtainTypedArray(R.array.podval_picture);
            mExhibitPictures = new Drawable[a.length()];
            for (int i = 0; i < mExhibitPictures.length; i++) {
                mExhibitPictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public Exhibit3Fragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Exhibit3Fragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(Exhibit3Fragment.ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mExhibitPictures[position % mExhibitPictures.length]);
            holder.name.setText(mExhibit[position % mExhibit.length]);
            holder.description.setText(mExhibitDesc[position % mExhibitDesc.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
