import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boost extends Collectable
{   
    public Boost() {
        this(new Vector(180, 2));
    }
    
    public Boost(Vector movement) {
        super(movement);
        getImage().scale(53, 65);
    }
    
    public void scaleImage() {
        getImage().scale(40, 50);
    }
    
    public void collisionAction(Player player) {
        setTransparency();
        Greenfoot.playSound("boost.mp3");
        player.fillBoost();
    }
}
