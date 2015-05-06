import greenfoot.*;
import java.util.Random;
import java.util.LinkedList;

/**
 * Write a description of class CombatWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatWorld extends ActionWorld
{
    private CombatEnemy enemy;
    private ActionWorld returnWorld;
    private OptionsPane options;
    
    /**
     * Constructor for objects of class CombatWorld.
     * 
     */
    public CombatWorld(Player player, Actor background, ActionWorld returnWorld) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(background);
        this.enemy = enemy;
        this.returnWorld = returnWorld;
        addPlayer(player);
        options = new OptionsPane(this);
    }
    
    public void insertEnemy(CombatEnemy enemy) {
        Random random = new Random();
        this.enemy = enemy;
        addObject(enemy, 225 + random.nextInt(50), 150 + random.nextInt(40));
    }
    
    public void endBattle() {
        Greenfoot.setWorld(returnWorld);
    }
}
