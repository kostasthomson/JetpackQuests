import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifeCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeCounter extends Actor
{
    private int lives;
    
    public LifeCounter() {
        this(3);
    }

    public LifeCounter(int init_lives) {
        lives = init_lives;
        updateImage();
    }
    
    private void updateImage() {
        setImage(new GreenfootImage(": " + lives, 24, Color.WHITE, new Color(0,0,0,0)));
    }

    public void loseLife() {
        lives--;
        updateImage();
    }

    public int getLives() {
        return lives;
    }
    
    public boolean isAlive() {
        return lives > 0;
    }
    
    public void setLives(int nlives) {
        lives = nlives;
        updateImage();
    }
}
