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
    
    private DialogWorld previous;
    private ActionBar actionBar;
    private HealthBar healthBar;
    private Actor background;
    private Player player;
    
    public ActionWorld(DialogWorld returnHere)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.player = player;
        //String[] temp = {"nice to meet you", "where you been?", "NOPE"};
        previous = returnHere;
        //this.addObject(new Text(temp, this), 500, 600);
        actionBar = new ActionBar(this);
        healthBar = new HealthBar(Player.getHealth(), Player.getMaxHealth());
        
        //MovingNinja ninja = new MovingNinja(this);
        
        addObject(actionBar, 350, 451);
        addObject(healthBar, 200, 350);
        //addObject(new GroundPlatform(), 300, 250);
        //addObject(ninja, 500, 155);
        //ninja.addCollision();
    }
    
    public void act()
    {
        //if(Greenfoot.getKey() == "space")
        //    Greenfoot.setWorld(previous);
   }
   
   public ActionWorld getWorld() {
       return this;
   }
   /*
   public void addObject(Player player, int x, int y) {
       super.addObject(player, x, y);
       this.player = player;
   }
   */
   public void addPlayer(Player player, int xCoord, int yCoord, boolean show) {
       this.player = player;
       if (show) {
           addObject(player, xCoord, yCoord);
       }
   }
   
   public Player getPlayer() {
       return this.player;
   }
}
