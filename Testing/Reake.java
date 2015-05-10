import greenfoot.*;

/**
 * Write a description of class Reake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reake extends Actor
{
    /**
     * Act - do whatever the Reake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage[] imgs = {new GreenfootImage("reake3frown.png"), new GreenfootImage("reake3annoy.png"), 
        new GreenfootImage("reake4.png"), new GreenfootImage("reake3mad.png")};
    private int curImage = 0;
    private int [] talkList = {46, 58, 60, 69, 81, 83, 86, 120, 124, 135, 139, 160, 184, 202, 206, 219, 223},
        frownList = {40, 42, 45, 47, 50, 54, 59, 62, 70, 77, 82, 85, 87, 93, 96, 109, 121, 125, 136, 140, 161, 185, 205, 220}, 
        madList = {39, 41, 76, 91, 95, 141, 167, 195}, 
        annoyList = {44, 48, 52, 99, 111, 156};
    private int [][] expressionList = {frownList, annoyList, talkList, madList}; 
    private boolean stop = false;
    
    public int x, y;
    
    public Reake()
    {
        x = 470;
        y = 230;
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
