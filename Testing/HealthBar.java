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
    
    public HealthBar(int maxHealth, int curHealth) {
        this.maxHealth = this.curHealth = maxHealth;
    }
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (getWorld() != null) {
            redraw((ActionWorld)getWorld());
        }
    }
    
    public void redraw(ActionWorld curWorld) {
        /*
        bar = new GreenfootImage(BARWIDTH, BARHEIGHT);
        bar.setColor(Color.RED);
        bar.fill();
        bar.drawRect(15, 250, BARWIDTH - 4, BARHEIGHT - 4);
        bar.fillRect(15, 250, (Player.getHealth() / Player.getMaxHealth()) * BARWIDTH, BARHEIGHT);
        //bar.fill();
        setImage(bar);
        */
        
        
        int barValue = (int) (BARWIDTH * (Player.getHealth() / Player.getMaxHealth()));
        GreenfootImage barImg = new GreenfootImage(BARWIDTH + 4, BARHEIGHT + 4);
        barImg.setColor(Color.BLACK);
        barImg.fill();
        barImg.setColor(Color.RED);
        barImg.drawRect(0, 0, barImg.getWidth() - 1, barImg.getHeight() - 1);
        barImg.setColor(Color.RED);
        barImg.fillRect(2, 2, barValue, BARHEIGHT);
        
        int maxY = 0;
        if (barImg.getHeight() > maxY) maxY = barImg.getHeight();
        GreenfootImage image = new GreenfootImage(BARWIDTH, BARHEIGHT);
        ///image.setColor(Color.BLACK);
        //image.fill();
        image.drawImage(barImg, 20, 350);
        setImage(barImg);
    }
    
    public void changeHealth(int amount) {
        curHealth += amount;
        redraw((ActionWorld)getWorld());
    }
}
