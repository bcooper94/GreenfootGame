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
    private static final int COLLIDE = 65;
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
        checkForPlayer();
    }
    
    public void checkForPlayer() {
        CombatWorld fight;
        double levelScale = Player.getLevel() / 10;
        Player player = (Player)getOneIntersectingObject(Player.class);
        
        if (player != null) {
            fight = new CombatWorld(player, (ActionWorld)getWorld());
            if (this instanceof MovingNinja) {
                fight.insertEnemy(new CombatNinja(fight,(int) levelScale * 30 + 400));
            }
            else {
                fight.insertEnemy(new CombatSamurai(fight,(int) levelScale * 50 + 600));
            }
            player.setCombatMode(true);
            getWorld().removeObject(this);
            Greenfoot.setWorld(fight);
        }
   }
    
    public boolean inPlayerRange() {
        //return Math.abs(getX() - getActionWorld().getPlayer().getX()) < COLLIDE;
        return Math.abs(getX() - Player.getXCoord()) < COLLIDE;
    }
}
