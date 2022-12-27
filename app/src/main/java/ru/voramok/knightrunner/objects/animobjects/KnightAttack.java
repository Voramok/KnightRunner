package ru.voramok.knightrunner.objects.animobjects;

import static ru.voramok.knightrunner.R.drawable.run_attack_0;
import static ru.voramok.knightrunner.R.drawable.run_attack_1;
import static ru.voramok.knightrunner.R.drawable.run_attack_3;
import static ru.voramok.knightrunner.R.drawable.run_attack_4;
import static ru.voramok.knightrunner.R.drawable.run_attack_5;

import android.content.Context;
import android.graphics.Bitmap;

public class KnightAttack extends ArrForAnim {

     public KnightAttack(Context context) {
          arrayId = new int[]{run_attack_0, run_attack_1, run_attack_3,
                  run_attack_3, run_attack_4, run_attack_5};
          arrayBm = new Bitmap[arrayId.length];
          bitmap = null;
          frameDivider = 0;
          frameCount = 0;
          size = Knight.getSize();
          x = Knight.getX();
          y = Knight.getY();
          divider = 4;
          init(context);
     }

     public void anim() {
          if (frameCount < arrayBm.length){
               bitmap = arrayBm[frameCount];
               if (frameDivider >= divider) {
                    frameCount++;
                    if(frameCount >= arrayBm.length)
                    {
                         frameCount = 0;
                         Knight.setIsAttacking(false);
                         Knight.setIsRunning(true);
                    }
                    frameDivider = 0;
               }
               frameDivider++;
          }
     }

}
