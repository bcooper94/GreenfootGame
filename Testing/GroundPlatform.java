import greenfoot.*;

/**
 * Write a description of class GroundPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundPlatform extends Ground
{
    public GroundPlatform() {
        GreenfootImage ground = new GreenfootImage("ground.png");
        ground.setTransparency(0);
        setImage(ground);
    }
}
