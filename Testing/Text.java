import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    String[] curText;
    int curDialog;
    
    public Text(String[] dialog)
    {
        curDialog = 0;
        curText = dialog;
        setImage(new GreenfootImage(curText[curDialog], 50, Color.WHITE, Color.BLACK));
    }
    public void act() 
    {
       if(Greenfoot.mouseClicked(null))
       {
           if(curDialog < curText.length - 1)
                curDialog++;
           setImage(new GreenfootImage(curText[curDialog], 50, Color.WHITE, Color.BLACK));
       }
    }    
}
