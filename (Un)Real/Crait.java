import greenfoot.*;

/**
 * Write a description of class Crait here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crait extends Actor
{
    /**
     * Act - do whatever the Crait wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage[] imgs = {new GreenfootImage("crait5.png"), new GreenfootImage("crait5creepy.png"), 
        new GreenfootImage("crait5frown.png"), new GreenfootImage("crait5happy.png"), new GreenfootImage("crait5talk.png")};
    private int curImage = 0;
    public int x, y;
    private int [] talkList = {30, 42, 47, 54, 71, 77, 96, 109, 117, 132, 142, 159, 162, 186, 197, 220},
        surpriseList = {55, 90, 122},
        frownList = {33, 50,  60, 70, 79, 98, 112, 118, 123, 135, 147, 167, 187, 199, 217}, 
        normalList = {36, 41, 43, 48, 65, 75, 95, 97, 110, 116, 143, 154, 160, 163, 166, 216, 221}, 
        happyList = {35, 40, 62, 94, 115, 153, 165, 169, 211, 217, 224};
    private int [][] expressionList = {normalList, surpriseList, frownList, happyList, talkList}; 
    private boolean stop = false;
    
    public Crait()
    {
        x = 180;
        y = 270;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    public void norm()
    {
        setImage(imgs[curImage]);
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
