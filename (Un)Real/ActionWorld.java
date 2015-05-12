import greenfoot.*;

/**
 * Write a description of class ActionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActionWorld extends ScrollWorld
{

    /**
     * Constructor for objects of class ActionWorld.
     * 
     */
    
    private DialogWorld previous;
    private ActionBar actionBar;
    private Actor background;
    private Player player;
    public GreenfootSound curMusic;
    
    public ActionWorld(int fullWidth)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(600, 400, 1); 
        super(600, 400, 1, fullWidth, 400);
        this.player = player;
        //String[] temp = {"nice to meet you", "where you been?", "NOPE"};
        //this.addObject(new Text(temp, this), 500, 600);
        actionBar = new ActionBar(this);
        addObject(actionBar, 350, 451);
    }
    
    public void act()
    {
        //if(Greenfoot.getKey() == "space")
        //    Greenfoot.setWorld(previous);
        if (Player.getXCoord() > 590) {
            Player.setCombatMode(false);
            DialogWorld.setInActionWorld(false);
            if(curMusic != null && curMusic.isPlaying())
                curMusic.stop();
            Greenfoot.setWorld(Player.storyWorld);
            Player.setX(0);
        }
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
   
   protected void removeActionBar() {
       removeObject(actionBar);
   }
}
