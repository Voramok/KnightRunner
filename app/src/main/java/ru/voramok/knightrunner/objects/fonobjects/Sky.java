package ru.voramok.knightrunner.objects.fonobjects;

import static ru.voramok.knightrunner.R.drawable.sky;

import android.content.Context;
import ru.voramok.knightrunner.GlobalVar;

public class Sky extends FonObj {

    public Sky(Context context) {
        bitmapId = sky;
        speed = GlobalVar.getGameSpeed()/10;
        x = 0;
        y = 0;
        size = 100;
        bitmap1 = null;
        bitmap2 = null;
        init(context);
    }
}



