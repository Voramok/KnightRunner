package ru.voramok.knightrunner;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public interface GetUnitSize {
    default int getUnitW(Context context) {
        //horizontal size unit
        int maxX = 100;
        return Math.round((float)getDisplayWidth(context)/maxX);

    }

    default int getUnitH(Context context) {
        //vertical size unit
        int maxY = 100;
        return Math.round((float)getDisplayHeight(context)/maxY);

    }

     default int getDisplayWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    default int getDisplayHeight(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }
}
