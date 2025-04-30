import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    public Player1(Vector movement) {
        this();
        getMovement().setNeutral();
    }
    
    public Player1() {
        super(
            new GreenfootImage("player_1_0.png"),
            new GreenfootImage("player_1_1.png")
        );
    }
    
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        applyGravity();
        moveVertical();
        checkKeys();
        ignite();
    }
    
    private void checkKeys() {
        thrusting = Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("ς");
    }
    
    public void show(Level level, int x, int y) {
        level.addObject(this, x, y);
        showHUD(level, 25, 25, 40, 45, 5);
    }
}
