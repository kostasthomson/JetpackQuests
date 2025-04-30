import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Prop
{
    private boolean canCollide = true;
    
    public Enemy() {
        this(new Vector(180, 3));
    }
    
    public Enemy(Vector movement) {
        super(movement);
    }
    
    public void scaleImage() {}
    
    public void collisionAction(Player player) 
    {
        Greenfoot.playSound("rock_hit.mp3");
        getWorldOfType(Level.class).showWave(getX(), getY());
        player.reduceLives();
    }
}
