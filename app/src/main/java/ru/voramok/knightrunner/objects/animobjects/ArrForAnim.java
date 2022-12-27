package ru.voramok.knightrunner.objects.animobjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.voramok.knightrunner.GetUnitSize;
import ru.voramok.knightrunner.objects.Object;

public class ArrForAnim extends Object implements GetUnitSize {

    protected Bitmap[] arrayBm;
    protected int[] arrayId;
    protected Bitmap bitmap;
    protected int frameDivider;
    protected int frameCount;
    protected int divider;

    public void anim() {
        if (frameCount < arrayBm.length){
            bitmap = arrayBm[frameCount];
            if (frameDivider >= divider) {
                frameCount++;
                if(frameCount >= arrayBm.length)
                {
                    frameCount = 0;
                }
                frameDivider = 0;
            }
            frameDivider++;
        }
    }

    protected void init(Context context) {
        if (arrayBm.length == arrayId.length) {
            for (int i = 0; i < arrayBm.length; i++) {
                Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), arrayId[i]);
                arrayBm[i] = Bitmap.createScaledBitmap(cBitmap, (size * getUnitW(context)),
                       (size * getUnitW(context)), false);
                cBitmap.recycle();
            }
        }
    }

    public void draw(Context context, Paint paint, Canvas canvas) {
        canvas.drawBitmap(bitmap, x * getUnitW(context), y * getUnitH(context), paint);
    }
}
