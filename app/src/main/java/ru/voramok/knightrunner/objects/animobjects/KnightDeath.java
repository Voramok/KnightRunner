package ru.voramok.knightrunner.objects.animobjects;

import static ru.voramok.knightrunner.R.drawable.dead_0;
import static ru.voramok.knightrunner.R.drawable.dead_1;
import static ru.voramok.knightrunner.R.drawable.dead_2;
import static ru.voramok.knightrunner.R.drawable.dead_3;
import static ru.voramok.knightrunner.R.drawable.dead_4;
import static ru.voramok.knightrunner.R.drawable.dead_5;

import android.content.Context;
import android.graphics.Bitmap;

public class KnightDeath extends ArrForAnim {

     public KnightDeath(Context context) {
          arrayId = new int[]{dead_0, dead_1, dead_2, dead_3, dead_4, dead_5};
          arrayBm = new Bitmap[arrayId.length];
          bitmap = null;
          frameDivider = 0;
          frameCount = 0;
          size = Knight.getSize();
          x =  Knight.getX();
          y = Knight.getY();
          divider = 2;
          init(context);
     }

     public void anim() {
          if (frameCount < arrayBm.length){
               bitmap = arrayBm[frameCount];
               if (frameDivider >= 2) {
                    frameCount++;
                    x = x + 4;
                    if (y < 66) {
                         y = y + ((66 - y)/2);
                    }
                    frameDivider = 0;
               }
               frameDivider++;
          }
     }
}
