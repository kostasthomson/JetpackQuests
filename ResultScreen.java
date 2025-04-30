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
    private final int OFFSET =100;
    private final int centerX = 400;
    protected final int p1Score;
    protected final int p2Score;
    /**
     * Constructor for objects of class ResultScreen.
     * 
     */
    public ResultScreen(ScreenText screen_text, Player p1, Player p2)
    {    
        super(WorldUtilities.WORLD_WIDTH, WorldUtilities.WORLD_HEIGHT, WorldUtilities.WORLD_PIXEL);
        p1Score = p1.getScore();
        p2Score = p2.getScore();
        p1.setStill();
        p2.setStill();
        int quarter = centerX / 2 + 5;
        addObject(screen_text, centerX, MESSAGE_HEIGHT);
        addObject(p1, quarter, MESSAGE_HEIGHT + OFFSET);
        addObject(new ScreenScore("Score:", p1Score), quarter + 100, MESSAGE_HEIGHT + OFFSET);
        addObject(p2, quarter + 300, MESSAGE_HEIGHT + OFFSET);
        addObject(new ScreenScore("Score:", p2Score), quarter + 400, MESSAGE_HEIGHT + OFFSET);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        } else if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(new MyWorld());
            Greenfoot.stop();
        }
    }
}
