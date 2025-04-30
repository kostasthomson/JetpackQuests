import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameEndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameEndScreen extends ResultScreen
{
    public GameEndScreen() {
        this(new Player1(), new Player2());
    }
    
    public GameEndScreen(Player p1, Player p2)
    {
        super(new ScreenText("Game Completed", Color.GREEN), p1, p2);
        Greenfoot.playSound("victory.mp3");
    }
}