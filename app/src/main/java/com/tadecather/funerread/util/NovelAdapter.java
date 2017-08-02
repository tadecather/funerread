package com.tadecather.funerread.util;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tadecather.funerread.R;
import com.tadecather.funerread.entity.Novel;

import java.util.List;

/**
 * Created by TAD on 8/1/2017.
 */

public class NovelAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private List<Novel> novelList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView novelImageView;
        TextView novelTitle;
        TextView novelPreview;
        ProgressBar novelProcessBar;
        TextView novelProcessText;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            novelImageView = (ImageView) itemView.findViewById(R.id.novel_item_picture);
            novelTitle = (TextView) itemView.findViewById(R.id.novel_item_title);
            novelPreview = (TextView) itemView.findViewById(R.id.novel_item_preview);
            novelProcessBar = (ProgressBar) itemView.findViewById(R.id.novel_item_progress_bar);
            novelProcessText = (TextView) itemView.findViewById(R.id.novel_item_progress_text);

        }
    }

    public NovelAdapter(List<Novel> novelList) {
        this.novelList = novelList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.novel_main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Novel novel = novelList.get(position);
        ViewHolder mViewHolder = (ViewHolder) holder;

        mViewHolder.novelTitle.setText(novel.getName());
        mViewHolder.novelPreview.setText(novel.getBriefIntroduction());
        mViewHolder.novelProcessText.setText(String.valueOf(novel.getProgress() + "%"));
        mViewHolder.novelProcessBar.setProgress((int)Math.floor(novel.getProgress()));


    }

    @Override
    public int getItemCount() {
        return novelList.size();
    }
}
