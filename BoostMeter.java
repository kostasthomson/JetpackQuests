import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SimpleTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoostMeter extends Actor
{
    private int initialAmount = 200;
    private double boostAmount;

    public BoostMeter() {
        boostAmount = initialAmount;
        updateImage();
    }

    public double boostLeft() {
        return boostAmount;
    }
    
    public void updateImage() {
        setImage(new GreenfootImage(": " + (int) boostAmount, 24, Color.WHITE, new Color(0,0,0,0)));
    }
    
    public void fill() {
        boostAmount = Math.min(initialAmount, boostAmount + 70);
        updateImage();
    }
    
    public void use() {
        if (hasBoost() && (getWorld() instanceof Level2)) {
            boostAmount -= 0.5;
            updateImage();
        }
    }
    
    public boolean hasBoost() {
        return boostAmount >= 1;
    }
}
