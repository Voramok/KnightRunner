package ru.voramok.knightrunner.objects.animobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import ru.voramok.knightrunner.GetUnitSize;

public class Knight implements GetUnitSize {

    private static boolean isIdle, isRunning, isJumping, isAttacking, isDead;
    private final KnightIdle knightIdle;
    private final KnightRun knightRun;
    private final KnightDeath knightDeath;
    private final KnightJump knightJump;
    private final KnightAttack knightAttack;

    //**************** / param / ****************//
    private final static int jumpHeight = 14;
    private static final int x = 20;
    private static int y = 66;
    private final static int size = 15;
    //****************             ****************//

    public Knight(Context context) {
        knightIdle = new KnightIdle(context);
        knightRun = new KnightRun(context);
        knightJump = new KnightJump(context);
        knightAttack = new KnightAttack(context);
        knightDeath = new KnightDeath(context);
    }

    public void draw(Context context, Paint paint, Canvas canvas) {

            if (isIdle && !isDead) {
                knightIdle.anim();
                knightIdle.draw(context, paint, canvas);
            } else if (isRunning && !isDead) {
                knightRun.anim();
                knightRun.draw(context ,paint, canvas);
            } else if (isAttacking && !isDead) {
                knightAttack.anim();
                knightAttack.draw(context, paint, canvas);
            } else if (isJumping && !isDead) {
                knightJump.anim();
                knightJump.draw(context, paint, canvas);
            } else if (isDead) {
                knightDeath.anim();
                knightDeath.draw(context, paint, canvas);
            }
    }

    //idle
    public static boolean getIsIdle(){
        return !isIdle;
    }
    public static void setIsIdle(boolean isIdle) {
        Knight.isIdle = isIdle;
    }

    //run
    public static boolean getIsRunning(){
        return isRunning;
    }
    public static void setIsRunning(boolean isRunning) {
        Knight.isRunning = isRunning;
    }

    //jump
    public static boolean getIsJumping(){
        return isJumping;
    }
    public static void setIsJumping(boolean isJumping) {
        Knight.isJumping = isJumping;
    }

    //attack
    public static boolean getIsAttacking(){
        return isAttacking;
    }
    public static void setIsAttacking(boolean isAttacking) {
        Knight.isAttacking = isAttacking;
    }

    //Dead
    public static boolean getIsDead() {
        return !isDead;
    }
    public static void setIsDead(boolean isDead) {
        Knight.isDead = isDead;
    }

    //const get
    public static int getSize(){ return size; }
    public static int getJumpHeight() {
        return jumpHeight;
    }

    public static int getX() {
        return x;
    }

   public static void setY(int y) {
        Knight.y = y;
    }
    public static int getY() {
        return y;
    }
}
