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
    private boolean playerTurn;
    private Player player;
    private HealthBar healthBar;
    
    private static int selectedOption;
    
    static {
        // Draw clickable options
        selectedOption = 0;
        options = new ArrayList<CombatOption>();
        options.add(new AttackOption("attack_mouseOver.png", "attack_noMouseOver.png"));
        options.add(new DefendOption("defend_mouseOver.png", "defend_noMouseOver.png"));
        options.add(new FleeOption("flee_mouseOver.png", "flee_noMouseOver.png"));
        options.get(selectedOption).setSelected(true);
    }
    
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
        super(returnWorld, 600);
        this.player = player;
        this.returnWorld = (World)returnWorld;
        selectedOption = 0;
        healthBar = new HealthBar(Player.getHealth(), Player.getMaxHealth());
        addObject(healthBar, 100, 360);
        
        for (int i = 0; i < options.size(); i++) {
            addObject(options.get(i), 500, 350 + i * 20);
        }
    }
    
    public void act() {
        int enemyDamage;
        String key = Greenfoot.getKey();
        if (key != null) {
            if (selectedOption > 0 && (key.equals("w") || key.equals("up"))) {
                options.get(selectedOption--).setSelected(false);
                options.get(selectedOption).setSelected(true);
            }
            else if (selectedOption + 1 < options.size() && (key.equals("s") || key.equals("down"))) {
                options.get(selectedOption++).setSelected(false);
                options.get(selectedOption).setSelected(true);
            }
            
            if (playerTurn && key.equals("enter")) {
                options.get(selectedOption).carryOut(player, enemy);
                setPlayerTurn(false);
            }
        }
        
        if (enemy != null && !playerTurn) {
            enemyDamage = enemy.attackPlayer();
            addObject(new BattleText(enemy + " hits you for " + enemyDamage + " damage!"), 300, 50);
            setPlayerTurn(true);
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
    
    public void setPlayerTurn(boolean value) {
        playerTurn = value;
        //enemy.setEnemyTurn(!value);
        try {
            Thread.sleep(250);
        }
        catch (InterruptedException e) {
            
        }
    }
}
