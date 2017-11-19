package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    private Paint mLinePaint, mRectPaint;
    private static final int GRAPH_OFFSET_X = 90;
    private static final int GRAPH_OFFSET_Y = 10;
    private static final int BAR_WIDTH = 105;
    private static final int BAR_HEIGHT_MAX = 490;
    private static final int BAR_NUMBER = 7;
    private static final int BAR_MARGIN = 15;

    public Practice10HistogramView(Context context) {
        super(context);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectPaint = new Paint();

        mLinePaint.setStyle(Paint.Style.FILL);
        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStrokeWidth(2);

        mLinePaint.setTextAlign(Paint.Align.CENTER);
        mLinePaint.setTextSize(28);

        mRectPaint.setColor(0xFF72B916);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图


        // draw graph axises
        canvas.drawLine(GRAPH_OFFSET_X, GRAPH_OFFSET_Y, GRAPH_OFFSET_X,
                GRAPH_OFFSET_Y + BAR_HEIGHT_MAX, mLinePaint);
        canvas.drawLine(GRAPH_OFFSET_X, 10 + BAR_HEIGHT_MAX,
                90 + BAR_WIDTH * BAR_NUMBER + BAR_MARGIN * (BAR_NUMBER + 1) + 15,
                10 + BAR_HEIGHT_MAX, mLinePaint);

        // draw bars
        drawBar(canvas, 0, 0.005f, "Froyo");
        drawBar(canvas, 1, 0.05f, "GB");
        drawBar(canvas, 2, 0.05f, "ICS");
        drawBar(canvas, 3, 0.45f, "JB");
        drawBar(canvas, 4, 0.75f, "KitKat");
        drawBar(canvas, 5, 0.9f, "L");
        drawBar(canvas, 6, 0.4f, "M");
    }

    private void drawBar(Canvas canvas, int pos, float heightPercent, String text) {
        int left = GRAPH_OFFSET_X + pos * BAR_WIDTH + (pos + 1) * BAR_MARGIN;
        int bottom = GRAPH_OFFSET_Y + BAR_HEIGHT_MAX;

        // draw bar
        canvas.drawRect(left, bottom - heightPercent * BAR_HEIGHT_MAX,
                left + BAR_WIDTH, bottom, mRectPaint);

        // draw text
        canvas.drawText(text, left + BAR_WIDTH / 2, bottom + 25, mLinePaint);
    }
}
