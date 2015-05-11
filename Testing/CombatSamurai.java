import greenfoot.*;

/**
 * Write a description of class CombatSamurai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatSamurai extends CombatEnemy
{
    private CombatWorld world;
    
    public CombatSamurai(CombatWorld world, int health) {
        super(world, health);
        this.world = world;
    }
    
    public int attackPlayer() {
        int damage = numberGen.nextInt(20) + 10;
        Player.damage(damage);
        
        return damage;
    }
    
    public String toString() {
        return "samurai";
    }
}
