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
    private CollisionDummy collisionDummy;
    
    public EnemyActor(ActionWorld world, GreenfootImage image, int speed) {
        super(world, speed);
        this.image = image;
        setImage(image);
        time = 0;
        collisionDummy = new CollisionDummy(world, speed, this);
    }
    
    /**
     * Act - do whatever the EnemyActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        Player player = getActionWorld().getPlayer();
        //time++;
        //if (time == timeDelay) {
            // Move toward player
        //if 
            if (getX() < player.getX() - COLLIDE) {
                moveRight();
                collisionDummy.moveRight();
            }
            else if (getX() > player.getX() + COLLIDE) {
                moveLeft();
                collisionDummy.moveLeft();
            }
            if (getY() < player.getY() - HEIGHT && inPlayerRange())
            {
                jump();
            }
        //}
    }
    
    public boolean inPlayerRange() {
        return Math.abs(getX() - getActionWorld().getPlayer().getX()) < COLLIDE;
    }
    
    public void addCollision() {
        getActionWorld().addObject(collisionDummy, getX(), getY());
    }
}
