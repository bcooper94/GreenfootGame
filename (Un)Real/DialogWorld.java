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
    private static boolean inActionWorld;
    public GreenfootSound curMusic;

    public static boolean secondBattleDone;
    public static boolean thirdBattleDone;
    public static boolean exploreStreetsDone;
    public static boolean roadToPalaceDone;
    public static boolean finalBossDone;

    public DialogWorld() throws Exception
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        this.action = new ActionWorld(1800);
        this.player = new Player("Playername", this);
        inActionWorld = false;
        secondBattleDone = false;
        thirdBattleDone = false;
        exploreStreetsDone = false;
        roadToPalaceDone = false;
        finalBossDone = false;

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

        prepare();
    }

    public void act()
    {
        if(!inActionWorld && Greenfoot.mouseClicked(null))
        {
            curDialog++;
            setCharacters(dialog.curDialog + 1);
            setBG(dialog.curDialog + 1);
            setMusic(dialog.curDialog + 1);
        }
        if (dialog.curDialog == 183 && !exploreStreetsDone) {
            //advance();
            advance();
            inActionWorld = true;
            ExploreStreets exploreStreets = new ExploreStreets(1800);
            exploreStreets.addObject(player, 300, 250);
            exploreStreets.addCameraFollower(player, 300, 250);
            Greenfoot.setWorld(exploreStreets);
        }
        if (dialog.curDialog == 192 && !roadToPalaceDone) {
            advance();
            inActionWorld = true;
            RoadToPalace palaceRoad = new RoadToPalace(1200);
            palaceRoad.addObject(player, 300, 250);
            palaceRoad.addCameraFollower(player, 300, 250);
            Greenfoot.setWorld(palaceRoad);
        }
        if (dialog.curDialog == 212 && !finalBossDone) {
            // Boss battle
            finalBossDone = true;
            inActionWorld = true;
            CombatWorld bossBattle = new CombatWorld(player, null);
            bossBattle.insertEnemy(new FinalBoss(bossBattle, 1000));
            player.setCombatMode(true);
            Greenfoot.setWorld(bossBattle);
        }
    }

    public void advance()
    {
        curDialog++;
        dialog.curDialog++;
        dialog2.curDialog++;
        name.curDialog++;
        dialog.speedAct();
        dialog2.speedAct();
        name.speedAct();
        setBG(dialog.curDialog + 1);
        setCharacters(dialog.curDialog + 1);
    }

    private void setMusic(int index)
    {
        if(index == 12 || index == 26 || index == 38 || index == 80 || index == 108 || index == 114
        || index == 183 || index == 192 || index == 213)
        {
            if(curMusic != null && curMusic.isPlaying())
            {
                curMusic.stop();
            }
            curMusic = null;
        }
        else if(index == 1 || index == 214)
        {
            curMusic = new GreenfootSound("262522__orangefreesounds__gentle-piano-music-loop.wav");
        }
        else if(index == 13 || index == 27 || index == 81)
        {
            curMusic = new GreenfootSound("112072_cheesepuff_suspence-background.wav");
            curMusic.setVolume(100);
        }
        else if(index == 39 || index == 109)
        {
            curMusic = new GreenfootSound("211492__lemoncreme__guitar-music.wav");
            curMusic.setVolume(60);
        }
        else if(index == 115)
        {
            curMusic = new GreenfootSound("211492__lemoncreme__guitar-music.wav");
            curMusic.setVolume(60);
        }
        else if(index == 185)
        {
            curMusic = new GreenfootSound("109239_cheesepuff_song-6.wav");
        }
        else if(index == 194)
        {
            curMusic = new GreenfootSound("250856_joshuaempyre_epic-orchestra-loop_converted.wav");
        }
        if(curMusic != null && !curMusic.isPlaying())
        {
            curMusic.playLoop();
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
            advance();
            advance();
            FirstCombat firstCombat = new FirstCombat(player, null);
            player.setCombatMode(true);
            Greenfoot.setWorld(firstCombat);
            firstCombat.setBackground("bedroom.png");
            inActionWorld = true;
            firstCombat.insertEnemy(new FirstEncounter(firstCombat, 10000));
        }
        if(index >= 80 && index < 114) {
            setBackground("street3.png");
        }
        if (dialog.curDialog == 108 && !Player.storyWorld.thirdBattleDone) {
            Player.storyWorld.startBattle(true);
        }
        if(index >= 114 && index < 175) {
            setBackground("base.png");
        }
        if(index == 163) {
            picture.setImage("bedpic.png");
        }
        if(index == 171 || index == 212) {
            picture.setImage("blank.png");
        }
        if(index == 183)
            setBackground("Moon_Palace_By_Night.jpg");
        if(index == 207)
            picture.setImage("homework-help-2.jpg");
        if(index == 224)
        {
            takeOff(reake);
            setBackground("bedroom.png");
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

    public static void setInActionWorld(boolean value) {
        inActionWorld = value;
    }

    public static boolean inActionWorld() {
        return inActionWorld;
    }

    public void startBattle(boolean ninja) {
        /**
        if (secondBattleDone) {
        thirdBattleDone = true;
        }
         **/
        advance();
        if(curMusic != null && curMusic.isPlaying())
            curMusic.stop();
        curMusic = new GreenfootSound("240376_edtijo_happy-8bit-pixel-adenture_converted.wav");
        thirdBattleDone = true;
        SecondCombat secondFight = new SecondCombat(player, null);
        CombatEnemy enemy = ninja ? new CombatNinja(secondFight, 400) : new CombatSamurai(secondFight, 500);
        secondFight.insertEnemy(enemy);
        inActionWorld = true;
        player.setCombatMode(true);
        Greenfoot.setWorld(secondFight);  
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
    }
}
