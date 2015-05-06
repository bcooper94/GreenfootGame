import greenfoot.*;
import java.util.LinkedList;
import java.awt.Color;

/**
 * Write a description of class OptionsPane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionsPane extends HUD
{
    private static final int MAX_TEXT_WIDTH = 50;
    private static final int TEXT_HEIGHT = 15;
    private static final String[] options = {"Attack", "Defend", "Flee"};
    private static final String optionStr = "Attack\nDefend\nFlee";
    private int selectedOption;
    
    public OptionsPane(CombatWorld world) {
        GreenfootImage text;
        GreenfootImage image = new GreenfootImage(MAX_TEXT_WIDTH, TEXT_HEIGHT);
        
        selectedOption = 0;
       setImage(new GreenfootImage(optionStr, 28, Color.WHITE, new Color(210, 180, 140)));
       world.addObject(this, 450, 350);
    }
    
    /**
     * Act - do whatever the OptionsPane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
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
}
