package ru.voramok.knightrunner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ru.voramok.knightrunner.objects.fonobjects.Road;
import ru.voramok.knightrunner.objects.fonobjects.Sky;
import ru.voramok.knightrunner.objects.animobjects.Knight;
import ru.voramok.knightrunner.objects.staticobjects.LetHigh;
import ru.voramok.knightrunner.objects.staticobjects.LetLow;
import ru.voramok.knightrunner.objects.textobjects.GameOver;

@SuppressLint("ViewConstructor")
public class GameView extends SurfaceView implements Runnable, TimeCheck {

    private static boolean firstTimeKnight = true;
    private Knight knight;
    private Sky sky;
    private Road road;
    private final LetLow letLow = new LetLow(getContext());
    private final LetHigh letHigh = new LetHigh(getContext());
    private final GameOver gameOver = new GameOver(getContext());
    private final Paint paint;
    private final SurfaceHolder surfaceHolder;
    private final TextView scoreCountTV;

    public GameView(Context context, TextView textView) {
        super(context);
        this.scoreCountTV = textView;

        //Paint obj init
        surfaceHolder = getHolder();
        paint = new Paint();

        // Thread init
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        boolean gameRunning = true;
        while (gameRunning) {
            long i = startCheck();
            if(!GlobalVar.getIsPaused()) {
                draw();
                checkCollision();
                if (Knight.getIsIdle() && Knight.getIsDead()) {
                    scoreCountTV.setText(String.valueOf(GlobalVar.getScoreCount()));
                }
            }
            control(endCheck(i));
        }
    }

    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            if(firstTimeKnight){
                firstTimeKnight = false;
                knight = new Knight(getContext());
                sky = new Sky(getContext());
                road = new Road(getContext());
            }
            Canvas canvas = surfaceHolder.lockCanvas();
            sky.draw(getContext(), paint, canvas);
            road.draw(getContext(), paint, canvas);
            knight.draw(getContext(), paint, canvas);
            letLow.draw(getContext(), paint, canvas);
            gameOver.draw(getContext(), paint, canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void control(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000/GlobalVar.getFPS() - time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkCollision(){
        if(letLow.isCollision(getContext()) || letHigh.isCollision(getContext())) {
            Knight.setIsDead(true);

        }
    }

    public static void setIsFirstTimeKnight(boolean firstTimeKnight) {
        GameView.firstTimeKnight = firstTimeKnight;
    }
}
