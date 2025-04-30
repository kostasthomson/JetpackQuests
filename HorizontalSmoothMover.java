import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HorizontalSmoothMover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorizontalSmoothMover extends SmoothMover
{
    public HorizontalSmoothMover()
    {
        this(new Vector());
    }
    
    /**
     * Create new thing initialised with given speed.
     */
    public HorizontalSmoothMover(Vector movement)
    {
        super(movement);
    }
    
    public void moveHorizontal() {
        incrementX();
        checkBorders();
        updateLocation();
    }
}
