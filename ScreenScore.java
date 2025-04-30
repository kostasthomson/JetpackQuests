import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenScore extends Actor
{
    public ScreenScore(String message, int finalScore) {
        setImage(new GreenfootImage(message + " " + finalScore, 24, Color.WHITE, new Color(0, 0, 0, 160)));
    }
}
