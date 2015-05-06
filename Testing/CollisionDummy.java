import greenfoot.*;

/**
 * Write a description of class DummyEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CollisionDummy extends MovingActor
{
    private EnemyActor owner;
    
    public CollisionDummy(ActionWorld world, int speed, EnemyActor owner) {
        super(world, speed);
        this.owner = owner;
        setImage(new GreenfootImage("collision.png"));
    }
    /**
     * Act - do whatever the DummyEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForPlayer();
    }
    
    public void checkForPlayer() {
        CombatWorld fight;
        Player player = (Player)getOneIntersectingObject(Player.class);
        
        if (player != null) {
            fight = new CombatWorld(player, new GenericLevel(), getActionWorld());
            if (owner instanceof MovingNinja) {
                fight.insertEnemy(new CombatNinja(fight));
            }
            else {
                fight.insertEnemy(new CombatSamurai(fight));
            }
            player.setCombatMode(true);
            Greenfoot.setWorld(fight);
        }
   }
   
   public EnemyActor getOwner() {
       return owner;
   }
}
