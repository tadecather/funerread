package com.tadecather.funerread.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tadecather.funerread.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String TAG = "FirstActivity";
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private DrawerLayout drawerLayout;

    private Fragment musicFragment, newsFragment, novelFragment;
    private Button musicButton, newsButton, novelButton, navMenuButton;
    public FirstActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        navMenuButton = (Button) findViewById(R.id.nav_button);
        musicButton = (Button)findViewById(R.id.music_button);
        newsButton = (Button)findViewById(R.id.news_button);
        novelButton = (Button)findViewById(R.id.novel_button);
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);

        navMenuButton.setOnClickListener(this);
        musicButton.setOnClickListener(this);
        newsButton.setOnClickListener(this);
        novelButton.setOnClickListener(this);


        musicFragment = new MusicMainFragement();
        transaction.replace(R.id.first_content, musicFragment);
        transaction.commit();

    }

    @Override
    public void onClick(View view) {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch(view.getId()){
            case R.id.nav_button:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.music_button :
                hideFragment(transaction);
                musicFragment = new MusicMainFragement();
                transaction.replace(R.id.first_content, musicFragment);
                transaction.commit();
                break;
            case R.id.news_button:
                hideFragment(transaction);
                newsFragment = new NewsMainFragement();
                transaction.replace(R.id.first_content, newsFragment);
                transaction.commit();
                break;
            case R.id.novel_button:
                hideFragment(transaction);
                novelFragment = new NovelMainFragement();
                transaction.replace(R.id.first_content, novelFragment);
                transaction.commit();
                break;
            default:
                break;
        }


    }

    private void hideFragment(FragmentTransaction transaction) {
        if(musicFragment != null){
            transaction.remove(musicFragment);
        }
        if(newsFragment != null){
            transaction.remove(newsFragment);
        }
        if(novelFragment != null){
            transaction.remove(novelFragment);
        }
    }
}











