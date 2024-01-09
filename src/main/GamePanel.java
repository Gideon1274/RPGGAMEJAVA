package main;
import entity.Entity;
import entity.Player;
// import object.SuperObject;
import tile.TileManager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTilzeSize = 16;
    final int scale = 3;

    public final int tileSize = originalTilzeSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow= 12;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;


    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    public final int FPS = 60;
    
    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);

    public Sound music = new Sound();
    public Sound se = new Sound();

    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;

    // entity and object
    public Player player = new Player(this,keyH);
    public Entity obj[] = new Entity[10];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];

    ArrayList<Entity> entityList = new ArrayList<>();


    //game state
    public int gameState;
    public final int titleState =0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        
        gameState = titleState;

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    //  public void run(){
    //         double drawInterval = 1000000000/FPS;
    //         double nextDrawTime = System.nanoTime()+drawInterval;
    
    //         while(gameThread!=null){
    //             // long currentTime = System.nanoTime();
    //             // System.out.println("CurrentTime: "+currentTime);
    
                
    //             update();
    //             repaint();
                
    //             try {
    //                 double remainingTime = nextDrawTime - System.nanoTime();
    //                 remainingTime = remainingTime/1000000;
    
    //                 if(remainingTime<0){
    //                     remainingTime=0;
    //                 }
    //                 Thread.sleep((long)remainingTime);
    //                 nextDrawTime+=drawInterval;
    //             }catch(InterruptedException e){
    //                 e.printStackTrace();
    //             }
                
    
    //         }
    //     }
    
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        // int drawCount =0;

    
        while(gameThread!=null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime) / drawInterval;
            timer+=(currentTime-lastTime);

            lastTime = currentTime;
            if (delta>=1){
                update();
                repaint();
                delta--;
                // drawCount++;

            }
            if(timer>=1000000000){
                
                // drawCount=0;
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
                    monster[i].update();
                }
            }
        }
        if(gameState == pauseState){

        }
       
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        
        //debug
        long drawStart = 0;
        if(keyH.checkDrawTime == true){
        drawStart = System.nanoTime();
        }
        //title screen
        if(gameState == titleState){
            ui.draw(g2);
        }else{
                //tile
                tileM.draw(g2);

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
        g2.setColor(Color.white);
        g2.drawString("Draw Time: "+passed, 10,400);
        System.out.println("Draw Time: "+passed);
            }
        g2.dispose();
        
    }
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
