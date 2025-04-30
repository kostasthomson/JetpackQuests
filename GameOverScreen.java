import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends ResultScreen
{
    public GameOverScreen() {
        this(new Player1(), new Player2());
    }
    
    public GameOverScreen(Player p1, Player p2) 
    {
        super(new ScreenText("Game Over", Color.RED), p1, p2);
        Greenfoot.playSound("defeat.mp3");
    }
}