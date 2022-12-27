package ru.voramok.knightrunner.objects.animobjects;

import static ru.voramok.knightrunner.R.drawable.run_0;
import static ru.voramok.knightrunner.R.drawable.run_1;
import static ru.voramok.knightrunner.R.drawable.run_2;
import static ru.voramok.knightrunner.R.drawable.run_3;
import static ru.voramok.knightrunner.R.drawable.run_4;
import static ru.voramok.knightrunner.R.drawable.run_5;
import static ru.voramok.knightrunner.R.drawable.run_6;

import android.content.Context;
import android.graphics.Bitmap;

public class KnightRun extends ArrForAnim {

     public KnightRun(Context context) {
          arrayId = new int[]{run_0, run_1, run_2, run_3, run_4, run_5, run_6};
          arrayBm = new Bitmap[arrayId.length];
          bitmap = null;
          frameDivider = 0;
          frameCount = 0;
          size = Knight.getSize();
          x =  Knight.getX();
          y = 66;
          divider = 3;
          init(context);
     }

}
