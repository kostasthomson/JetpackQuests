import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResultScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ResultScreen extends World
{
    private final int MESSAGE_HEIGHT = 200;
    private final int OFFSET = 100;
    private final int centerX = 400;
    private int quarter = centerX - 65;
    private int xPlayerOffset = 100;
    /**
     * Constructor for objects of class ResultScreen.
     * 
     */
    public ResultScreen(ScreenText screen_text, Player p1, Player p2)
    {    
        super(WorldUtilities.WORLD_WIDTH, WorldUtilities.WORLD_HEIGHT, WorldUtilities.WORLD_PIXEL);
        addObject(screen_text, centerX, MESSAGE_HEIGHT);
        boolean p2Exists = p2 != null;
        if (p2Exists)
            quarter = centerX / 2 + 5;
        showPlayerScore(p1);
        if (p2Exists)
            showPlayerScore(p2);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        } else if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(new MyWorld());
            Greenfoot.stop();
        }
    }
    
    private void showPlayerScore(Player p) {
        int pScore = p.getScore();
        p.setStill();
        addObject(p, quarter + xPlayerOffset - 100, MESSAGE_HEIGHT + OFFSET);
        addObject(new ScreenScore(pScore), quarter + xPlayerOffset, MESSAGE_HEIGHT + OFFSET);
        xPlayerOffset += 300;
    }
}
