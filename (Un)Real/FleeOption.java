import greenfoot.*;
import java.util.Random;

/**
 * Write a description of class FleeOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FleeOption extends CombatOption
{
    public FleeOption(String mouseOverImg, String noMouseOverImg) {
        super(mouseOverImg, noMouseOverImg);
    }
    
    /**
     * Act - do whatever the FleeOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }
    
    public void carryOut(Player player, CombatEnemy enemy) {
        CombatWorld world = (CombatWorld)getWorld();
        Random rng = new Random();
        
        if (rng.nextInt(100) <= 32) {
            world.endBattle();
        }
        else {
            world.setPlayerTurn(false);
            getWorld().addObject(new BattleText(
                "You try to run, but the " + enemy + " easily catches up to you!"), 300, 380);
        }
    }
}
