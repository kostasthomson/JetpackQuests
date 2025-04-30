import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootSound music = new GreenfootSound("bg_menu_music.wav");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(WorldUtilities.WORLD_WIDTH, WorldUtilities.WORLD_HEIGHT, WorldUtilities.WORLD_PIXEL);
        Greenfoot.start();
        music.setVolume(90);
        music.playLoop();
    }
     public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            music.setVolume(75);
            Greenfoot.setWorld(new Level1());
        }
    }
}
