import greenfoot.*;

/**
 * Write a description of class Yua here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Yua extends Actor
{
    /**
     * Act - do whatever the Yua wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage[] imgs = {new GreenfootImage("Yua2.png"), new GreenfootImage("Yua2Creepy.png"), 
        new GreenfootImage("Yua2Frown.png"), new GreenfootImage("Yua2Happy.png"), new GreenfootImage("Yua2Talk.png")};
    private int curImage = 0;
    private int [] talkList = {116, 129, 144, 157, 191},
        surpriseList = {117},
        frownList = {120, 138, 147, 184, 196}, 
        normalList = {131, 145, 215}, 
        happyList = {171, 214, 222};
    private int [][] expressionList = {normalList, surpriseList, frownList, happyList, talkList}; 
    private boolean stop = false;
    
    public int x, y, x2, y2;
    public boolean onLeft = true;
    
    public Yua()
    {
        x = 120;
        y = 255;
        x2 = 470;
        y2 = 255;
    }
    public void act() 
    {
        // Add your action code here.
    }    
    public void norm()
    {
        this.setImage(imgs[curImage]);
    }
    public void flip()
    {
        if(onLeft)
            setLocation(x2, y2);
        else
            setLocation(x, y);
        onLeft = !onLeft;
    }
    public void setExpression(int index)
    {
        int temp = curImage;
        for(int i = 0; i < expressionList.length && !stop; i++)
        {
            for(int j = 0; j < expressionList[i].length && !stop; j++)
            {
                if(index == expressionList[i][j])
                {
                    curImage = i;
                    stop = true;
                }
            }
        }
        stop = false;
        if(curImage != temp)
            norm();
    }
}
