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
    private static HealthBar healthBar = new HealthBar(maxHealth, health);
    
    public Player(String name) {
        super(4);
        inCombat = false;
        health = 1000;
        maxHealth = 1000;
        level = 1;
        experience = 0;
    }
    
    public void changeWorld(ActionWorld world, int xCoord, int yCoord) {
        healthBar.redraw(world);
        world.addObject(this, xCoord, yCoord);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
        super.act();
        keyListener();
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
        health -= damage;
        healthBar.changeHealth(-damage);
       // End if player dies
        if (health <= 0) {
            Greenfoot.stop();
        }
    }
    
    public void keyListener() {
        if (!inCombat) {
            if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A")) {
                moveLeft();
            }
            else if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D")) {
                moveRight();
            }
            if (Greenfoot.isKeyDown("Space")) {
                jump();
            }
            // Implement collision with ladder
        }
        else {
            
        }
    }
}
