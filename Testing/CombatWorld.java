import greenfoot.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class CombatWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatWorld extends ActionWorld
{
    private CombatEnemy enemy;
    private World returnWorld;
    private static ArrayList<CombatOption> options;
    private Player player;
    
    /**
     * Constructor for objects of class CombatWorld.
     * 
     */
    /*
    public CombatWorld(Player player, ActionWorld returnWorld, DialogWorld mainDialog) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(mainDialog);
        this.returnWorld = (World)returnWorld;
        addPlayer(player, 300, 250, false);
        
        
    }*/
    
    /** Only used for first combat scene. */
    public CombatWorld(Player player, DialogWorld returnWorld) {
        super(returnWorld);
        this.player = player;
        this.returnWorld = (World)returnWorld;
        
        // Draw clickable options
        options = new ArrayList<CombatOption>();
        options.add(new CombatOption("attack_mouseOver.png", "attack_noMouseOver.png"));
        options.add(new CombatOption("defend_mouseOver.png", "defend_noMouseOver.png"));
        options.add(new CombatOption("flee_mouseOver.png", "flee_noMouseOver.png"));
        
        for (int i = 0; i < options.size(); i++) {
            addObject(options.get(i), 500, 350 + i * 20);
        }
    }
    
    public void insertEnemy(CombatEnemy enemy) {
        Random random = new Random();
        this.enemy = enemy;
        addObject(enemy, 225 + random.nextInt(50), 150 + random.nextInt(40));
    }
    
    public void endBattle() {
        Greenfoot.setWorld(returnWorld);
    }
    
    public void returnToStory() {
        player.setCombatMode(false);
        Greenfoot.setWorld(returnWorld);
    }
}
