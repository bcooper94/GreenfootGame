import greenfoot.*;

/**
 * Write a description of class DialogWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogWorld extends World
{
    ActionWorld returnWorld;
    /**
     * Constructor for objects of class DialogWorld.
     * 
     */
    
   // ActionWorld action;
   public DialogWorld() {
       super(800, 600, 1);
       
       returnWorld = new ActionWorld(this, new GenericLevel());
       Player player = new Player(returnWorld, "Bob");
       
        //action = new World(this, null, null);
        
        String[] temp = {"hi", "you touched me!", "did you get this far? :3", "eien jaaaaa naiiiii", 
            "yukou~", "samurai ni umarete", "samurai no kokoro wo daiiiiite"};
        
        this.addObject(new Background(), 500, 400);
        this.addObject(new Reake(), 650, 400);  
        this.addObject(new Text(temp, returnWorld), 400, 550);
   }
    
    public DialogWorld(ActionWorld returnWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        //action = new World(this, null, null);
        
        String[] temp = {"hi", "you touched me!", "did you get this far? :3", "eien jaaaaa naiiiii", 
            "yukou~", "samurai ni umarete", "samurai no kokoro wo daiiiiite"};
        
        this.addObject(new Background(), 500, 400);
        this.addObject(new Reake(), 650, 400);  
        this.addObject(new Text(temp, returnWorld), 400, 550);
   }
   public void act()
   {
       String[] temp = {"hi", "you touched me!", "did you get this far? :3", "eien jaaaaa naiiiii", 
            "yukou~", "samurai ni umarete", "samurai no kokoro wo daiiiiite"};
       //if(Greenfoot.getKey() == "space")
            //Greenfoot.setWorld(action);
   }
}
