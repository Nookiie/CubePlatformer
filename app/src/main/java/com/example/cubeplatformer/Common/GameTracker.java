package com.example.cubeplatformer.Common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameTracker {

    public GameTracker() {

    }

    private static final int DEFAULT_SPEED = 6;
    private static final int DEFAULT_JUMP_HEIGHT = 10;      // EVERY FRAME JUMP INCREASES BY THIS!
    private static final int DEFAULT_MAX_JUMP = 250;
    private static final int DEFAULT_SCORE = 2;
    private static final int DEFAULT_SCORE_RATE = 15;
    private static final int DEFAULT_SCORE_MULTIPLIER = 1;
    private static final int DEFAULT_ENEMY_RATE = 1;
    private static final int DEFAULT_SPIKES_RATE = 1;
    private static final int DEFAULT_PLATFORM_LEVEL = 0;

    private static int jumpHeight = DEFAULT_JUMP_HEIGHT;
    private static int maxJump=DEFAULT_MAX_JUMP;
    private static int speed = DEFAULT_SPEED;
    private static int score = DEFAULT_SCORE;
    private static int scoreMultiplier = DEFAULT_SCORE_MULTIPLIER;
    private static int scoreRate = DEFAULT_SCORE_RATE;
    private static int enemyRate = DEFAULT_ENEMY_RATE;
    private static int spikesRate = DEFAULT_SPIKES_RATE;
    private static int platformLevel = DEFAULT_PLATFORM_LEVEL;

    private static boolean paused = false;
    private static boolean godMode = false;
    private static boolean spikesDisabled = false;

    public static Collection<Integer> scores = new ArrayList<>();

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        GameTracker.speed = speed;
    }

    public void resetScore(){
        score = DEFAULT_SCORE;
    }

    public void resetSpikesRate(){
        spikesRate = DEFAULT_SPIKES_RATE;
    }

    public void resetScoreMultiplier(){
        scoreMultiplier = DEFAULT_SCORE_MULTIPLIER;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

    public void setScoreMultiplier(int scoreMultiplier) {
        this.scoreMultiplier = scoreMultiplier;
    }

    public int getEnemyRate() {
        return enemyRate;
    }

    public void setEnemyRate(int enemyRate) {
        this.enemyRate = enemyRate;
    }

    public int getSpikesRate() {
        return spikesRate;
    }

    public void setSpikesRate(int spikesRate) {
        this.spikesRate = spikesRate;
    }

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return platformLevel;
    }

    public void setLevel(int level) {
        this.platformLevel = level;
    }

    public static int getScoreRate() {
        return scoreRate;
    }

    public static void setScoreRate(int scoreRate) {
        GameTracker.scoreRate = scoreRate;
    }

    public static int getPlatformLevel() {
        return platformLevel;
    }

    public static void setPlatformLevel(int platformLevel) {
        GameTracker.platformLevel = platformLevel;
    }

    public static void  updateScore(){
        score += scoreRate * scoreMultiplier;
    }

    public static boolean isPaused() {
        return paused;
    }

    public static void togglePaused() {
        paused = !paused;
    }

    public static boolean isGodMode() {
        return godMode;
    }

    public static void toggleGodMode() {
        godMode = !godMode;
    }

    public static boolean isSpikesDisabled() {
        return spikesDisabled;
    }

    public static void toggleSpikesDisabled() {
        spikesDisabled = !spikesDisabled;
    }

    public static int getJumpHeight() {
        return jumpHeight;
    }

    public static int getMaxJump() {
        return maxJump;
    }

    public static void setJumpHeight(int jumpHeight) {
        GameTracker.jumpHeight = jumpHeight;
    }

    public static int getHighScore(){
        if(scores.isEmpty()){
            return 0;
        }

        return Collections.max(scores);
    }

}
