package com.example.cubeplatformer.Common;

public class GameTracker {

    public GameTracker() {

    }

    private static final int DEFAULT_SPEED = 7;
    private static final int DEFAULT_JUMP_HEIGHT = 24;
    private static final int DEFAULT_SCORE = 0;
    private static final int DEFAULT_SCORE_RATE = 5;
    private static final int DEFAULT_SCORE_MULTIPLIER = 1;
    private static final int DEFAULT_ENEMY_RATE = 1;
    private static final int DEFAULT_SPIKES_RATE = 1;
    private static final int DEFAULT_PLATFORM_LEVEL = 0;

    private static int jumpHeight = DEFAULT_JUMP_HEIGHT;
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
    private static boolean enemiesDisabled = false;

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        GameTracker.speed = speed;
    }

    public void resetScore(){
        score = DEFAULT_SCORE;
    }

    public void resetEnemyRate(){
        enemyRate = DEFAULT_ENEMY_RATE;
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

    public int getScore() {
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

    public static boolean isEnemiesDisabled() {
        return enemiesDisabled;
    }

    public static void toggleEnemiesDisabled() {
        enemiesDisabled = !enemiesDisabled;
    }


    public static int getJumpHeight() {
        return jumpHeight;
    }

    public static void setJumpHeight(int jumpHeight) {
        GameTracker.jumpHeight = jumpHeight;
    }

}
