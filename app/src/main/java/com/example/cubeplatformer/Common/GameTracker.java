package com.example.cubeplatformer.Common;

import android.graphics.Point;

import com.example.cubeplatformer.IvanGameView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameTracker {

    public GameTracker() {

    }

    private static final int DEFAULT_SPEED = 6;
    private static final int DEFAULT_JUMP_HEIGHT = 10;      // EVERY FRAME JUMP INCREASES BY THIS!
    private static final int DEFAULT_MAX_JUMP = IvanGameView.elementSize * 3 + IvanGameView.elementSize / 3;
    private static final int DEFAULT_SCORE = 2;
    private static final int DEFAULT_SCORE_RATE = 15;
    private static final int DEFAULT_SCORE_MULTIPLIER = 1;
    private static final int DEFAULT_MODULE_RATE = 225;
    private static final Point DEFAULT_SCREEN_SIZE = new Point(IvanGameView.xx, IvanGameView.yy);

    private static int jumpHeight = DEFAULT_JUMP_HEIGHT;
    private static int maxJump = DEFAULT_MAX_JUMP;
    private static int speed = DEFAULT_SPEED;
    private static int score = DEFAULT_SCORE;
    private static int scoreMultiplier = DEFAULT_SCORE_MULTIPLIER;
    private static int scoreRate = DEFAULT_SCORE_RATE;
    private static int moduleRate = DEFAULT_MODULE_RATE;
    private static Point screenSize = DEFAULT_SCREEN_SIZE;

    private static boolean godMode = false; // Functional, use for debug purposes

    public static ArrayList<Integer> scores = new ArrayList<>();

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        GameTracker.speed = speed;
    }

    public void resetScore() {
        score = DEFAULT_SCORE;
    }

    public void resetScoreMultiplier() {
        scoreMultiplier = DEFAULT_SCORE_MULTIPLIER;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getScoreRate() {
        return scoreRate;
    }

    public static void setScoreRate(int scoreRate) {
        GameTracker.scoreRate = scoreRate;
    }

    public static void updateScore() {
        score += scoreRate * scoreMultiplier;
    }

    public static boolean isGodMode() {
        return godMode;
    }

    public static void toggleGodMode() {
        godMode = !godMode;
    }

    public static int getJumpHeight() {
        return jumpHeight;
    }

    public static int getMaxJump() {
        return maxJump;
    }

    public static void setMaxJump(int maxJump) {
        GameTracker.maxJump = maxJump;
    }

    public static void setJumpHeight(int jumpHeight) {
        GameTracker.jumpHeight = jumpHeight;
    }

    public static Point getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Point screenSize) {
        GameTracker.screenSize = screenSize;
    }

    public static int getModuleRate() {
        return moduleRate;
    }

    public static void setModuleRate(int moduleRate) {
        GameTracker.moduleRate = moduleRate;
    }

    public static int getHighScore() {
        if (scores.isEmpty()) {
            return 0;
        }

        return Collections.max(scores);
    }

    public static int getCurrentScore() {
        if (scores.isEmpty()) {
            return 0;
        }

        return scores.get(scores.size() - 1);
    }

}
