import greenfoot.*;

/**
 * Write a description of class FirstEncounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstEncounter extends CombatSamurai
{
    private CombatWorld world;
    
    public FirstEncounter(CombatWorld world, int health) {
        super(world, health);
        this.world = world;
    }
    
    public int attackPlayer() {
        int damage = numberGen.nextInt(50) + 100;
        Player.damage(damage);
        
        return damage;
    }
    
    public String toString() {
        return "samurai";
    }
}
