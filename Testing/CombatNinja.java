import greenfoot.*;

/**
 * Write a description of class CombatNinja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatNinja extends CombatEnemy
{
    private CombatWorld world;
    
    public CombatNinja(CombatWorld world, int health) {
        super(world, health);
        this.world = world;
    }
    
    public int attackPlayer() {
        int damage = numberGen.nextInt(10) + 15;
        Player.damage(damage);
        
        return damage;
    }
    
    public String toString() {
        return "ninja";
    }
}
