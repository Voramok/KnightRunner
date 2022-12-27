package ru.voramok.knightrunner.objects.fonobjects;

import static ru.voramok.knightrunner.R.drawable.road;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.voramok.knightrunner.objects.Object;
import ru.voramok.knightrunner.objects.animobjects.Knight;
import ru.voramok.knightrunner.GetUnitSize;

public class FonObj extends Object implements GetUnitSize {

    protected int speed;
    protected int bitmapId = road;
    protected Bitmap bitmap1, bitmap2;

    protected void init(Context context) {
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(),bitmapId);
        bitmap1 = Bitmap.createScaledBitmap(cBitmap, (size * getUnitW(context)) +
                        size * getUnitW(context) / speed ,
                (size * getUnitH(context)), false);
        bitmap2 = bitmap1;
        cBitmap.recycle();
    }

    public void draw(Context context, Paint paint, Canvas canvas) {
        if(Knight.getIsIdle() && Knight.getIsDead()) {
            if(x >= -1 * (size * getUnitW(context) +
                    size * getUnitW(context)/speed)){
                x = x - speed;
            } else {
                x = 0;
            }
        }
        canvas.drawBitmap(bitmap1, x, y, paint);
        canvas.drawBitmap(bitmap2, (x + size * getUnitW(context)) +
                size * getUnitW(context) / speed, y, paint);
    }
}
