import greenfoot.*;
import java.util.Random;

/**
 * Write a description of class AttackOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackOption extends CombatOption
{
    public AttackOption(String mouseOverImg, String noMouseOverImg) {
        super(mouseOverImg, noMouseOverImg);
    }
    
    /**
     * Act - do whatever the AttackOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }
    
    public void carryOut(Player player, CombatEnemy enemy) {
        Random damageCalc = new Random();
        int damage = damageCalc.nextInt(50) + 100;
        BattleText text = new BattleText("You hit the " + enemy + " for " + damage + " damage!");
        getWorld().addObject(text, 300, 380);
        enemy.damage(damage);
    }
}
