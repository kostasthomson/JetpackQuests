import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenText extends Actor
{
    public ScreenText(String text) {
        this(text, Color.WHITE);
    }
    
    public ScreenText(String text, Color color) {
        setImage(new GreenfootImage(text, 28, color, new Color(0, 0, 0, 160)));
    }
}
