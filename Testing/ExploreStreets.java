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
    public ExploreStreets(DialogWorld returnHere, int fullWidth) {
        super(returnHere, fullWidth);
        this.returnHere = returnHere;
        addObject(new GroundPlatform(), fullWidth / 2, 350);
    }
}