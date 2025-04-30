import greenfoot.*;

/**
 * Write a description of class MoverUtilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MoverUtilities  
{
    private static int heightPartitions = 10;
    public static int getMoverRandomX(int width) {
        return width + Greenfoot.getRandomNumber(width) + 10;
    }
    public static int getMoverRandomY(int height) {
        return  height * Greenfoot.getRandomNumber(heightPartitions) / heightPartitions;
    }
}