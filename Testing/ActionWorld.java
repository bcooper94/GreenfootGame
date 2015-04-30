import greenfoot.*;

/**
 * Write a description of class ActionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActionWorld extends World
{

    /**
     * Constructor for objects of class ActionWorld.
     * 
     */
    
    DialogWorld previous;
    
    public ActionWorld(DialogWorld returnHere)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        String[] temp = {"nice to meet you", "where you been?", "NOPE"};
        previous = returnHere;
        this.addObject(new Text(temp), 500,600);
    }
    public void act()
    {
        if(Greenfoot.getKey() == "space")
            Greenfoot.setWorld(previous);
   }
}
