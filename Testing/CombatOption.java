import greenfoot.*;
import java.util.LinkedList;
import java.awt.Color;

/**
 * Write a description of class OptionsPane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatOption extends HUD
{
    private static final int MAX_TEXT_WIDTH = 50;
    private static final int TEXT_HEIGHT = 15;
    private String mouseOverImg;
    private String noMouseOverImg;
    private boolean mouseOver;
    
    public CombatOption(String mouseOverImg, String noMouseOverImg) {
       GreenfootImage image = new GreenfootImage(MAX_TEXT_WIDTH, TEXT_HEIGHT);
       this.mouseOverImg = mouseOverImg;
       this.noMouseOverImg = noMouseOverImg;
       mouseOver = false;
       setImage(new GreenfootImage(noMouseOverImg));
    }
    
    /**
     * Act - do whatever the OptionsPane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage(new GreenfootImage(mouseOverImg));
            mouseOver = true;  
        }  
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
        {  
             setImage(new GreenfootImage(noMouseOverImg));  
             mouseOver = false;  
        }
    }    
    /*
    public void selectUp() {
        if (selectedOption > 0) {
            selectedOption--;
        }
    }
    
    public void selectDown() {
        if (selectedOption < options.length) {
            selectedOption++;
        }
    }
    */
}
