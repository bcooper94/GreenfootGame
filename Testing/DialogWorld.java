import greenfoot.*;
import java.awt.Color;
import java.util.*;
import java.io.*;

/**
 * Write a description of class DialogWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogWorld extends World
{

    /**
     * Constructor for objects of class DialogWorld.
     * 
     */
    
    ActionWorld action;
    Reake reake;
    Crait crait;
    private textbg textbg;
    public Yua yua;
    private room picture;
    Text dialog, dialog2, name;
    int curDialog;
    private ArrayList <String> chars;
    private Player player;
    private boolean inActionWorld;
    
    public DialogWorld() throws Exception
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        this.action = new ActionWorld(this, 1800);
        this.player = new Player("Playername");
        inActionWorld = false;
        String[] temp = {"hi", "you touched me!", "did you get this far? :3", "eien jaaaaa naiiiii", 
            "yukou~", "samurai ni umarete", "samurai no kokoro wo daiiiiite"};
        
        ArrayList <String> speak1 = new ArrayList <String> ();
        ArrayList <String> speak2 = new ArrayList <String> ();
        ArrayList <String> names = new ArrayList <String> ();
        chars = new ArrayList <String> ();  
        //Set up Chars
        reake = new Reake();
        crait = new Crait();
        yua = new Yua();
        picture = new room();
        textbg = new textbg();
        
        //Set up Dialog
        BufferedReader script = new BufferedReader(new FileReader("gamescript.txt"));
        BufferedReader script2 = new BufferedReader(new FileReader("gamescript2.txt"));
        BufferedReader charApp = new BufferedReader(new FileReader("chars.txt"));
        BufferedReader nameList = new BufferedReader(new FileReader("names.txt"));
        String line;
        
        while ((line = script.readLine()) != null) {
            speak1.add(line);
        }
        while ((line = script2.readLine()) != null) {
            speak2.add(line);
        }
        while ((line = charApp.readLine()) != null) {
            chars.add(line);
        }
        while ((line = nameList.readLine()) != null) {
            names.add(line);
        }

        dialog = new Text(speak1); 
        dialog2 = new Text(speak2);
        name = new Text(names);
        name.setBG(new Color(43,43,43));
        //dialog = new Text(temp);
        curDialog = 0;
        
        setBackground("blank.png");
        this.addObject(reake, reake.x, reake.y);
        this.addObject(crait, crait.x, crait.y);
        this.addObject(yua, yua.x, yua.y);
        this.addObject(textbg, 300,365);
        this.addObject(picture, 300,300);
        this.addObject(dialog, 300, 350);
        this.addObject(dialog2, 300,380);
        this.addObject(name, 70,315);
        
        picture.setImage("blank.png");
        
        takeOff(reake);
        takeOff(crait);
        takeOff(yua);
        
        //Greenfoot.playSound("Shinobi koi Utsutsu Opening.mp3");
   }
   
   public void act()
   {
      if(!inActionWorld && Greenfoot.getKey() == "space")
      {
         curDialog+=10;
         dialog.curDialog+=10;
         dialog2.curDialog+=10;
         name.curDialog+=10;
         dialog.speedAct();
         dialog2.speedAct();
         name.speedAct();
         setBG(curDialog);
         setCharacters(curDialog);
      }
      if(!inActionWorld && Greenfoot.mouseClicked(null))
      {
         curDialog++;
         setCharacters(curDialog);
         setBG(curDialog);
      }
   }
   
   private void setBG(int index)
   {
       if(index >= 1 && index < 13) {
            setBackground("bedroom.png"); 
       }
       if(index >= 13 && index < 80) {
            setBackground("street1.png");
       }
       if(index == 26) //First Battle
       {
           FirstCombat firstCombat = new FirstCombat(player, this);
           player.setCombatMode(true);
           Greenfoot.setWorld(firstCombat);
           firstCombat.setBackground("bedroom.png");
           inActionWorld = true;
           firstCombat.insertEnemy(new CombatNinja(firstCombat, 10000));
       }
       if(index >= 80 && index < 114) {
            setBackground("street3.png");
            ExploreStreets exploreStreets = new ExploreStreets(this, 1800);
            exploreStreets.addObject(player, 300, 250);
            exploreStreets.addCameraFollower(player, 300, 250);
            Greenfoot.setWorld(exploreStreets);
       }
       if(index >= 114) {
            setBackground("base.png");
       }
       if(index == 163) {
            picture.setImage("bedpic.png");
       }
       if(index == 171) {
           picture.setImage("blank.png");
       }
   }
   
   private void takeOff(Actor actor)
   {
       actor.setImage("blank.png");
   }
   
   private void setCharacters(int index)
   {
       if(index < chars.size())
       {
           String temp = chars.get(index);
           takeOff(yua);
           takeOff(reake);
           takeOff(crait);
           if(temp.equals("r"))
           {
               reake.norm();
           }
           else if(temp.equals("c"))
           {
               crait.norm();
           }
           else if(temp.equals("y"))
           {
               yua.norm();
           }
           else if(temp.equals("rc"))
           {
               reake.norm();
               crait.norm();
           }
           else if(temp.equals("ry"))
           {
               reake.norm();
               yua.norm();
               if(!yua.onLeft)
               {
                   yua.flip();
               }
           }
           else if(temp.equals("cy"))
           {
               crait.norm();
               yua.norm();
               if(yua.onLeft)
               {
                   yua.flip();
               }
           }
           crait.setExpression(index);
           reake.setExpression(index);
           yua.setExpression(index);
       }
    }
}
