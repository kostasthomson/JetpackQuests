import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Collectable
{
    public Life() {
        this(new Vector(180, 2));
    }
    
    public Life(Vector movement) {
        super(movement);
    }
    
    public void scaleImage() {
        getImage().scale(40, 35);
    }
    
    public void collisionAction(Player player) {}
}
