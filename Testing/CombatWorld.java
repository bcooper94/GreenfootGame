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
    private ActionWorld returnWorld;
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
    public CombatWorld(Player player, ActionWorld returnWorld) {
        super(600);
        this.player = player;
        this.returnWorld = returnWorld;
        selectedOption = 0;
        healthBar = new HealthBar(Player.getHealth(), Player.getMaxHealth());
        addObject(healthBar, 100, 360);
        
        for (int i = 0; i < options.size(); i++) {
            addObject(options.get(i), 500, 350 + i * 20);
        }
        resetCombatOptions();
    }
    
    public void act() {
        int enemyDamage;
        String key = Greenfoot.getKey();
        updateSelectedOption();
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
        
        combatOptionsListener();
    }
    
    public void combatOptionsListener() {
        if (Greenfoot.mouseMoved(options.get(0))) {
            resetCombatOptions();
            options.get(0).setSelected(true);
        }
        else if (Greenfoot.mouseMoved(options.get(1))) {
            resetCombatOptions();
            options.get(1).setSelected(true);
        }
        else if (Greenfoot.mouseMoved(options.get(2))) {
            resetCombatOptions();
            options.get(2).setSelected(true);
        }
        
        if (Greenfoot.mouseClicked(options.get(0))) {
            options.get(0).carryOut(player, enemy);
            setPlayerTurn(false);
        }
        else if (Greenfoot.mouseClicked(options.get(1))) {
            options.get(1).carryOut(player, enemy);
            setPlayerTurn(false);
        }
        else if (Greenfoot.mouseClicked(options.get(2))) {
            options.get(2).carryOut(player, enemy);
            setPlayerTurn(false);
        }
    }
    
    public void insertEnemy(CombatEnemy enemy) {
        Random random = new Random();
        this.enemy = enemy;
        if (!enemy.toString().equals("final boss")) {
            addObject(enemy, 225 + random.nextInt(50), 300);
        }
        else {
            addObject(enemy, 300, 205);
        }
    }
    
    public void endBattle() {
        if (returnWorld != null) {
            Greenfoot.setWorld(returnWorld);
        }
        else {
            Greenfoot.setWorld(Player.storyWorld);
        }
        player.setCombatMode(false);
        DialogWorld.setInActionWorld(false);
    }
    
    public void returnToStory() {
        player.setCombatMode(false);
        Player.storyWorld.advance();
        Greenfoot.setWorld(Player.storyWorld);
        DialogWorld.setInActionWorld(false);
    }
    
    public static void resetCombatOptions() {
        options.get(0).setSelected(false);
        options.get(1).setSelected(false);
        options.get(2).setSelected(false);
    }
    
    public static void updateSelectedOption() {
        for (CombatOption opt : options) {
            if (!opt.getSelected()) {
                opt.setSelected(false);
            }
        }
    }
    
    public void setPlayerTurn(boolean value) {
        playerTurn = value;
        //enemy.setEnemyTurn(!value);
        /*
        try {
            Thread.sleep(250);
        }
        catch (InterruptedException e) {
            
        }
        */
    }
}
