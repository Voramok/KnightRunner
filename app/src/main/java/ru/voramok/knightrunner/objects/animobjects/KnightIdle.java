package ru.voramok.knightrunner.objects.animobjects;

import static ru.voramok.knightrunner.R.drawable.idle_0;
import static ru.voramok.knightrunner.R.drawable.idle_1;
import static ru.voramok.knightrunner.R.drawable.idle_2;
import static ru.voramok.knightrunner.R.drawable.idle_3;

import android.content.Context;
import android.graphics.Bitmap;

public class KnightIdle extends ArrForAnim {

     public KnightIdle(Context context) {
          arrayId = new int[]{idle_0, idle_1, idle_2, idle_3};
          arrayBm = new Bitmap[arrayId.length];
          bitmap = null;
          frameDivider = 0;
          frameCount = 0;
          size = Knight.getSize();
          x =  Knight.getX();
          y = Knight.getY();
          divider = 8;
          init(context);
     }

}
