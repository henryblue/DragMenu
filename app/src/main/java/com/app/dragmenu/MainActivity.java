package com.app.dragmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import app.dragmenu.com.library.DragMenuLayout;
import util.Engine;

public class MainActivity extends AppCompatActivity {

    private ListView mLeftList;
    private ListView mMainList;
    private ImageView mHeaderImage;
    private DragMenuLayout mDragLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLeftList = (ListView) findViewById(R.id.lv_left);
        mMainList = (ListView) findViewById(R.id.lv_main);
        mHeaderImage = (ImageView) findViewById(R.id.iv_header);

        mDragLayout = (DragMenuLayout) findViewById(R.id.dl);

        mDragLayout.setDragStatusListener(new DragMenuLayout.OnDragStatusChangeListener() {

            @Override
            public void onOpen() {
            }

            @Override
            public void onDragging(float percent) {
                mHeaderImage.setAlpha(1 - percent);
            }

            @Override
            public void onClose() {
            }
        });

        mLeftList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                Engine.leftStrings){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView mText = ((TextView)view);
                mText.setTextColor(Color.WHITE);
                return view;
            }
        });

        mMainList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Engine.rightStrings));
    }

}
