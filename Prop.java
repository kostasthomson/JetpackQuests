import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Props here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Prop extends HorizontalSmoothMover
{  
    protected boolean collisionFlag = true;
    private double initialLength;
    private double speedFactor = 2;
    protected boolean isStill = false;
    
    public Prop(Vector movement) {
        super(movement);
        initialLength = movement.getLength();
    }
    
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (isStill) return;
        moveHorizontal();
        checkCollision();
        checkRemove();
    }
        
    public abstract void collisionAction(Player player);
    public abstract void scaleImage();
        
    public void setStill() {
        getMovement().setNeutral();
        isStill = true;
        scaleImage();
    }
    
    public void checkCollision() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null && collisionFlag) {
            collisionFlag = false;
            collisionAction(player);
        }
    }
    
    public void checkRemove() {
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }
    
    public void toggleSpeed(boolean globalThrust) {
        Player player = getWorldOfType(Level.class).getPlayers().get(0);
        boolean isPlayerClose = player.isClose(this);
        getMovement().setLength(globalThrust && isPlayerClose ? initialLength * speedFactor : initialLength);
    }
}
