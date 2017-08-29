package com.geecity.jucheng.datasupport.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geecity.jucheng.datasupport.R;
import com.geecity.jucheng.datasupport.bean.Pictures;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

@SuppressWarnings("all")
public class MainPhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Pictures> pictures;
    private Context mContext;

    public MainPhotoAdapter(List<Pictures> pictures) {
        this.pictures = pictures;
    }

    @Override
    public GridPhotoViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_photo, parent, false);
        return new GridPhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GridPhotoViewHolder) {
            GridPhotoViewHolder pHolder = (GridPhotoViewHolder) holder;
            pHolder.bindItem(pictures.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return (pictures == null || pictures.size() == 0) ? 0 : pictures.size();
    }

    class GridPhotoViewHolder extends RecyclerView.ViewHolder {

        View newsView;
        @Bind(R.id.news_img)
        ImageView news_img;

        GridPhotoViewHolder(View itemView) {
            super(itemView);
            newsView = itemView;
            ButterKnife.bind(this, itemView);
        }

        void bindItem(final Pictures picture) {
            Glide.with(mContext)
                    .load(picture.getpImg())
                    .into(news_img);
        }
    }
}
