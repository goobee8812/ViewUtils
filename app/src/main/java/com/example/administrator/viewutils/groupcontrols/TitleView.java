package com.example.administrator.viewutils.groupcontrols;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.viewutils.R;

/**
 * Created by Administrator on 2017/9/11.
 * 组合控件
 */

public class TitleView extends FrameLayout {
    private Button leftButton;
    private TextView titleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //装载layout布局 ---->   获取view
        View getView = LayoutInflater.from(context).inflate(R.layout.title, this);
        titleText = (TextView) getView.findViewById(R.id.title_text);
        leftButton = (Button) getView.findViewById(R.id.button_left);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    public void setTitleText(String text) {
        titleText.setText(text);
    }

    public void setLeftButtonText(String text) {
        leftButton.setText(text);
    }

    public void setLeftButtonListener(OnClickListener l) {
        leftButton.setOnClickListener(l);
    }

}