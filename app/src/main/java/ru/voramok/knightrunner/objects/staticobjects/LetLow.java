package ru.voramok.knightrunner.objects.staticobjects;


import static ru.voramok.knightrunner.R.drawable.let_low;
import android.content.Context;

import ru.voramok.knightrunner.GlobalVar;

public class LetLow extends Let{

    public LetLow(Context context) {
        bitmap = null;
        bitmapId = let_low;
        speed = GlobalVar.getGameSpeed();
        size = 15;
        y = 65;
        x = getDisplayWidth(context) + (size * getUnitW(context));
        init(context);
    }
}
