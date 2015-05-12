import greenfoot.*;

/**
 * Write a description of class ExploreStreets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExploreStreets extends ActionWorld
{
    private DialogWorld returnHere;
    
    /**
     * Constructor for objects of class ExploreStreets.
     * 
     */
    public ExploreStreets(int fullWidth) {
        super(fullWidth);
        this.returnHere = returnHere;
        this.curMusic = new GreenfootSound("240376_edtijo_happy-8bit-pixel-adenture_converted.wav");
        curMusic.playLoop();
        addObject(new GroundPlatform(), fullWidth / 2, 350);
        
        addObject(new MovingSamurai(this), 1200, 300);
        addObject(new MovingNinja(this), 1800, 300);
    }
    
    public void act() {
        if (Player.getXCoord() > 590) {
            DialogWorld.exploreStreetsDone = true;
        }
        super.act();
    }
}
