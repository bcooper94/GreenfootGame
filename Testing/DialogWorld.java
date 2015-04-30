import greenfoot.*;

/**
 * Write a description of class DialogWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogWorld extends World
{

    /**
     * Constructor for objects of class DialogWorld.
     * 
     */
    
    ActionWorld action;
    
    public DialogWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        action = new ActionWorld(this);
        
        String[] temp = {"hi", "you touched me!", "did you get this far? :3", "eien jaaaaa naiiiii", 
            "yukou~", "samurai ni umarete", "samurai no kokoro wo daiiiiite"};
        
        this.addObject(new Background(), 500, 400);
        this.addObject(new Reake(), 780, 400);
        this.addObject(new Text(temp), 500, 700);
   }
   public void act()
   {
       String[] temp = {"hi", "you touched me!", "did you get this far? :3", "eien jaaaaa naiiiii", 
            "yukou~", "samurai ni umarete", "samurai no kokoro wo daiiiiite"};
       if(Greenfoot.getKey() == "space")
            Greenfoot.setWorld(action);  
   }
}
