package ru.voramok.knightrunner.objects.textobjects;

import android.content.Context;
import static ru.voramok.knightrunner.R.drawable.game_over;

public class GameOver extends TxtOnScreen {

    public GameOver(Context context) {
          bitmap = null;
          bitmapId = game_over;
          size = 40;
          x = 20;
          y = 20;
          init(context);
    }



}
