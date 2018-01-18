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

import com.mikhaellopez.circularimageview.CircularImageView;

/**
 * Created by Pain on 19.04.2017.
 */

public class History2Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.activity_history2, container, false);
        History2Fragment.ContentAdapter adapter = new History2Fragment.ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircularImageView picture;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_row2, parent, false));
            picture = (CircularImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.txttitle);
            description = (TextView) itemView.findViewById(R.id.txtdesc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, Detail2HistoryActivity.class);
                    intent.putExtra(Detail2HistoryActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });




        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<History2Fragment.ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 17;

        private final String[] mExhibit;
        private final String[] mExhibitDesc;
        private final Drawable[] mExhibitPictures;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mExhibit = resources.getStringArray(R.array.vlad);
            mExhibitDesc = resources.getStringArray(R.array.vlad_desc);
            TypedArray a = resources.obtainTypedArray(R.array.vlad_picture);
            mExhibitPictures = new Drawable[a.length()];
            for (int i = 0; i < mExhibitPictures.length; i++) {
                mExhibitPictures[i] = a.getDrawable(i);
            }
            a.recycle();
        }

        @Override
        public History2Fragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new History2Fragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(History2Fragment.ViewHolder holder, int position) {
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