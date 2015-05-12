import greenfoot.*;

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends CombatEnemy
{
    
    public FinalBoss(CombatWorld world, int health) {
        super(world, health);
    }
    
    public int attackPlayer() {
        int damage = numberGen.nextInt(50) + 15;
        Player.damage(damage);
        
        return damage;
    }
    
    public String toString() {
        return "final boss";
    }
}
