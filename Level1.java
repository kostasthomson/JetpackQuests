import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{
    private long enemiesCount = 0;
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1(int players)
    {    
        super(5, 3, "collect 5 Stars");
        p1 = new Player1();
        if (players > 1)
            p2 = new Player2();
        addPlayers();
    } 
    
    protected void createProps() {
        if (addObjectWithProbability(Enemy.class, 985))
            enemiesCount++;
        if (enemiesCount == 10) {
            addObjectWithProbability(Star.class, -1);
            enemiesCount = 0;
        }
    }
    
    protected void nextLevel() {
        Greenfoot.setWorld(new Level2(p1, p2));
    }
}
