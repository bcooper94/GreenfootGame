import greenfoot.*;

/**
 * Write a description of class EnemyActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyActor extends MovingActor
{
    private static final int HEIGHT = 85;
    private static final int COLLIDE = 70;
    private GreenfootImage image;
    private static int timeDelay = 25;
    private int time;
    
    public EnemyActor(GreenfootImage image, int speed) {
        super(speed);
        setImage(image);
        time = 0;
    }
    
    /**
     * Act - do whatever the EnemyActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        //Player player = getWorl().getPlayer();
        //time++;
        //if (time == timeDelay) {
            // Move toward player
        //if 
            if (getX() < Player.getXCoord() - COLLIDE) {
                moveRight();
            }
            else if (getX() > Player.getXCoord() + COLLIDE) {
                moveLeft();
            }
            if (getY() < Player.getYCoord() - HEIGHT && inPlayerRange())
            {
                jump();
            }
        //}
    }
    
    public void checkForPlayer() {
        CombatWorld fight;
        Player player = (Player)getOneIntersectingObject(Player.class);
        
        if (player != null) {
            //fight = new CombatWorld(player, getActionWorld());
            if (this instanceof MovingNinja) {
                //fight.insertEnemy(new CombatNinja(fight));
            }
            else {
                //fight.insertEnemy(new CombatSamurai(fight));
            }
            player.setCombatMode(true);
            //Greenfoot.setWorld(fight);
        }
   }
    
    public boolean inPlayerRange() {
        //return Math.abs(getX() - getActionWorld().getPlayer().getX()) < COLLIDE;
        return Math.abs(getX() - Player.getXCoord()) < COLLIDE;
    }
}
