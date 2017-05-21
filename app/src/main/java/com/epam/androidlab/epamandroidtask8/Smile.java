package com.epam.androidlab.epamandroidtask8;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

public class Smile extends View implements View.OnClickListener {
    private static final int STROKE_WIDTH = 10;

    private boolean isSad = true;

    private float radius;
    private float centerX;
    private float centerY;

    private float eyeRadius;
    private float eyeCenter;
    private float sheenRadius;
    private float smileRadius;

    private Paint bodyPaint;
    private Paint smilePaint;
    private Paint eyePaint;
    private Paint sheenPaint;
    private RectF smileOval;

    float smileLeft;
    float smileRight;
    float smileTop;
    float smileButtom;

    private float angle1;
    private float angle2;

    private Canvas canvas;

    private int faceColor;
    private int smileColor;
    private int sheenColor;

    public Smile(Context context) {
        super(context);
        init();
        setOnClickListener(this);
    }

    public Smile(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Smile,
                0, 0);
        try {
            faceColor = a.getColor(R.styleable.Smile_faceColor, 0);
            sheenColor = a.getColor(R.styleable.Smile_sheenColor, 0);
            smileColor = a.getColor(R.styleable.Smile_smileColor, 0);

        } finally {
            a.recycle();
        }
        init();
        setOnClickListener(this);
    }

    public Smile(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Smile,
                0, 0);
        try {
            faceColor = a.getColor(R.styleable.Smile_faceColor, 0);
            sheenColor = a.getColor(R.styleable.Smile_sheenColor, 0);
            smileColor = a.getColor(R.styleable.Smile_smileColor, 0);
        } finally {
            a.recycle();
        }
        init();
        setOnClickListener(this);
    }

    private void init() {
        setSadSmile();
        bodyPaint = new Paint();
        bodyPaint.setColor(faceColor);
        smilePaint = new Paint();
        smilePaint.setColor(smileColor);
        smilePaint.setStyle(Paint.Style.STROKE);
        smilePaint.setStrokeWidth(STROKE_WIDTH);
        smileOval = new RectF();
        eyePaint = new Paint();
        eyePaint.setColor(ContextCompat.getColor(this.getContext(), R.color.white));
        sheenPaint = new Paint();
        sheenPaint.setColor(sheenColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        radius = centerX / 6;
        eyeRadius = radius / 5;
        eyeCenter = radius / 4;
        sheenRadius = eyeRadius / 2;
        smileRadius = radius / 2;

        smileLeft = centerX - smileRadius;
        smileTop = centerY + smileRadius / 2;
        smileRight = centerX + smileRadius;
        smileButtom = (float) (centerY + 1.5 * smileRadius);

        canvas.drawCircle(centerX, centerY, radius, bodyPaint);
        canvas.drawCircle(centerX - eyeCenter, centerY - eyeCenter, eyeRadius, eyePaint);
        canvas.drawCircle(centerX + eyeCenter, centerY - eyeCenter, eyeRadius, eyePaint);
        canvas.drawCircle(centerX - eyeCenter, centerY - eyeCenter, sheenRadius, sheenPaint);
        canvas.drawCircle(centerX + eyeCenter, centerY - eyeCenter, sheenRadius, sheenPaint);
        smileOval.set(smileLeft, smileTop, smileRight, smileButtom);
        canvas.drawArc(smileOval, angle1, angle2, false, smilePaint);
    }

    protected void setHappySmile() {
        angle1 = -180;
        angle2 = -180;
        invalidate();
        requestLayout();
    }

    protected void setSadSmile() {
        angle1 = 180;
        angle2 = 180;
        invalidate();
        requestLayout();
    }

    @Override
    public void onClick(View v) {
        if (isSad) {
            isSad = false;
            setHappySmile();
        } else {
            isSad = true;
            setSadSmile();
        }
    }
}