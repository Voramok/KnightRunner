package ru.voramok.knightrunner.objects.staticobjects;

import static ru.voramok.knightrunner.R.drawable.let_high;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.voramok.knightrunner.GlobalVar;
import ru.voramok.knightrunner.objects.animobjects.Knight;

public class LetHigh extends Let {

    //not finished

    public LetHigh(Context context) {
        bitmap = null;
        bitmapId = let_high;
        speed = GlobalVar.getGameSpeed();
        size = 15;
        y = 0;
        x = getDisplayWidth(context) + (size * getUnitW(context));
        init(context);
    }

    public void draw(Context context, Paint paint, Canvas canvas) {
        if(Knight.getIsIdle() && Knight.getIsDead()) {
            x = x  - speed;
            if (x <= -1 * size * getUnitW(context)) {
                x = getDisplayWidth(context) + (size * getUnitH(context));
            }
        }
        canvas.drawBitmap(bitmap, x, y * getUnitH(context), paint);
    }

    public boolean isCollision(Context context) {
        boolean rightX = x + size * getUnitW(context) > Knight.getX() * getUnitW(context);
        boolean leftX =  x < (Knight.getX() + Knight.getSize()) * getUnitW(context);
        boolean isAttack = !Knight.getIsAttacking();
        if(rightX && leftX && !isAttack) {
            x = -5 * size * getUnitW(context);//destroy obj
        }
        return rightX && leftX && isAttack /*&& upY*/;
    }
}
