import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalSmoothMover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalSmoothMover extends SmoothMover
{
    public VerticalSmoothMover()
    {
        this(new Vector());
    }
    
    /**
     * Create new thing initialised with given speed.
     */
    public VerticalSmoothMover(Vector movement)
    {
        super(movement);
    }
    
    public void moveVertical() {
        incrementY();
        checkBorders();
        updateLocation();
    }
}
