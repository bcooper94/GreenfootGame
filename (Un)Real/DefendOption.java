import greenfoot.*;

/**
 * Write a description of class DefendOption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DefendOption extends CombatOption
{
    public DefendOption(String mouseOverImg, String noMouseOverImg) {
        super(mouseOverImg, noMouseOverImg);
    }
    
    /**
     * Act - do whatever the DefendOption wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }
    
    public void carryOut(Player player, CombatEnemy enemy) {
        BattleText text = new BattleText("You prepare to block the next strike!");
        Player.defend();
    }
}
