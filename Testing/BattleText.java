import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class BattleText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleText extends Actor
{
    private int fade;
    
    public BattleText(String text) {
        setImage(new GreenfootImage(text, 20, Color.WHITE, Color.BLACK));
        fade = 255;
    }
    
    /**
     * Act - do whatever the BattleText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (fade > 0) {
            fade--;
            getImage().setTransparency(fade);
        }
    }    
}
