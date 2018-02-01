package com.lib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by wangyang on 2/1/18.
 */

public class RoundImageview extends ImageView{
    private static final String TAG = "Android/data/%s";

//    private int r;
    public RoundImageview(Context context) {
        super(context);

    }
    public RoundImageview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public RoundImageview(Context context, AttributeSet attrs,
                      int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Path clipPath = new Path();
        int w = this.getWidth();
        int h = this.getHeight();
        int r=30;
        float radii[] ={r,50,r,50,r,50,r,50};
        clipPath.addRoundRect(new RectF(0, 0, w, h), radii, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
