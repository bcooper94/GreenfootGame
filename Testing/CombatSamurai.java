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
    
    public CombatSamurai(CombatWorld world) {
        super(world);
        this.world = world;
    }
    
    public void attackPlayer() {
        Player player = world.getPlayer();
        int damage = numberGen.nextInt(50) + 50;
        player.damage(damage);
    }
}
