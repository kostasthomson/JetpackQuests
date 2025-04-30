import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
{
    private long enemiesCount = 0;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2() {
        this(new Player1(), null);
    }

    public Level2(Player1 player1, Player2 player2)
    {    
        super(10, 5, "collect 10 Stars");
        p1 = player1;
        p2 = player2;
        addPlayers();
    }
        
    protected void createProps() {
        if (addObjectWithProbability(Enemy.class, 975))
            enemiesCount++;
        if (enemiesCount == 4) {
            addObjectWithProbability(Boost.class, -1);
            enemiesCount++;
        } else if (enemiesCount == 10) {
            addObjectWithProbability(Star.class, -1);
            enemiesCount = 0;
        }
    }
    
    public void nextLevel() {
        Greenfoot.setWorld(new GameEndScreen(p1, p2));
    }
}
