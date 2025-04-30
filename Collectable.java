import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collectable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Collectable extends Prop
{    
    public Collectable(Vector movement) {
        super(movement);
    }
    
    public void setTransparency() {
        getImage().setTransparency(0);
    }
}
