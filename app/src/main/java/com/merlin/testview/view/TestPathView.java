package com.merlin.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by zhouyang on 2017/9/7.
 */

public class TestPathView extends View {
    private Path mPath;
    private Paint mPaint;

    private ArrayList<PointF> graphics = new ArrayList<>();

    private PointF point;

    public TestPathView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public TestPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public TestPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        graphics.add(new PointF(event.getX(), event.getY()));
//
//        invalidate();
//
//        return super.onTouchEvent(event);
//
//
//    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
//        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5.0f);
        mPaint.setAntiAlias(true);
//        canvas.translate(canvas.getWidth()/2, 200); //将位置移动画纸的坐标点:150,150
//        canvas.drawCircle(0, 0, 100, mPaint); //画圆圈

        mPath = new Path();
        mPath.moveTo(100,100);
//        mPath.lineTo(200,100);
//        mPath.lineTo(200,200);
//        mPath.lineTo(100,200);
//        mPath.close();

//        mPath.rLineTo(100,100);
        //其中quadTo的前两个参数为控制点的坐标，后两个参数为终点坐标，至于起点默认是画布的左上角。这里的p0就是起点，(x1,y1)就是中点P1，(x2,y2)就是末端点P2。
//        mPath.quadTo(400,400,200,100);

        //与quadTo类似，前四个参数表示两个控制点，最后两个参数表示终点。其实，(x1,y1)就是P1,(x2,y2)是P2，(x3,y3)是P3。
//        mPath.cubicTo(200,200,300,0,400,100);

//        RectF oval = new RectF(100,100,200,200);
//        mPath.arcTo(oval,0,359,true);
//        canvas.drawRect(oval,mPaint);
//        canvas.drawPath(mPath,mPaint);



//        RectF rectF  = new RectF(50,50,200,200);
//
//        canvas.drawRoundRect(rectF,20,20,mPaint);

//        for (PointF point : graphics) {
//            canvas.drawPoint(point.x, point.y, mPaint);
//        }

        mPath.addCircle(300,300,200, Path.Direction.CW);
        mPath.addCircle(500,300,200, Path.Direction.CCW);
        mPath.setFillType(Path.FillType.INVERSE_WINDING);

        canvas.drawPath(mPath,mPaint);
    }

    public void clear(){
        graphics.clear();
        invalidate();
    }
}
