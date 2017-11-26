package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    // pie constants
    private static final int CHART_BOUNDRY_LEFT = 160;
    private static final int CHART_BOUNDRY_TOP = 30;
    private static final int CHART_BOUNDRY_RIGHT = 700;
    private static final int CHART_BOUNDRY_BOTTOM = 570;
    private static final int CHART_PIE_GAP = 2;

    // pie data
    private ChartPie[] arrPie = new ChartPie[]{
            new ChartPie("Froyo", 0.005f, 0xFF27FF4E),
            new ChartPie("Gingerbread", 0.02f, 0xFF9C27B0),
            new ChartPie("Ice Cream Sandwich", 0.02f, 0xFF9E9E9E),
            new ChartPie("Jelly Bean", 0.15f, 0xFF009688),
            new ChartPie("KitKat", 0.3f, 0xFF2196F3),
            new ChartPie("Lolipop", 0.35f, 0xFFF44336),
            new ChartPie("MarshMallow", 0.15f, 0xFFFFC107)
    };

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        for (ChartPie pie : arrPie) {
            drawPie(canvas, pie.color, pie.percent, pie.name, pie.name.equals("Lolipop"));
        }
    }

    // start degree for drawing pie
    private int mStartDegree = 0;

    private void drawPie(Canvas canvas, int color, float percent, String desc, boolean selected) {
        // init paint
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);

        int sweepAngel = (int) (360 * percent) - CHART_PIE_GAP;

        int transform = selected ? -20 : 0;

        canvas.drawArc(CHART_BOUNDRY_LEFT + transform, CHART_BOUNDRY_TOP + transform,
                CHART_BOUNDRY_RIGHT + transform, CHART_BOUNDRY_BOTTOM + transform,
                mStartDegree, sweepAngel, true, paint);

        mStartDegree += sweepAngel + CHART_PIE_GAP;
    }

    private class ChartPie {
        public String name;
        public float percent;
        public int color;

        public ChartPie(String name, float percent, int color) {
            this.name = name;
            this.percent = percent;
            this.color = color;
        }
    }
}
