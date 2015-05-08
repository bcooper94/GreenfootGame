import greenfoot.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

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
    
    private static int TEXTSIZE = 30;
    private Color bgColor = Color.BLACK;
    private String[] curText;
    private ArrayList <String> text;
    private ActionWorld returnWorld;
    public int curDialog;
    
    public Text(String[] dialog, ActionWorld returnWorld)
    {
        curText = dialog;
        curDialog = 0;
        setImage(new GreenfootImage(curText[curDialog], TEXTSIZE, Color.WHITE, bgColor));
        this.returnWorld = returnWorld;
    }
    public Text(ArrayList <String> dialog)
    {
        curDialog = 0;
        text = dialog;
        setImage(new GreenfootImage(text.get(curDialog), TEXTSIZE, Color.WHITE, bgColor));
    }
    
    public void act() 
    {
       if(Greenfoot.mouseClicked(null))
       {
           if(curText != null && curDialog < curText.length - 1)
                curDialog++;
           else if(curDialog < text.size() -1)
                curDialog++;
           if(curText != null)
                setImage(new GreenfootImage(curText[curDialog], TEXTSIZE, Color.WHITE, bgColor));
           else
                setImage(new GreenfootImage(text.get(curDialog), TEXTSIZE, Color.WHITE, bgColor));
       }
    }    
    public void speedAct()
    {
        if(curText != null && curDialog < curText.length - 1)
                setImage(new GreenfootImage(curText[curDialog], TEXTSIZE, Color.WHITE, bgColor));
           else
                setImage(new GreenfootImage(text.get(curDialog), TEXTSIZE, Color.WHITE, bgColor));
    }
    public int getCur()
    {
        return curDialog;
    }
    public void setBG(Color newBG)
    {
        bgColor = newBG;
    }
}
