package main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font purisaBold, maruMonica;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    DecimalFormat df = new DecimalFormat("#0.00");
    double playTime;
    public String currentDialogue = "";
    public int commandNum = 0;


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
       
        // arial_40 = new Font("Georgia", Font.PLAIN, 40);
        // arial_80B = new Font("Arial", Font.BOLD, 80);
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
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
        if(gp.gameState == gp.playState){

        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
    }
    public void drawTitleScreen(){
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


    }
        

