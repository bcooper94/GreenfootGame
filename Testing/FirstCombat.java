import greenfoot.*;
import java.util.ArrayList;

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
        
        if (getPlayer().getHealth() <= 150) {
            ArrayList<String> text = new ArrayList<String>();
            removeActionBar();
            text.add("You decide to turn and run away");
            addObject(new textbg(), 300, 365);
            addObject(new Text(text), 300, 365);
            
            if (Greenfoot.getKey() == "space" || Greenfoot.mouseClicked(null)) {
                //Greenfoot.delay(500);
                Player.setHealth(Player.getMaxHealth());
                endBattle();
            }
        }
    }
}
