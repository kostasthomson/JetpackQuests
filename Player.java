import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player extends VerticalSmoothMover
{
    protected GreenfootImage rocket;
    protected GreenfootImage rocketWithThrust;
    protected GreenfootImage noImage = null;
    
    protected BoostMeter boost;
    protected LifeCounter lives;
    protected ScoreBoard score;
        
    protected Vector gravity = new Vector(90, 0.2);
    protected Vector thrust = new Vector(270, 0.45);
    protected boolean thrusting = false;
    
    private boolean isBlinking = false;
    private boolean isVisible = true;
    private int blinkCounter = 0;
    private int blinkFrameCounter = 0;
    private int neighboursDistance = WorldUtilities.WORLD_WIDTH;
    private GreenfootSound rocketThrust = new GreenfootSound("thrust.mp3");
    private boolean isStill = false;
    
    public Player(GreenfootImage rocketImage, GreenfootImage rocketWithThrustImage) {
        rocket = rocketImage;
        rocketWithThrust = rocketWithThrustImage;
        setImage(rocket);
        score = new ScoreBoard();
        lives = new LifeCounter(3);
        boost = new BoostMeter();
        rocketThrust.setVolume(50);
    }
    
    public abstract void show(Level level, int x, int y);
    
    public void setStill() {
        gravity.setNeutral();
        getMovement().setNeutral();
        isBlinking = false;
        isStill = true;
    }
    
    public boolean isThrusting() {
        return thrusting;
    }
    
    public boolean isClose(Prop prop) {
        return getMovement().isInRadius(prop.getMovement());
    }
    
    protected void applyGravity() {
        addForce(gravity);
        limitSpeed(6.5);
    }
    
    protected void limitSpeed(double maxSpeed) {
        Vector movement = getMovement();
        double length = movement.getLength();
        if (length > maxSpeed) {
            movement.setLength(maxSpeed);
            setMovement(movement);
        }
    }
    
    protected void ignite() {
        if (boost.hasBoost()) {
            if (thrusting) {
                setImage(rocketWithThrust);
                rocketThrust.play();
                if (!isStill) {
                    addForce(thrust);
                    boost.use();
                }
            } else {
                setImage(rocket);
                rocketThrust.stop();
            }
        }
        limitSpeed(20);
        handleBlinking(thrusting);
    }
    
    protected void handleBlinking(boolean thrusting) {
        if (isBlinking) {
            blinkFrameCounter++;
            if (blinkFrameCounter % 5 == 0) {
                if (isVisible) {
                    setImage(noImage);
                } else {
                    if (thrusting) {
                        setImage(rocketWithThrust);
                    } else {
                        setImage(rocket);
                    }
                }
                isVisible = !isVisible;
                blinkCounter++;
            }
            if (blinkCounter >= 15) {
                setImage(thrusting ? rocketWithThrust : rocket);
                isBlinking = false;
                isVisible = true;
                blinkCounter = 0;
                blinkFrameCounter = 0;
            }
        }
    }
    
    protected void startBlinking() {
        isBlinking = true;
        blinkCounter = 0;
        blinkFrameCounter = 0;
    }
    
    protected void showHUD(Level level, int x, int y, int xOffset, int yOffset, int Ymargin) {
        Star star = new StarHUD();
        Life life = new LifeHUD();
        Boost booster = new BoostHUD();
        level.addObject(life, x, y);
        level.addObject(lives, x + xOffset, y);
        level.addObject(star, x, y + yOffset);
        level.addObject(score, x + xOffset, y + yOffset);
        if (level instanceof Level2) {
            level.addObject(booster, x, y + 2 * yOffset + Ymargin);
            level.addObject(boost, x + (int) (xOffset * 1.3), y + 2 * yOffset + Ymargin);
        }
    }
    
    public void fillBoost() {
        boost.fill();
    }
    
    public void reduceLives() {
        lives.loseLife();
        Greenfoot.playSound("player_hit.mp3");
        startBlinking();
    }
    
    public void updateScore(int points) {
        score.addScore(points);
    }
    
    public boolean hasPromoScore(int promoScore) {
        return score.getScore() == promoScore;
    }
    
    public boolean hasLives() {
        return lives.isAlive();
    }
    
    public int getScore() {
        return score.getScore();
    }
    
    public void setLives(int nlives) {
        lives.setLives(nlives);
    }
}
