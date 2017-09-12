package com.example.administrator.viewutils.ownerdrawcontrols;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/9/9.
 * 自绘控件
 */

public class CounterView extends View implements View.OnClickListener {

    private Paint mPaint;
    private Rect mBounds;
    private int mCount;

    public CounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG); //抗锯齿
        mBounds = new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);  //设置画笔颜色
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint); //画一个矩形
        mPaint.setColor(Color.YELLOW); //修改画笔颜色
        mPaint.setTextSize(30); //设置字体大小
        String tx = String.valueOf(mCount); //得到打印文字
        mPaint.getTextBounds(tx,0,tx.length(),mBounds);  //获取打印文字界限
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(tx,getWidth() / 2 - textWidth / 2,getHeight() /2 - textHeight / 2,mPaint);
    }

    @Override
    public void onClick(View v) {
        mCount++;
        invalidate();
    }
}
