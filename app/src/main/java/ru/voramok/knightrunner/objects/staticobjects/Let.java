package ru.voramok.knightrunner.objects.staticobjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.voramok.knightrunner.GlobalVar;
import ru.voramok.knightrunner.objects.Object;
import ru.voramok.knightrunner.objects.animobjects.Knight;
import ru.voramok.knightrunner.GetUnitSize;

public class Let extends Object implements GetUnitSize {

    protected Bitmap bitmap;
    protected int bitmapId;
    protected int speed;

    protected void init(Context context) {
        Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
        bitmap = Bitmap.createScaledBitmap(cBitmap, (size * getUnitW(context)),
                (size * getUnitW(context)), false);
        cBitmap.recycle();
    }

    public void draw(Context context, Paint paint, Canvas canvas) {
        if (GlobalVar.getIsRestart()) {
            x = getDisplayWidth(context) + (size * getUnitH(context));
            GlobalVar.setScoreCount();
            GlobalVar.setIsRestart(false);
        } if(Knight.getIsIdle() && Knight.getIsDead()) {
            x = x  - speed;
            if (x <= -1 * size * getUnitW(context)) {
                x = getDisplayWidth(context) + (size * getUnitH(context));
            }
        }
        canvas.drawBitmap(bitmap, x, y * getUnitH(context), paint);
    }

    public boolean isCollision(Context context) {
        boolean rightX = x + size * getUnitW(context) > Knight.getX() * getUnitW(context) +
                Knight.getSize() * getUnitW(context)/4;
        boolean leftX =  x < (Knight.getX() + Knight.getSize()) * getUnitW(context) * 3/4;
        boolean upY = y * getUnitH(context) < (Knight.getY() + Knight.getSize()) * getUnitH(context);
        return rightX && leftX && upY;
    }


}
