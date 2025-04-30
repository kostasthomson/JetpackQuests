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
    private GreenfootSound click = new GreenfootSound("mouse_click.mp3");
    private int players = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(WorldUtilities.WORLD_WIDTH, WorldUtilities.WORLD_HEIGHT, WorldUtilities.WORLD_PIXEL);
        Greenfoot.start();
        click.setVolume(50);
        music.setVolume(90);
        music.playLoop();
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("ς")) {
            click.play();
            setBackground("main_menu_1.png");
            players = 1;
        }
        if (Greenfoot.isKeyDown("up")) {
            click.play();
            setBackground("main_menu_2.png");
            players = 2;
        }
        if (Greenfoot.isKeyDown("enter")) {
            click.play();
            music.setVolume(75);
            Greenfoot.setWorld(new Level1(players));
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
