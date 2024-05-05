package main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.subWindow;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font purisaBold, maruMonica;
    BufferedImage heart_full, heart_half, heart_blank, crystal_full, crystal_blank;
    BufferedImage windowMiddle,windowTop, windowLeft, windowRight, windowBottom, windowEdgeTLeft,windowEdgeTRight, windowEdgeBLeft, windowEdgeBRight;
    public BufferedImage cover;
    public BufferedImage settingsUI;
    public BufferedImage select1,select2,select3,select4;
    public BufferedImage yellowbox, whitebox,redbox,greenbox,bluebox;
    public boolean messageOn = false;
    // public String message = "";
    // int messageCounter = 0;
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();
    public boolean gameFinished = false;
    DecimalFormat df = new DecimalFormat("#0.00");
    double playTime;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0; //0 = the first screen, 1 for second screeen
    public int slotCol = 0;
    public int slotRow = 0;
    int subState = 0;
    
    
    public UI(GamePanel gp){
        this.gp = gp;
        try{
            //  InputStream is = getClass().getResourceAsStream("/pics/font/PurisaBold.ttf");
            //  InputStream is = getClass().getResourceAsStream("/pics/font/maruMonica.ttf");
             InputStream is = getClass().getResourceAsStream("/pics/font/final.ttf");
             maruMonica = Font.createFont(Font.TRUETYPE_FONT,is);
            //  purisaBold = Font.createFont(Font.TRUETYPE_FONT,is);
             
        }catch(FontFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
       
        //create hud object
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        //crystal
        Entity crystal = new OBJ_ManaCrystal(gp);
        crystal_full = crystal.image;
        crystal_blank = crystal.image2;
        //subwindow
        windowEdgeTLeft =   setup("/pics/subwindow/topleft", gp.tileSize, gp.tileSize);
        windowTop =         setup("/pics/subwindow/top", gp.tileSize, gp.tileSize);
        windowEdgeTRight =  setup("/pics/subwindow/topright", gp.tileSize, gp.tileSize);
        windowLeft =        setup("/pics/subwindow/left", gp.tileSize, gp.tileSize);
        windowMiddle =      setup("/pics/subwindow/middle", gp.tileSize, gp.tileSize);
        windowRight =       setup("/pics/subwindow/right", gp.tileSize, gp.tileSize);
        windowEdgeBLeft =   setup("/pics/subwindow/bottomleft", gp.tileSize, gp.tileSize);
        windowBottom =      setup("/pics/subwindow/bottom", gp.tileSize, gp.tileSize);
        windowEdgeBRight =  setup("/pics/subwindow/bottomright", gp.tileSize, gp.tileSize);

        select1 = setup("/pics/random/Selector01", gp.tileSize/2, gp.tileSize);
        select2 = setup("/pics/random/Selector02", gp.tileSize/2, gp.tileSize);
        select3 = setup("/pics/random/Selector03", gp.tileSize/2, gp.tileSize);
        select4 = setup("/pics/random/Selector04", gp.tileSize/2, gp.tileSize);

        settingsUI = setup("/pics/subwindow/settingsUI",gp.tileSize, gp.tileSize);

        whitebox = setup("/pics/subwindow/whitebox", gp.tileSize, gp.tileSize);
        redbox = setup("/pics/subwindow/redbox", gp.tileSize, gp.tileSize);
        bluebox  = setup("/pics/subwindow/bluebox", gp.tileSize, gp.tileSize);


        // arial_40 = new Font("Georgia", Font.PLAIN, 40);
        // arial_80B = new Font("Arial", Font.BOLD, 80);
    }
    public BufferedImage setup(String imagePath, int width, int height, float opacity) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
    
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);
    
            // Create a RescaleOp object with the desired opacity
            float[] scales = {1f, 1f, 1f, opacity}; // RGBA scales
            float[] offsets = new float[4];
            RescaleOp op = new RescaleOp(scales, offsets, null);
    
            // Apply the opacity adjustment to the image
            BufferedImage transparentImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = transparentImage.createGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
            image = op.filter(transparentImage, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public BufferedImage setup(String imagePath, int width, int height){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
    public BufferedImage adjustOpacity(BufferedImage image, float opacity) {
        // Create a RescaleOp object with the desired opacity
        float[] scales = {1f, 1f, 1f, opacity}; // RGBA scales
        float[] offsets = new float[4];
        RescaleOp op = new RescaleOp(scales, offsets, null);
    
        // Apply the opacity adjustment to the image
        BufferedImage transparentImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = transparentImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return op.filter(transparentImage, null);
    }
    public void addMessage(String text){
        // message = text;
        // messageOn = true;
        message.add(text);
        messageCounter.add(0);

    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);
        //titlestate
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        //play state
        if(gp.gameState == gp.playState){
            drawPlayerLife();
            drawMessage();
        }
        //pause state
        if(gp.gameState == gp.pauseState){
            drawPlayerLife();
        }
        //dialogue state
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawDialogueScreen();
        }
        //chracter state
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
        }
        //inventory state
        if(gp.gameState == gp.inventoryState){
            drawInventory();
        }
        //option state
        if(gp.gameState == gp.optionState){
            drawOptionScreen();
        }

        if(gp.gameState == gp.gameOverState){
            drawGameOverScreen();
        }
        if(gp.gameState == gp.finalBossDefeated){
            finalBossDefeated();
        }
    }
    public void finalBossDefeated(){
        g2.setColor(new Color(0,0,0,50)); //Half-black
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,70f));
        text = "YOU HAVE CLEARED THE GAME";

        //Shadow
        g2.setColor(Color.BLACK);
        x = getXforCenteredText(text);
        y = gp.tileSize * 4;
        g2.drawString(text,x,y);

        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

        g2.setFont(g2.getFont().deriveFont(50f));
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,50f));
        y = gp.tileSize*2;
        text = "Members: ";
        x = getXforCenteredText(text);
        y += gp.tileSize+gp.tileSize*3;
        FontMetrics metrics = g2.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30f));
        text = "Rainric Randy Yu";
        x = getXforCenteredText(text);
        y += gp.tileSize;
         metrics = g2.getFontMetrics();
         textWidth = metrics.stringWidth(text);
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);
            text = "Michael Ferdinand Bacalso";
        x = getXforCenteredText(text);
        y += gp.tileSize;
         metrics = g2.getFontMetrics();
         textWidth = metrics.stringWidth(text);
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);
            text = "Patrick Rómulo Cabiling";
        x = getXforCenteredText(text);
        y += gp.tileSize;
         metrics = g2.getFontMetrics();
         textWidth = metrics.stringWidth(text);
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);
            text = "Walter Canencia";
        x = getXforCenteredText(text);
        y += gp.tileSize;
         metrics = g2.getFontMetrics();
         textWidth = metrics.stringWidth(text);
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);
            text = "Francis Yap";
        x = getXforCenteredText(text);
        y += gp.tileSize;
         metrics = g2.getFontMetrics();
         textWidth = metrics.stringWidth(text);
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

    }
    public void drawGameOverScreen()
    {
        g2.setColor(new Color(0,0,0,150)); //Half-black
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
        text = "You Died";

        //Shadow
        g2.setColor(Color.BLACK);
        x = getXforCenteredText(text);
        y = gp.tileSize * 4;
        g2.drawString(text,x,y);

        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

        g2.setFont(g2.getFont().deriveFont(50f));
        
        
        y = gp.tileSize*2;
        text = "RETRY";
        x = getXforCenteredText(text);
        y += gp.tileSize+gp.tileSize*3;
        FontMetrics metrics = g2.getFontMetrics();
        int textWidth = metrics.stringWidth(text);

        if (commandNum == 0) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 0) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
         metrics = g2.getFontMetrics();
         textWidth = metrics.stringWidth(text);

        if (commandNum == 1) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 1) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }

    }
    public void drawOptionScreen(){
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int frameX= gp.tileSize*5;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize*6;
        int frameHeight = gp.tileSize*9;
        drawSubWindow(g2,frameX, frameY, frameWidth, frameHeight);
        switch(subState){
            case 0: options_top(frameX, frameY);break;
            case 1: options_top(frameX, frameY);break;
            case 2: options_top(frameX, frameY);break;
        }
    }
    public void options_top(int frameX, int frameY){
        int textX,textY;
        String text = "Options";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;

        int x;
        int y = gp.tileSize*2;
        text = "Full Screen";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        FontMetrics metrics = g2.getFontMetrics();
        int textWidth = metrics.stringWidth(text);

        if (commandNum == 0) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 0) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }
        

        text = "Music";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        metrics = g2.getFontMetrics();
        textWidth = metrics.stringWidth(text);

        if (commandNum == 1) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 1) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }
        text = "SE";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        metrics = g2.getFontMetrics();
        textWidth = metrics.stringWidth(text);

        if (commandNum == 2) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 2) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }

        text = "Control";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        metrics = g2.getFontMetrics();
        textWidth = metrics.stringWidth(text);

        if (commandNum == 3) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 3) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize+gp.tileSize;
        metrics = g2.getFontMetrics();
        textWidth = metrics.stringWidth(text);

        if (commandNum == 4) {
            g2.drawImage(select1, x-15, y-50, null);
        }
         
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 4) {
            g2.drawImage(select2, x + textWidth-15, y-50, null);
        }
    }
    public void drawPlayerLife(){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        //draw blank heart
        // while(i  < gp.player.maxLife/2){
        //     g2.drawImage(heart_blank, x,y, null);
        //     i++;
        //     x+=gp.tileSize;
        // }

        // reset
        
        g2.drawImage(heart_full, x, y, null);
        int borderSize=2;
        x += gp.tileSize * 1.25;
        y *= 1.5;
        int rectWidth = gp.tileSize * 3;
        int rectHeight = 20;
        g2.setColor(Color.BLACK);
        int largerRectSize = 2 * borderSize; 
        g2.fillRoundRect(x - borderSize, y - borderSize, (int)gp.tileSize*3, rectHeight + 2 * borderSize, 10, 10);
        
        // g2.setColor(Color.WHITE);
        // g2.fillRect(x, y, rectWidth, rectHeight);
        i++;
        double oneScale = (double)gp.tileSize/gp.player.maxLife;
        double hpBarValue = oneScale*gp.player.life;
        g2.setColor(Color.RED);
        g2.fillRect(x, y, (int)hpBarValue*3-5, rectHeight);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.drawString(gp.player.life+"/"+gp.player.maxLife, x+gp.tileSize, y+20);
           
        x = gp.tileSize/2+3;
        y = (int)(gp.tileSize*1.5);
        i = 0;
        g2.drawImage(crystal_full, x, y, null);
        g2.setColor(Color.BLACK);
        y=(int)(y*1.2);
        g2.fillRoundRect(x*3, y, (int)gp.tileSize*3, rectHeight + 2 * borderSize, 10, 10);
        // g2.setColor(Color.WHITE);
        // g2.fillRect(x, y, rectWidth, rectHeight);
        oneScale = (double)gp.tileSize/gp.player.maxMana;
        double manaBarValue = oneScale*gp.player.mana;
        g2.setColor(Color.BLUE);
        g2.fillRect(x*3+borderSize, y+borderSize, (int)manaBarValue*3-5, rectHeight);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.drawString(gp.player.mana+"/"+gp.player.maxMana, x*4, y+20);
        
        
  

    }   
    public void drawMessage(){
        int messageX = gp.tileSize;
        int messageY = gp.tileSize*4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
        for(int i=0;i<message.size();i++){
            if(message.get(i) != null){

                g2.setColor(Color.black);
                g2.drawString(message.get(i), messageX+2, messageY);
                g2.setColor(Color.white);
                g2.drawString(message.get(i), messageX, messageY);

                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY+=50;

                if(messageCounter.get(i) > 120){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
        
    }
    public void drawBlack(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        
    }
    public void drawTitleScreen(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        cover = setup("/pics/tiles/cover", gp.screenWidth, gp.screenHeight);

        g2.drawImage(cover, 0, 0, null);
        if(titleScreenState==0){
            //title name
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Ethereal Saga";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            
            //shadow
            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);

            //title screen
            g2.setColor(new Color(150,5,5));
            g2.drawString(text, x, y);

            //blue boy image
            // x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            // y += gp.tileSize*2;
            // g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

            //menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

            
            text = "PLAY";
            x = getXforCenteredText(text);
            y += gp.tileSize * 3.5;

        
            FontMetrics metrics = g2.getFontMetrics();
            int textWidth = metrics.stringWidth(text);

            if (commandNum == 0) {
                g2.drawImage(select1, x-15, y-50, null);
            }
             
                g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

                if (commandNum == 0) {
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }
            text = "CONTINUE";
            x = getXforCenteredText(text);
            y+=gp.tileSize;
            textWidth = metrics.stringWidth(text);
            if(commandNum ==1){
                // g2.drawString(">", x - gp.tileSize,y );
                g2.drawImage(select1, x-15, y-50, null);
            }
            g2.drawString(text, x, y);
            if(commandNum ==1){
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y+=gp.tileSize;
            textWidth = metrics.stringWidth(text);
            
            if(commandNum ==2){
                g2.drawImage(select1, x-15, y-50, null);
                // g2.drawString(">", x - gp.tileSize,y );
            }g2.drawString(text, x, y);
            if(commandNum ==2){
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }
        }
        else if (titleScreenState == 1){
            g2.setColor(new Color(150,5,5));
            g2.setFont(g2.getFont().deriveFont(42F));

            String text = "Select your class!";
            int x  = getXforCenteredText(text);
            int y = gp.tileSize * 3;
            g2.drawString(text, x, y);

            text = "Knight";
            x = getXforCenteredText(text);
            y+= gp.tileSize*3;
            
            FontMetrics metrics = g2.getFontMetrics();
            int textWidth = metrics.stringWidth(text);

            // g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawImage(select1, x-15, y-50, null);
            }
            g2.drawString(text, x + (textWidth - metrics.stringWidth(text)) / 2, y);

            if (commandNum == 0) {
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }
            
            text = "Assassin";
            x = getXforCenteredText(text);
            y+= gp.tileSize;
            textWidth = metrics.stringWidth(text);
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawImage(select1, x-15, y-50, null);
            }
            if(commandNum == 1){
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }

            text = "Caster";
            x = getXforCenteredText(text);
            y+= gp.tileSize;
            textWidth = metrics.stringWidth(text);
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawImage(select1, x-15, y-50, null);
            }
            if(commandNum == 2){
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }

            text = "Back";
            x = getXforCenteredText(text);
            y+= gp.tileSize*2;
            g2.drawString(text, x, y);
            textWidth = metrics.stringWidth(text);
            if(commandNum == 3){
                g2.drawImage(select1, x-15, y-50, null);
            }
            if(commandNum == 3){
                g2.drawImage(select2, x + textWidth-15, y-50, null);
            }
        }
        

        
    }
    
    // public void drawDialogueScreen(){
    //     int x = gp.tileSize*2;
    //     int y = gp.tileSize/2;
    //     int width = gp.screenWidth - (gp.tileSize*4);
    //     int height = gp.tileSize * 4;
    //     drawSubWindow(x,y,width,height);

    //     g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
    //     x+= gp.tileSize;
    //     y+= gp.tileSize;
    //     for(String line : currentDialogue.split("\n")){
    //         g2.drawString(line, x, y);
    //         y += 40;
    //     }
        
    // }
    
    public void drawDialogueScreen() {
        if (g2 == null || currentDialogue == null) {
            return;  // Check for null to avoid potential issues
        }
    
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow(g2,x, y, width, height);
    
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28F));
        x += gp.tileSize;
        y += gp.tileSize;
    
        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }
    


    public void drawCharacterScreen(){
        //create a frame
        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = (int)(gp.tileSize*10.5);
        drawSubWindow(g2,frameX, frameY, frameWidth, frameHeight);

        //text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 35;

        //names
        g2.drawString("Level", textX,textY);
        textY +=lineHeight;
        g2.drawString("Life", textX, textY);
        textY +=lineHeight;
        g2.drawString("Mana", textX, textY);
        textY +=lineHeight;
        g2.drawString("Strenth", textX, textY);
        textY +=lineHeight;
        g2.drawString("Dexterity", textX, textY);
        textY +=lineHeight;
        g2.drawString("Attack", textX, textY);
        textY +=lineHeight;
        g2.drawString("Defense", textX, textY);
        textY +=lineHeight;
        g2.drawString("Exp", textX, textY);
        textY +=lineHeight;
        g2.drawString("Next Level", textX, textY);
        textY +=lineHeight;
        g2.drawString("Coin", textX, textY);
        textY +=lineHeight + 20;
        // g2.drawString("Weapon", textX, textY);
        // textY +=lineHeight + 15;
        // g2.drawString("Shield", textX, textY);
        // textY +=lineHeight;

        // values
        int tailX  = (frameX + frameWidth) - 30;
        //reset texty
        textY = frameY + gp.tileSize;
        String value;
        
        value = String.valueOf(gp.player.level);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.life + "/" +gp.player.maxLife);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.mana + "/" +gp.player.maxMana);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.strength);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.dexterity);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.exp+"/"+gp.player.nextLevelExp);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;
        
        value = String.valueOf(gp.player.nextLevelExp);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value,textX, textY);
        textY +=lineHeight;

        g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY-17, null);
        textY +=lineHeight;

        g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY, null);
    }
    public void drawInventory(){
        // frame
        int frameX = gp.tileSize;
        int frameY = gp.tileSize*8;
        int frameWidth = gp.tileSize*14;
        int frameHeight = gp.tileSize*4;
        drawSubWindow(g2,frameX, frameY, frameWidth, frameHeight);

        //slot
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        int slotSize = gp.tileSize+2;

        //draw players item
        for(int i=0;i<gp.player.inventory.size();i++){

            //equip curosr
            if(gp.player.inventory.get(i) == gp.player.currentWeapon || 
                gp.player.inventory.get(i) == gp.player.currentShield){
                    g2.setColor(new Color(240,190,90));
                    // g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
                    g2.drawImage(redbox, slotX,slotY,null);
                }
            
            
            g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY,null);
            slotX+=slotSize;
            if(i==12 || i == 25 || i == 38){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }
        
        //cursor
        int cursorX = slotXstart + (slotSize*slotCol);
        int cursorY = slotYstart + (slotSize*slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        g2.setColor(new Color(36,16,212));
        for(int q = 548;q<=684;q+=68){
            for(int i = 86;i<=902;i+=68){
                
                // g2.drawRoundRect(i, q, cursorWidth, cursorHeight, 10, 10);
                float opacity = 0.3f; 
                AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
                AlphaComposite originalComposite = (AlphaComposite) g2.getComposite();
                g2.setComposite(alphaComposite);
                g2.drawImage(whitebox, i, q, null);
                g2.setComposite(originalComposite);
            }
        }
        
        
        // draw cursor
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(5));
        // g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
        g2.drawImage(bluebox,cursorX,cursorY, null );
        
        // for(int i = 86;i<=902;i+=cursorWidth){
        //     for(int j = 548;j<=684;i+=cursorHeight){
        //         g2.setStroke(new BasicStroke(5));   
        //     }
        // }
        //desscription frame
        int dframeX = frameX;
        int dframeY = frameY + frameHeight;
        int dframeWidth = frameWidth;
        int dframeHeight = gp.tileSize*3;
       
        //draw description text
        int textX = dframeX + 20;
        int textY = dframeY + gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(24F));
        int itemIndex = getItemIndexOnSlot();

        if(itemIndex < gp.player.inventory.size()){
            drawSubWindow(g2,dframeX, dframeY, dframeWidth, dframeHeight);
            for(String line: gp.player.inventory.get(itemIndex).description.split("\n")){
                g2.drawString(line, textX, textY);
                textY+=32;
            }
        }
        
    }
    public int getItemIndexOnSlot(){
        int itemIndex = slotCol+(slotRow*13);
        // System.out.println(itemIndex);
        return itemIndex;
    }
    // public void drawSubWindow(int x,int y, int width, int height){
        
    //     g2.drawImage(windowEdgeTLeft, x, y, null);
    //     for(int i = x;i<=width;i+=gp.tileSize){
    //         for(int j = y;j<=height;j+=gp.tileSize){
    //             if(i==x && j == y){
    //                 g2.drawImage(windowEdgeTLeft,i,j,null);
    //             }
                
    //             else if(i>x && j==y){
    //                 g2.drawImage(windowTop,i,j,null);
    //             }
    //         }
    //     }
    // }
    
        // Color c = new Color(0,0,0,210);
        // g2.setColor(c);
        // g2.fillRoundRect(x, y, width, height,35, 35);

        // c = new Color(255,255,255);
        // g2.setColor(c);
        // g2.setStroke(new BasicStroke(5));
        // g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        // int i = x,j = y;
        public void drawSubWindow(Graphics2D g2, int x, int y, int width, int height) {
            x= x-gp.tileSize/6;
            y= y-gp.tileSize/6;
            width = width +=gp.tileSize/2.5;
            height = height += gp.tileSize/2.5;
            g2.drawImage(windowEdgeTLeft, x, y, null);
            g2.drawImage(windowEdgeTRight, x + width - gp.tileSize, y, null);
        
            g2.drawImage(windowEdgeBLeft, x, y + height - gp.tileSize, null);
            g2.drawImage(windowEdgeBRight, x + width - gp.tileSize, y + height - gp.tileSize, null);
        
            for (int i = x + gp.tileSize; i < x + width - gp.tileSize; i += gp.tileSize) {
                g2.drawImage(windowTop, i, y, null);
                g2.drawImage(windowBottom, i, y + height - gp.tileSize, null);
            }
        
            for (int i = y + gp.tileSize; i < y + height - gp.tileSize; i += gp.tileSize) {
                g2.drawImage(windowLeft, x, i, null); 
                g2.drawImage(windowRight, x + width - gp.tileSize, i, null); 
            }
        
            for (int i = y + gp.tileSize; i < y + height - gp.tileSize; i += gp.tileSize) {
                for (int j = x + gp.tileSize; j < x + width - gp.tileSize; j += gp.tileSize) {
                    g2.drawImage(windowMiddle, j, i, null);
                }
            }
        }
        
            // x = gp.tileSize;
            // y =gp.tileSize;
           
            // g2.drawImage(windowBottom,x,y, null);
            // x+=gp.tileSize;
            // y+=gp.tileSize;
            // g2.drawImage(windowRight,x,y, null);
            // x+=gp.tileSize;
            // y+=gp.tileSize;
            // g2.drawImage(windowLeft,x,y, null);
        
        // public void qweqwe(){
        //     int x = gp.tileSize,y =gp.tileSize;
           
        //     g2.drawImage(windowBottom,x,y, null);
        //     x+=gp.tileSize;
        //     y+=gp.tileSize;
        //     g2.drawImage(windowRight,x,y, null);
        //     x+=gp.tileSize;
        //     y+=gp.tileSize;
        //     g2.drawImage(windowLeft,x,y, null);
        // }
        public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    public int getXforAlignToRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }

    }
        

