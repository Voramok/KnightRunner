package ru.voramok.knightrunner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ru.voramok.knightrunner.objects.animobjects.Knight;
import ru.voramok.knightrunner.objects.animobjects.KnightDeath;
import ru.voramok.knightrunner.objects.staticobjects.LetLow;

public class MainActivity extends AppCompatActivity {

    private TextView scoreCountTV;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView menuFon = findViewById(R.id.menuFonIV);

        Button startButton = findViewById(R.id.startB);
        Button menuButton = findViewById(R.id.menuB);
        Button restartButton = findViewById(R.id.restartB);

        scoreCountTV = findViewById(R.id.scoreTV);

        GameView gameView = new GameView(this, scoreCountTV);

        LinearLayout gameLayout = (LinearLayout) findViewById(R.id.gameLayout);
        gameLayout.addView(gameView);

        OnTouch myOnTouch = new OnTouch();

        gameLayout.setOnTouchListener(myOnTouch);

        Knight.setIsIdle(true);

        startButton.setOnClickListener(v -> {
            //Start
            if(startButton.getText().equals("START")) {
                startButton.setVisibility(View.INVISIBLE);
                restartButton.setVisibility(View.INVISIBLE);
                menuFon.setVisibility(View.INVISIBLE);
                scoreCountTV.setVisibility(View.VISIBLE);
                menuButton.setVisibility(View.VISIBLE);
                startButton.setText("RESUME");

                Knight.setIsIdle(false);
                Knight.setIsRunning(true);
            } else {
                //Resume
                startButton.setVisibility(View.INVISIBLE);
                restartButton.setVisibility(View.INVISIBLE);
                menuFon.setVisibility(View.INVISIBLE);
                menuButton.setVisibility(View.VISIBLE);

                GlobalVar.setIsPaused(false);
            }
        });

        menuButton.setOnClickListener(v -> {
            //Menu/Pause game
            startButton.setVisibility(View.VISIBLE);
            restartButton.setVisibility(View.VISIBLE);
            menuButton.setVisibility(View.INVISIBLE);
            menuFon.setVisibility(View.VISIBLE);

            GlobalVar.setIsPaused(true);
        });

        restartButton.setOnClickListener(v -> {
            //Restart
            startButton.setVisibility(View.INVISIBLE);
            restartButton.setVisibility(View.INVISIBLE);
            menuFon.setVisibility(View.INVISIBLE);
            menuButton.setVisibility(View.VISIBLE);
            startButton.setText("RESUME");


            GlobalVar.setIsPaused(false);
            Knight.setIsDead(false);
            GameView.setIsFirstTimeKnight(true);
            Knight.setIsRunning(true);
            GlobalVar.setIsRestart(true);
        });
    }

}