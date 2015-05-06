import greenfoot.*;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActionBar extends HUD
{
    private int health;
    private int level;
    private int experience;
    private GreenfootImage barImage;
    private GreenfootImage healthImage;
    
    public ActionBar(ActionWorld world) {
        barImage = new GreenfootImage(800, 150);
        barImage.drawImage(new GreenfootImage("placeholderHUDBar.png"), 0, 0);
        barImage.drawString("" + Player.getHealth(), 100, 53);
        setImage(barImage);
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        redraw();
    }
    
    public void redraw() {
        
    }
}
