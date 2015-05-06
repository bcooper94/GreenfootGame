import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends HUD
{
    private static final int BARHEIGHT = 20;
    private static final int BARWIDTH = 80;
    private ActionWorld world;
    private int maxHealth;
    private int curHealth;
    private GreenfootImage bar;
    
    public HealthBar(ActionWorld world, int maxHealth, int curHealth) {
        bar = new GreenfootImage(BARHEIGHT, BARWIDTH);
        this.maxHealth = this.curHealth = maxHealth;
        this.world = world;
        redraw(world);
    }
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public void redraw(ActionWorld curWorld) {
        bar.drawRect(15, 250, BARWIDTH - 4, BARHEIGHT - 4);
        bar.setColor(Color.RED);
        bar.fillRect(15, 250, (curHealth / maxHealth) * BARWIDTH, BARHEIGHT);
        setImage(bar);
        curWorld.addObject(this, 200, 200);
    }
    
    public void changeHealth(int amount) {
        curHealth += amount;
        redraw(world);
    }
}
