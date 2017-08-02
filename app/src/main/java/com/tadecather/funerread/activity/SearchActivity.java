package com.tadecather.funerread.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tadecather.funerread.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private Button backSearchButton, searchButton;
    private EditText searchContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        backSearchButton = (Button) findViewById(R.id.search_back);
        searchButton = (Button) findViewById(R.id.msearch_button);
        searchContent = (EditText) findViewById(R.id.search_content);

        backSearchButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_back:
                finish();
                break;
            case R.id.msearch_button:
                searchSomethisng();
                break;
            default:
                break;
        }
    }

    private void searchSomethisng() {
        //TODO
        TextView showSomethisng = (TextView)findViewById(R.id.show_search_result);
        showSomethisng.setText("................" +
                "wangabagaozi");
    }
}
