package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint mPaint, mPaint2, mPaint3, mPaint4;

    public Practice2DrawCircleView(Context context) {
        super(context);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);

        // paint for drawing full circle
        mPaint.setColor(Color.BLACK);

        // paint for drawing empty circle
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeWidth(3);

        // paint for drawing full blue circle
        mPaint3.setColor(0xFF568FE5);

        // paing for drawing black ring
        mPaint4.setStyle(Paint.Style.STROKE);
        mPaint4.setColor(Color.BLACK);
        mPaint4.setStrokeWidth(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        // drawing full circle
        canvas.drawCircle(360, 155, 150, mPaint);

        // drawing empty circle
        canvas.drawCircle(1080 - 360, 155, 150, mPaint2);

        // drawing full blue circle
        canvas.drawCircle(360, 515, 150, mPaint3);

        // drawaing black ring
        canvas.drawCircle(1080 - 360, 515, 150, mPaint4);
    }
}
