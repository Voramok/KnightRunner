package ru.voramok.knightrunner;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

import ru.voramok.knightrunner.objects.animobjects.Knight;

public class OnTouch implements View.OnTouchListener {

    private float startY;

    private int clickCount = 0;
    //variable for storing the time of first click
    private long startTime;
    //variable for calculating the total time
    private long duration;
    //constant for defining the time duration between the
    //click that can be considered as double-tap
    private static final int MAX_DURATION = 200;

    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: // нажатие
                startTime = System.currentTimeMillis();
                clickCount++;
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE: // движение
                float finishY = event.getY();
                if (startY > finishY && Knight.getIsRunning()) {
                    Knight.setIsRunning(false);
                    Knight.setIsJumping(true);
                }
                break;
            case MotionEvent.ACTION_UP: // отпускание
                long time = System.currentTimeMillis() - startTime;
                duration =  duration + time;
                if (clickCount == 2)
                {
                    if(duration <= MAX_DURATION && Knight.getIsRunning())
                    {
                        Knight.setIsRunning(false);
                        Knight.setIsAttacking(true);
                    }
                    clickCount = 0;
                    duration = 0;
                }
                break;
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return true;
    }

}
