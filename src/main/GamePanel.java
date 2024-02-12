package main;
import entity.Entity;
import entity.Player;
// import object.SuperObject;
import tile.TileManager;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTilzeSize = 22;
    final int scale = 3;

    public final int tileSize = originalTilzeSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize*maxScreenCol; //768 pixel
    public final int screenHeight = tileSize*maxScreenRow; //576 pixels


    //WORLD SETTINGS
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    // for full screen
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    

    public final int FPS = 60;
    
    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public MouseHandler mouseH = new MouseHandler(this);
    

    public Sound music = new Sound();
    public Sound se = new Sound();

    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;

    // entity and object
    public Player player = new Player(this,keyH, mouseH);
    public Entity obj[] = new Entity[500];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    public ArrayList<Entity> entityList = new ArrayList<>();


    //game state
    public int gameState;
    public final int titleState =0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionState = 5;
    public final int inventoryState = 6;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.mouseH = new MouseHandler(this);

        this.addMouseListener(mouseH);
        addMouseListener(mouseH);
    }
    public Player getPlayer() {
        return player;
    }
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        aSetter.setTree();
        
        gameState = titleState;

        tempScreen = new BufferedImage(screenWidth, screenHeight,BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)tempScreen.getGraphics();
        // setFullScreen();
        //diri
    }
    public void setFullScreen(){
        //get local screen device
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        //get full screen width and height
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int frames = 0;
        while(gameThread!=null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime) / drawInterval;
            timer+=(currentTime-lastTime);
            lastTime = currentTime;
            if (delta>=1){
                update();
                // repaint();
                drawToTempScreen();
                drawToScreen();
                delta--;
                frames++;
            }
            if(timer>=1000000000){
                System.out.println("FPS: "+ frames);
                frames = 0;
                timer=0;
            }
        }
    }
    public void update(){
        if(gameState == playState){
            //player
            player.update();
            //npc
            for(int i=0;i<npc.length;i++){
                if(npc[i]!=null){
                    npc[i].update();
                }
            }
            for(int i=0;i<monster.length;i++){
                if(monster[i]!=null){
                    if(monster[i].alive== true && monster[i].dying == false){
                        monster[i].update();    
                    }
                    if(monster[i].alive== false){
                        monster[i].checkDrop();
                        monster[i] = null;    
                    }
                }
            }
            for(int i=0;i<projectileList.size();i++){
                if(projectileList.get(i)!=null){
                    if(projectileList.get(i).alive== true){
                        projectileList.get(i).update();    
                    }
                    if(projectileList.get(i).alive== false){
                        projectileList.remove(i);
                    }
                }
            }

        }
        if(gameState == pauseState){
            
        }
        
    }
    public void drawToTempScreen(){
        //debug
        long drawStart = 0;
        if(keyH.checkDrawTime == true){
        drawStart = System.nanoTime();
        }
        //title screen
        if(gameState == titleState){
            ui.draw(g2);
        }
        else{
                //tile
                tileM.draw(g2);
                //DRAWINGS
                entityList.add(player);

                // add entity to the list
                for(int i = 0;i <npc.length;i++){
                    if(npc[i]!=null){
                        entityList.add(npc[i]);
                    }
                }
                for(int i = 0;i<obj.length;i++){
                    if(obj[i]!=null){
                        entityList.add(obj[i]);
                    }
                }
                //monster
                for(int i = 0;i<monster.length;i++){
                    if(monster[i]!=null){
                        entityList.add(monster[i]);
                    }
                }
                for(int i = 0;i<projectileList.size();i++){
                    if(projectileList.get(i)!=null){
                        entityList.add(projectileList.get(i));
                    }
                }
                // sort
                Collections.sort(entityList, new Comparator<Entity>() {
                    @Override
                    public int compare(Entity e1, Entity e2) {
                        int result = Integer.compare(e1.worldY, e2.worldY);
                        return result;
                    }
                });
                //draw entities
                for(int i =0;i<entityList.size();i++){
                    entityList.get(i).draw(g2);
                }
                //empty entities
                entityList.clear();
                //player
                player.draw(g2);          
                //ui
        ui.draw(g2);
        }
            //debug
            if(keyH.checkDrawTime==true){
                long drawEnd = System.nanoTime();
                long passed = drawEnd - drawStart;
                g2.setFont(new Font("Arial", Font.PLAIN, 20));
                g2.setColor(Color.white);
                int x = 10;
                int y = 400;
                int lineheight = 20;
                g2.drawString("WorldX: " +player.worldX, x,y); y+=lineheight;
                g2.drawString("WorldY: " +player.worldY, x,y);y+=lineheight;
                g2.drawString("Col: " +(player.worldX + player.solidArea.x)/tileSize, x,y);y+=lineheight;
                g2.drawString("Row: " +(player.worldY + player.solidArea.y)/tileSize, x,y);y+=lineheight;
                g2.drawString("Draw Time: "+passed, x,y);
            }
    }

    public void drawToScreen(){
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2,null);
        // g.fillRect(mouseH.getX()-25, mouseH.getY()-25, tileSize, tileSize);
        // if(mouseH.getButton()!=-1){
        // System.out.println("Button: "+mouseH.getButton());
        // }

        g.dispose();
    }
    // public void paintComponent(Graphics g){
    //     super.paintComponent(g);
    //     Graphics2D g2 = (Graphics2D)g;
    //     //debug
    //     long drawStart = 0;
    //     if(keyH.checkDrawTime == true){
    //     drawStart = System.nanoTime();
    //     }
    //     //title screen
    //     if(gameState == titleState){
    //         ui.draw(g2);
    //     }else{
    //             //tile
    //             tileM.draw(g2);
    //             //DRAWINGS
    //             entityList.add(player);
    //             // add entity to the list
    //             for(int i = 0;i <npc.length;i++){
    //                 if(npc[i]!=null){
    //                     entityList.add(npc[i]);
    //                 }
    //             }
    //             for(int i = 0;i<obj.length;i++){
    //                 if(obj[i]!=null){
    //                     entityList.add(obj[i]);
    //                 }
    //             }
    //             //monster
    //             for(int i = 0;i<monster.length;i++){
    //                 if(monster[i]!=null){
    //                     entityList.add(monster[i]);
    //                 }
    //             }
    //             for(int i = 0;i<projectileList.size();i++){
    //                 if(projectileList.get(i)!=null){
    //                     entityList.add(projectileList.get(i));
    //                 }
    //             }
    //             // sort
    //             Collections.sort(entityList, new Comparator<Entity>() {
    //                 @Override
    //                 public int compare(Entity e1, Entity e2) {
    //                     int result = Integer.compare(e1.worldY, e2.worldY);
    //                     return result;
    //                 }
    //             });
    //             //draw entities
    //             for(int i =0;i<entityList.size();i++){
    //                 entityList.get(i).draw(g2);
    //             }
    //             //empty entities
    //             entityList.clear();
    //             //player
    //             player.draw(g2);
    //             //ui
    //     ui.draw(g2);
    //     }
    //         //debug
    //         if(keyH.checkDrawTime==true){
    //             long drawEnd = System.nanoTime();
    //             long passed = drawEnd - drawStart;
    //             g2.setFont(new Font("Arial", Font.PLAIN, 20));
    //             g2.setColor(Color.white);
    //             int x = 10;
    //             int y = 400;
    //             int lineheight = 20;
    //             g2.drawString("WorldX: " +player.worldX, x,y); y+=lineheight;
    //             g2.drawString("WorldY: " +player.worldY, x,y);y+=lineheight;
    //             g2.drawString("Col: " +(player.worldX + player.solidArea.x)/tileSize, x,y);y+=lineheight;
    //             g2.drawString("Row: " +(player.worldY + player.solidArea.y)/tileSize, x,y);y+=lineheight;
    //             g2.drawString("Draw Time: "+passed, x,y);
    //             // System.out.println("Draw Time: "+passed);
    //         }
    //     g2.dispose();
    // }
    
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();

    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
