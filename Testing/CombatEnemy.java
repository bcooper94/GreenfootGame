import greenfoot.*;
import java.util.Random;

/**
 * Write a description of class CombatEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CombatEnemy extends Actor
{
    private CombatWorld world;
    private static boolean enemyTurn;
    protected Random numberGen;
    private int health;
    
    public CombatEnemy(CombatWorld world) {
        this.world = world;
        numberGen = new Random();
        
        if (numberGen.nextInt() % 2 == 0) {
            enemyTurn = true;
        }
    }
    /**
     * Act - do whatever the CombatEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (enemyTurn) {
            attackPlayer();
            enemyTurn = false;
        }
    }
    
    public void enemyTurn() {
        enemyTurn = true;
    }
    
    public abstract void attackPlayer();
    
    public void setHealth(int value) {
        this.health = value;
    }
    
    public void damage(int value) 
    {
        health -= value;
        if (health <= 0) {
            world.endBattle();
        }
    }
}
