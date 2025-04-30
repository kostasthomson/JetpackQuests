import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Collectable
{
    public Star() {
        this(new Vector(180, 2));
    }
    
    public Star(Vector movement) {
        super(movement);
    }
    
    public void scaleImage() {
        getImage().scale(40, 35);
    }
    
    public void collisionAction(Player player) {
        setTransparency();
        Greenfoot.playSound("star.mp3");
        player.updateScore(1);
    }
}
