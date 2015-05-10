import greenfoot.*;
import java.util.List;

/**
 * Write a description of class MovingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingActor extends ScrollActor
{
    private int vSpeed;
    private static int acceleration = 1;
    private int jump;
    private int speed;
    
    public MovingActor(int speed) {
        this.speed = speed;
        jump = 16;
    }
    
    
    
    /**
     * Act - do whatever the MovingActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkFall();
    }
    
    public boolean onGround() {
        List<Object> objects = getObjectsAtOffset(0, getImage().getHeight() / 2 - 30, Ground.class);
        //Object ground = getOneObjectAtOffset(0, getImage().getHeight()/2 - 30, null);
        if (getY() >= getWorld().getHeight()) {
            return true;
        }
        
        for (Object obj : objects) {
            if (obj instanceof Ground) {
                return true;
            }
        }
        
        return false;
    }
    
    public void checkFall() {
        if (onGround()) {
            vSpeed = 0;
        }
        else {
            fall();
        }
    }
    
    public void fall()
    {
        setLocation ( getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    public void moveLeft() {
        if (getX() - speed > 0) {
            setLocation(getX() - speed, getY());
        }
    }
    
    public void moveRight() {
        if (getX() + speed < getWorld().getWidth()) {
            setLocation(getX() + speed, getY());
        }
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setVSpeed(int speed) {
        vSpeed = speed;
    }
    
    public int getVSpeed() {
        return vSpeed;
    }
    
    /*
    public ActionWorld getActionWorld() {
        return (ActionWorld)getWorld();
    }
    */
    
    public void jump() {
        if (onGround()) {
            vSpeed = -jump;
            fall();
        }
    }
    
    public void setJump(int power) {
        jump = power;
    }
}
