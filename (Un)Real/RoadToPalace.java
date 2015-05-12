import greenfoot.*;

/**
 * Write a description of class RoadToPalace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoadToPalace extends ActionWorld
{
    private DialogWorld returnHere;
    
    /**
     * Constructor for objects of class ExploreStreets.
     * 
     */
    public RoadToPalace(int fullWidth) {
        super(fullWidth);
        this.returnHere = returnHere;
        this.curMusic = new GreenfootSound("240376_edtijo_happy-8bit-pixel-adenture_converted.wav");
        curMusic.playLoop();
        addObject(new GroundPlatform(), fullWidth / 2, 350);
        
        //addObject(new MovingSamurai(this), 1200, 300);
        addObject(new MovingNinja(this), 1800, 300);
    }
    
    public void act() {
        if (Player.getXCoord() > 590) {
            DialogWorld.roadToPalaceDone = true;
        }
        super.act();
    }
}
