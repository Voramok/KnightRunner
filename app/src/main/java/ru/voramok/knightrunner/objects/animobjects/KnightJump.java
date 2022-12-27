package ru.voramok.knightrunner.objects.animobjects;

import static ru.voramok.knightrunner.R.drawable.jump_0;
import static ru.voramok.knightrunner.R.drawable.jump_1;
import static ru.voramok.knightrunner.R.drawable.jump_2;
import static ru.voramok.knightrunner.R.drawable.jump_3;
import static ru.voramok.knightrunner.R.drawable.jump_4;
import static ru.voramok.knightrunner.R.drawable.jump_5;

import android.content.Context;
import android.graphics.Bitmap;

public class KnightJump extends ArrForAnim {

     public KnightJump(Context context) {
          arrayId = new int[]{jump_0, jump_1, jump_2, jump_3, jump_4, jump_5};
          arrayBm = new Bitmap[arrayId.length];
          bitmap = null;
          frameDivider = 0;
          frameCount = 0;
          size = Knight.getSize();
          x =  20;
          y = 66;
          divider = 4;
          init(context);
     }

     public void anim() {
          if (frameCount < arrayBm.length){
               bitmap = arrayBm[frameCount];
               if (!(frameDivider % 2 == 0)) {
                    if (frameCount < 2) {
                         y = y - Knight.getJumpHeight();
                         Knight.setY(y);
                    } else if (frameCount > 3) {
                         y = y + Knight.getJumpHeight();
                         Knight.setY(y);
                    }
               }
               if (frameDivider >= 4) {
                    frameCount++;
                    if(frameCount >= arrayBm.length)
                    {
                         frameCount = 0;
                         Knight.setIsJumping(false);
                         Knight.setIsRunning(true);
                    }
                    frameDivider = 0;
               }
               frameDivider++;
          }
     }

}
