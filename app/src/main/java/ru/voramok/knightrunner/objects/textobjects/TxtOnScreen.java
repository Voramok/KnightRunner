package ru.voramok.knightrunner.objects.textobjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.voramok.knightrunner.GetUnitSize;
import ru.voramok.knightrunner.objects.Object;
import ru.voramok.knightrunner.objects.animobjects.Knight;

public class TxtOnScreen extends Object implements GetUnitSize {
    protected Bitmap bitmap;
    protected int bitmapId;

    protected void init(Context context) {
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(cBitmap, (size * getUnitW(context)),
                (size * getUnitW(context)), false);
        cBitmap.recycle();
    }

    public void draw(Context context, Paint paint, Canvas canvas) {
        if(!Knight.getIsDead()) {
            x = (getDisplayWidth(context) - size * getUnitW(context))/2;
            y = (getDisplayHeight(context) - size * getUnitW(context))/2;
            canvas.drawBitmap(bitmap, x, y, paint);
        }
    }
}

