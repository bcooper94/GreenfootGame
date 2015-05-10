import greenfoot.*;
import java.util.LinkedList;
import java.awt.Color;

/**
 * Write a description of class OptionsPane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CombatOption extends HUD
{
    private static final int MAX_TEXT_WIDTH = 50;
    private static final int TEXT_HEIGHT = 15;
    private String mouseOverImg;
    private String noMouseOverImg;
    //private boolean mouseOver;
    private boolean selected;
    
    public CombatOption(String mouseOverImg, String noMouseOverImg) {
       GreenfootImage image = new GreenfootImage(MAX_TEXT_WIDTH, TEXT_HEIGHT);
       this.mouseOverImg = mouseOverImg;
       this.noMouseOverImg = noMouseOverImg;
       //mouseOver = false;
       setImage(new GreenfootImage(noMouseOverImg));
       selected = false;
    }
    
    /**
     * Act - do whatever the OptionsPane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Removed mouse over support
        if (/*!mouseOver && Greenfoot.mouseMoved(this) || */selected)
        {  
            setImage(new GreenfootImage(mouseOverImg));
            //mouseOver = true;
        }  
        if (/*mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) || */!selected)  
        {  
             setImage(new GreenfootImage(noMouseOverImg));  
             //mouseOver = false;
        }
    }    
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public abstract void carryOut(Player player, CombatEnemy enemy);
}
