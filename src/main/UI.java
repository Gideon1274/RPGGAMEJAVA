package main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import java.awt.event.ActionEvent;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font purisaBold, maruMonica;
    BufferedImage heart_full, heart_half, heart_blank, crystal_full, crystal_blank;
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

    
    
    public UI(GamePanel gp){
        this.gp = gp;
        try{
            //  InputStream is = getClass().getResourceAsStream("/pics/font/PurisaBold.ttf");
             InputStream is = getClass().getResourceAsStream("/pics/font/maruMonica.ttf");
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
    
    

        // arial_40 = new Font("Georgia", Font.PLAIN, 40);
        // arial_80B = new Font("Arial", Font.BOLD, 80);
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
            drawPauseScreen();
        }
        //dialogue state
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawDialogueScreen();
        }
        //chracter state
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
            drawInventory();
        }
    }
    public void drawPlayerLife(){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        //draw blank heart
        while(i  < gp.player.maxLife/2){
            g2.drawImage(heart_blank, x,y, null);
            i++;
            x+=gp.tileSize;
        }

        // reset
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        //draw current life
        while(i< gp.player.life){
            g2.drawImage(heart_half,x,y, null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full, x,y, null);
            }
            i++;
            x+=gp.tileSize;
        }
        //draw max mana
        x = (gp.tileSize/2)-5;
        y = (int)(gp.tileSize*1.5);
        i = 0;
        while(i < gp.player.maxMana){
            g2.drawImage(crystal_blank,x,y,null);
            i++;
            x+=35;
        }
        //draw mana
        x = (gp.tileSize/2)-5;
        y = (int)(gp.tileSize*1.5);
        i = 0;
        while(i < gp.player.mana){
            g2.drawImage(crystal_full,x,y, null);
            i++;
            x+=35;
        }
        
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

                if(messageCounter.get(i) > 180){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
        
    }
    public void drawTitleScreen(){


        if(titleScreenState==0){
            
            g2.setColor(new Color(0,0,0));
            g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
            //title name
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Blue Boy Adventure";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            
            //shadow
            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);

            //title screen
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //blue boy image
            x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            y += gp.tileSize*2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

            //menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

            text = "NEW GAME";
            x = getXforCenteredText(text);
            y+=gp.tileSize*3.5;
            g2.drawString(text, x, y);
            if(commandNum ==0){
                g2.drawString(">", x - gp.tileSize,y );
            }

            text = "LOAD GAME";
            x = getXforCenteredText(text);
            y+=gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum ==1){
                g2.drawString(">", x - gp.tileSize,y );
            }
            
            text = "QUIT";
            x = getXforCenteredText(text);
            y+=gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum ==2){
                g2.drawString(">", x - gp.tileSize,y );
            }
        }
        else if (titleScreenState == 1){
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));

            String text = "Select your class!";
            int x  = getXforCenteredText(text);
            int y = gp.tileSize * 3;
            g2.drawString(text, x, y);

            text = "Fighter";
            x = getXforCenteredText(text);
            y+= gp.tileSize*3;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-gp.tileSize, y);
            }
            
            text = "Thief";
            x = getXforCenteredText(text);
            y+= gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "Sorcerer";
            x = getXforCenteredText(text);
            y+= gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "Back";
            x = getXforCenteredText(text);
            y+= gp.tileSize*2;
            g2.drawString(text, x, y);
            if(commandNum == 3){
                g2.drawString(">", x-gp.tileSize, y);
            }
        }

        
    }
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text), y = gp.screenHeight/2;
        

        g2.drawString(text,x,y);
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
        drawSubWindow(x, y, width, height);
    
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
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

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
        g2.drawString("Weapon", textX, textY);
        textY +=lineHeight + 15;
        g2.drawString("Shield", textX, textY);
        textY +=lineHeight;

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
        int frameX = gp.tileSize*9;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize*6;
        int frameHeight = gp.tileSize*5;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

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
                    g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
                }

            g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY,null);
            slotX+=slotSize;
            if(i==4 || i == 9 || i == 14){
                slotX = slotXstart;
                slotY += slotSize;
            }
        }

        //cursor
        int cursorX = slotXstart + (slotSize*slotCol);
        int cursorY = slotYstart + (slotSize*slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        
        // draw cursor
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

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
            drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);
            for(String line: gp.player.inventory.get(itemIndex).description.split("\n")){
                g2.drawString(line, textX, textY);
                textY+=32;
            }
        }
    }
    public int getItemIndexOnSlot(){
        int itemIndex = slotCol+(slotRow*5);

        return itemIndex;
    }
    public void drawSubWindow(int x,int y, int width, int height){
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height,35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        }
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
        

