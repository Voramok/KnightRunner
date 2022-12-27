package ru.voramok.knightrunner.objects.fonobjects;

import static ru.voramok.knightrunner.R.drawable.road;

import android.content.Context;
import ru.voramok.knightrunner.GlobalVar;

public class Road extends FonObj  {

    public Road(Context context) {
        bitmapId = road;
        speed = GlobalVar.getGameSpeed();
        x = 0;
        y = 0;
        size = 100;
        bitmap1 = null;
        bitmap2 = null;
        init(context);
    }
}



