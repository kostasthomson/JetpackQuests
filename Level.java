import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Level extends World
{
    protected ScoreBoard score;
    protected LifeCounter life;
    protected Player1 p1;
    protected Player2 p2;
    protected int promoScore;
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level(int promo_score)
    {    
        super(WorldUtilities.WORLD_WIDTH, WorldUtilities.WORLD_HEIGHT, WorldUtilities.WORLD_PIXEL); 
        promoScore = promo_score;
    }
    
    public void act() {
        checkPlayers();
        createProps();
        applyBoostEffect();
    }
    
    public List<Player> getPlayers() {
        return Arrays.asList(new Player[] {p1, p2});
    }
    
    protected abstract void nextLevel();
    protected abstract void createProps();
    
    private void gameOver() {
        Greenfoot.setWorld(new GameOverScreen(p1, p2));
    }
    
    protected void addPlayers() {
        p1.show(this, 150, getHeight() / 4);
        p2.show(this, 150, getHeight() * 3 / 4);
    }
    
    protected boolean addObjectWithProbability(Class<? extends Actor> cls, int probability) {
        if (Greenfoot.getRandomNumber(1000) < probability)
            return false;
        int x = MoverUtilities.getMoverRandomX(getWidth());
        int y = MoverUtilities.getMoverRandomY(getHeight());
        try {
            addObject(cls.newInstance(), x, y);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    protected void checkPlayers() {
        checkPlayersLives();
        checkPlayersPromoScore(promoScore);
    }
    
    private void checkPlayersPromoScore(int promoScore) {
        if (p1.hasPromoScore(promoScore) || p2.hasPromoScore(promoScore))
            nextLevel();
    }
    
    private void checkPlayersLives() {
        if (!p1.hasLives() || !p2.hasLives())
            gameOver();
    }
    
    private void applyBoostEffect() {
        List<Prop> props = getObjects(Prop.class);
        for (Prop prop : props) {
            prop.toggleSpeed(p1.isThrusting() || p2.isThrusting());
        }
    }
    
    public void showWave(int x, int y) {
        addObject(new ProtonWave(), x, y);
    }
}
