package com.example.cubeplatformer.Common;

public class GameTracker {

    public GameTracker() {

    }

    private static int score = 0;
    private static int scoreMultiplier = 1;
    private static int scoreRate = 5;
    private static int enemyRate = 1;
    private static int spikesRate = 1;
    private static int platformLevel = 0;

    private static final int DEFAULT_SCORE = 0;
    private static final int DEFAULT_SCORE_MULTIPLIER = 1;
    private static final int DEFAULT_ENEMY_RATE = 1;
    private static final int DEFAULT_SPIKES_RATE = 1;

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
}
