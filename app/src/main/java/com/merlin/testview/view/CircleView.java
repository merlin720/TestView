package com.merlin.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.merlin.testview.R;

/**
 * Created by zhouyang on 2017/8/29.
 */

public class CircleView extends View {


    private float width_circle = 5;//表盘最外圆圈的宽度
    private float width_longer = 5;//整点刻度宽度
    private float width_shorter = 3;//非整点刻度宽度
    private float length_longer = 60;//整点刻度长度
    private float length_shorter = 30;//非整点刻度长度
    private float text_size = 60;//表盘中文字大小

    private float radius_center = 15;//表盘正中心的半径长度 radius_center

    private float width_hour = 20;//时针宽度
    private float width_minutes = 10;//分针刻度宽度
    private float width_second = 8;//秒针刻度宽度

    private float mWidth = 1000;//当宽为wrap_content时，默认的宽度
    private float mHeight = 1000;//当高为wrap_content时，默认的高度


    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension((int) mWidth, (int) mHeight);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension((int) mWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, (int) mHeight);
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mWidth = Math.min(getWidth(), getHeight());
        this.mHeight = Math.max(getWidth(), getHeight());

        //画表盘
        Paint circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(width_circle);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2 - width_circle, circlePaint);

        //画刻度
        Paint degreePaint = new Paint();
        degreePaint.setAntiAlias(true);
        float lineLength = 0f;

        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                degreePaint.setStrokeWidth(width_longer);
                lineLength = length_longer;
            } else {
                degreePaint.setStrokeWidth(width_shorter);
                lineLength = length_shorter;
            }

            canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2 + width_circle, mWidth / 2, mHeight / 2 - mWidth / 2 + lineLength, degreePaint);
            canvas.rotate(360 / 60, mWidth / 2, mHeight / 2);
        }


        degreePaint.setTextSize(text_size);
        String targetText[] = getContext().getResources().getStringArray(R.array.clock);


        float startX = mWidth / 2 - degreePaint.measureText(targetText[1]) / 2;
        float startY = mHeight / 2 - mWidth / 2 + 120;
        float textR = (float) Math.sqrt(Math.pow(mWidth / 2 - startX, 2) + Math.pow(mHeight / 2 - startY, 2));

        for (int i = 0; i < 12; i++) {
            float x = (float) (startX + Math.sin(Math.PI / 6 * i) * textR);
            float y = (float) (startY + textR - Math.cos(Math.PI / 6 * i) * textR);
            if (i != 11 && i != 10 && i != 0) {
                y = y + degreePaint.measureText(targetText[i]) / 2;
            } else {
                x = x - degreePaint.measureText(targetText[i]) / 4;
                y = y + degreePaint.measureText(targetText[i]) / 4;
            }
            canvas.drawText(targetText[i], x, y, degreePaint);
        }
    }
}
