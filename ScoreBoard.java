import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private int score;
    
    public ScoreBoard() {
        this(0);
    }
    
    public ScoreBoard(int init_score) {
        score = init_score;
        updateImage();
    }
    
    public void addScore(int points) {
        score += points;
        updateImage();
    }
    
    private void updateImage() {
        setImage(new GreenfootImage(": " + score, 24, Color.WHITE, new Color(0,0,0,0)));
    }
    
    public int getScore() {
        return score;
    }
}
