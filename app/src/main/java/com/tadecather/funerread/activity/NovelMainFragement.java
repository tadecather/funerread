package com.tadecather.funerread.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.tadecather.funerread.R;
import com.tadecather.funerread.entity.Novel;
import com.tadecather.funerread.util.NovelAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAD on 8/1/2017.
 * this class is used for show the main area of novel
 */

public class NovelMainFragement extends Fragment{


    private Context context;
    private View mview;
    private NovelAdapter adapter;

    private FloatingActionButton novelFAB;

    private List<Novel> novelList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(context == null){
            context = getContext();
        }

        View view = inflater.inflate(R.layout.novel_main_fragement, container, false);
        mview = view;
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initNovelList();

        RecyclerView novelRecycle = (RecyclerView) mview.findViewById(R.id.novel_Recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 1);
        novelRecycle.setLayoutManager(layoutManager);
        adapter = new NovelAdapter(novelList);
        novelRecycle.setAdapter(adapter);

        initFloatActionBar();



    }



    // 初始化小说的列表，测试用添加了5个
    private void initNovelList() {
        for(int i = 0; i < 5; i++){
            Novel novel = new Novel(i,"TAD" + i,  "author" + i, "llllllllllll", "简介" + i, "src:image_novel", 6.5 + i);
            novelList.add(novel);
        }
    }


    //初始化FloatActionBar的菜单
    private void initFloatActionBar() {
        novelFAB = mview.findViewById(R.id.novel_fab);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(getActivity());
        ImageView itemIcon = new ImageView(getActivity());
        itemIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));


        SubActionButton button = itemBuilder.setContentView(itemIcon).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(getActivity())
                .addSubActionView(button)
                .attachTo(novelFAB)
                .build();


        //设置子菜单的点击事件
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });



    }


}
