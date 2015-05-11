import greenfoot.*;

/**
 * Write a description of class FirstCombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstCombat extends CombatWorld
{
    /**
     * Constructor for objects of class FirstCombat.
     * 
     */
    public FirstCombat(Player player, ActionWorld returnWorld)
    {
        super(player, returnWorld);
    }
    
    public void act() {
        super.act();
        
        if (getPlayer().getHealth() <= 0) {
            removeActionBar();
            Greenfoot.setSpeed(50);
            Greenfoot.delay(500);
            endBattle();
        }
    }
}
