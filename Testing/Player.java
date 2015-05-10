import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends MovingActor
{
    private static int health = 1000;
    private static int maxHealth = 1000;
    private static int level = 1;
    private static int experience = 0;
    private static boolean inCombat;
    private static boolean defending;
    private static HealthBar healthBar = new HealthBar(maxHealth, health);
    private static int xCoord;
    private static int yCoord;
    
    private boolean curWalking = false;
    private boolean faceRight = true;
    private int curImage = 1;
    private int animationTimer;
    private GreenfootImage [] imgs = {new GreenfootImage("walk1.png"), new GreenfootImage("walk2.png"), new GreenfootImage("walk3.png"), new GreenfootImage("walk2.png")};
    
    public Player(String name) {
        super(4);
        inCombat = false;
        health = 1000;
        maxHealth = 1000;
        level = 1;
        experience = 0;
        animationTimer = 0;
    }
    
    public void changeWorld(ActionWorld world, int xCoord, int yCoord) {
        healthBar.redraw(world);
        world.addObject(this, xCoord, yCoord);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        ActionWorld curWorld = (ActionWorld)getWorld();
        super.act();
        keyListener();
        walking();
       
        /*
        if (curWorld != null) {
            healthBar.redraw(curWorld);
        }
        */
    }
    
    public static int getXCoord() {
        return xCoord;
    }
    
    public static int getYCoord() {
        return yCoord;
    }
    
    public static int getHealth() {
        return health;
    }
    
    public static int getMaxHealth() {
        return maxHealth;
    }
    
    public static int getLevel() {
        return level;
    }
    
    public static int getXp() {
        return experience;
    }
    
    public void addXp(int xp) {
        // Gain a level every 1000 xp
        experience += xp;
        if ((experience % 1000) == 0) {
            level++;
            health += 100;
            maxHealth += 100;
        }
    }
    
    public void setCombatMode(boolean combat) {
        inCombat = combat;
    }
    
    public static void damage(int damage) {
        health -= defending ? damage / 3 : damage;
        healthBar.changeHealth(defending ? damage / 3 : -damage);
        defending = false;
       // End if player dies
        if (health <= 0) {
            Greenfoot.stop();
        }
    }
    
    public static void defend() {
        defending = true;
    }
    
    public void moveLeft() {
        ActionWorld world = (ActionWorld)getWorld();
        
        if (world != null) {
            //world.setCameraLocation(getX(), getY());
            world.setCameraDirection(180);
            if (getX() < world.getWidth() / 2) {
                world.moveCamera(getSpeed());
            }
        }
        super.moveLeft();
        
    }
    
    public void moveRight() {
        ActionWorld world = (ActionWorld)getWorld();
        
        if (world != null) {
            //world.setCameraLocation(getX(), getY());
            world.setCameraDirection(0);
            
            if (getX() > world.getWidth() / 2) {
                world.moveCamera(getSpeed());
            }
        }
        super.moveRight();
    }
    
    public void keyListener() {
        if (!inCombat) {
            if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A")) {
                moveLeft();
                curWalking = true;
                if(faceRight)
                {
                    faceRight = false;
                    flip();
                }
                //animationTimer = 60;
            }
            else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D")) {
                moveRight();
                curWalking = true;
                if(!faceRight)
                {
                    faceRight = true;
                    flip();
                }
                //animationTimer = 60;
            }
            else
            {
                curWalking = false;
                animationTimer = 0;
                curImage = 1;
                setImage(imgs[curImage]);
            }
            if (Greenfoot.isKeyDown("Space")) {
                jump();
            }
            
            // Implement collision with ladder
        }
        xCoord = getX();
        yCoord = getY();
    }
    
    private void walking()
    {
        if(curWalking)
        {
            animationTimer++;
            if(animationTimer == 13)
            {
                if(curImage < imgs.length - 1)
                    curImage++;
                else
                    curImage = 0;
                setImage(imgs[curImage]);
                animationTimer = 0;
            }
        }
    }
    
    private void flip()
    {
        for(int i = 0; i < imgs.length; i++)
        {
            imgs[i].mirrorHorizontally();
        }
    }
}
