package ru.voramok.knightrunner;

public class GlobalVar {

    private static final int FPS = 30;
    private static int gameSpeed = 40; //game speed with multipliers

    private static int gameScore = 0;
    private static int addScore = 1;

    private static boolean isRestart;

    public static int getScoreCount() {
        if(gameScore > 500 && gameScore < 1000) {
            addScore = 2;
            gameSpeed = 80;
        }
        if (gameScore > 1000 && gameScore < 2000) {
            addScore = 4;
            gameSpeed = 160;
        } if (gameScore > 2000) {
            addScore = 8;
            gameSpeed = 320;
        }
        return gameScore += addScore;
    }

    public static void setScoreCount() {
        GlobalVar.gameScore = 0;
    }

    private static boolean isPaused;

    public static boolean getIsPaused() {
        return isPaused;
    }

    public  static  void  setIsPaused(boolean isPaused) {
        GlobalVar.isPaused = isPaused;
    }

    public static int getGameSpeed() {
        return gameSpeed;
    }

    public static int getFPS() {
        return FPS;
    }

    public static boolean getIsRestart() {
        return isRestart;
    }

    public static void setIsRestart(boolean isRestart) {
        GlobalVar.isRestart = isRestart;
    }
}
