package main;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed,rightPressed, enterPressed, shotKeyPressed;
    GamePanel gp;
    // debugg
    boolean checkDrawTime = false;
    public int playerClass;
    public final int Knight = 1;
    public final int Assassin = 2;
    public final int Caster = 3;
    public KeyHandler(GamePanel gp){
        this.gp =gp;
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }
    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        //title state
        if(gp.gameState == gp.titleState){
            titleState(code);
        }
        //play state
        else if(gp.gameState == gp.playState){
            playState(code);
        }
        
        //dialogue state
        else if(gp.dialogueState == gp.gameState){
            dialogueState(code);
        }
        //character state
        else if(gp.gameState == gp.characterState){
            characterState(code);
        }
        //option state
        else if(gp.gameState == gp.optionState){
            optionState(code);
        }
        else if(gp.gameState == gp.inventoryState){
            inventoryState(code);
        }
        else if(gp.gameState == gp.gameOverState){
            gameOverState(code);
        }
        if(code == KeyEvent.VK_K){
            gp.gameState = gp.finalBossDefeated;
        }
        
    }
    public void titleState(int code){
        if(gp.ui.titleScreenState == 0){
            if (code == KeyEvent.VK_W){
            
            gp.ui.commandNum--;
            if(gp.ui.commandNum<0){
                gp.ui.commandNum = 2;
            }
            gp.playSE(9);
        }
        if (code == KeyEvent.VK_S){
            gp.ui.commandNum++;
            if(gp.ui.commandNum>2){
                gp.ui.commandNum = 0;
            }
            gp.playSE(9);
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.ui.titleScreenState = 1;
            }
            if(gp.ui.commandNum == 1){
                if(gp.gwapoko == true){
                    gp.saveLoad.load();
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }else{
                    gp.ui.titleScreenState = 0;
                }
                
            }
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }
        }
    }

    else if(gp.ui.titleScreenState == 1){
            if (code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            if(gp.ui.commandNum<0){
                gp.ui.commandNum = 3;
            }
            gp.playSE(9);
        }
        if (code == KeyEvent.VK_S){
            gp.ui.commandNum++;
            if(gp.ui.commandNum>3){
                gp.ui.commandNum = 0;
            }
            gp.playSE(9);
        }
        if(code == KeyEvent.VK_ENTER){
            if (gp.ui.commandNum == 0) {
                playerClass = 1;
                gp.player.setPlayerClass(playerClass); // Set the player's class
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }

            if (gp.ui.commandNum == 1) {
                playerClass = 2;
                gp.player.setPlayerClass(playerClass); 
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
                
            
            if(gp.ui.commandNum == 2){
                playerClass = 3;
                gp.player.setPlayerClass(playerClass); 
                gp.gameState  = gp.playState;
                gp.playMusic(0);
            }
            if(gp.ui.commandNum == 3){
                gp.ui.titleScreenState = 0;
            }
        }
    }

            
    }
    public void playState(int code){
        if (code == KeyEvent.VK_W){
            upPressed=true;
            }
            if (code == KeyEvent.VK_S){
                downPressed=true;
            }
            if (code == KeyEvent.VK_A){
                leftPressed=true;
            }
            if (code == KeyEvent.VK_D){
                rightPressed=true;
            }
            if (code == KeyEvent.VK_ENTER){
                    enterPressed = true;
            }

            if(code == KeyEvent.VK_F){
                shotKeyPressed = true;
            }
            if(code == KeyEvent.VK_C){
                gp.gameState = gp.characterState;
            }

            //pause and play
            if (code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.optionState;
            }

            //debug
            if (code == KeyEvent.VK_T){
                if(checkDrawTime == false){
                    checkDrawTime = true;
                }else if(checkDrawTime == true){
                    checkDrawTime = false;
                }
            }
            if(code == KeyEvent.VK_B){
                gp.gameState = gp.inventoryState;
            }
            if (code == KeyEvent.VK_1){
                gp.gameState = gp.inventoryState;
            }
            
            
    }
    public void optionState(int code)
    {
        if(code == KeyEvent.VK_ESCAPE)
        {
            gp.gameState = gp.playState;
        }
        if(code == KeyEvent.VK_ENTER)
        {   
            if(gp.ui.commandNum == 4){
                gp.gameState = gp.titleState;
            }
            enterPressed = true;
        }
        int maxCommandNum = 0;
        switch (gp.ui.subState)
        {
            case 0: maxCommandNum = 4; break;
            case 2: maxCommandNum = 1; break;
        }
        if(code == KeyEvent.VK_W)
        {
            gp.ui.commandNum--;
            gp.playSE(9);
            if(gp.ui.commandNum < 0)
            {
                gp.ui.commandNum = maxCommandNum;
            }
        }
        if(code == KeyEvent.VK_S)
        {
            gp.ui.commandNum++;
            gp.playSE(9);
            if(gp.ui.commandNum > maxCommandNum)
            {
                gp.ui.commandNum = 0;
            }
        }
        
        // if(code   == KeyEvent.VK_A)
        // {
        //     if(gp.ui.subState == 0)
        //     {
        //         if(gp.ui.commandNum == 1 && gp.music.volumeScale > 0) //music
        //         {
        //             gp.music.volumeScale--;
        //             gp.music.checkVolume();  //check for music maybe a song is already being played, but you dont need it for SE, when set a sound checkVolume will be execute.
        //             gp.playSE(9);
        //         }
        //         if(gp.ui.commandNum == 2 && gp.se.volumeScale > 0) //SE
        //         {
        //             gp.se.volumeScale--;
        //             gp.playSE(9);
        //         }
        //     }
        // }
        // if(code == KeyEvent.VK_D)
        // {
        //     if(gp.ui.subState == 0)
        //     {
        //         if(gp.ui.commandNum == 1 && gp.music.volumeScale < 5) //music
        //         {
        //             gp.music.volumeScale++;
        //             gp.music.checkVolume();
        //             gp.playSE(9);
        //         }
        //         if(gp.ui.commandNum == 2 && gp.se.volumeScale < 5) //SE
        //         {
        //             gp.se.volumeScale++;
        //             gp.playSE(9);
        //         }
        //     }
        // }
    }
    public void gameOverState(int code)
    {
        if(code == KeyEvent.VK_W)
        {
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0)
            {
                gp.ui.commandNum = 1;
            }
            gp.playSE(9);
        }
        if(code == KeyEvent.VK_S)
        {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 1)
            {
                gp.ui.commandNum = 0;
            }
            gp.playSE(9);
        }
        if(code == KeyEvent.VK_ENTER)
        {
            if(gp.ui.commandNum == 0) 
            {   
                gp.resetGame(true);
                gp.gameState = gp.playState;
                gp.playMusic(0);
                System.out.println(gp.ui.commandNum);
            }
            else if(gp.ui.commandNum == 1) 
            {   
                gp.resetGame(false);
                System.out.println(gp.ui.commandNum);
                gp.ui.titleScreenState = 0;
                gp.gameState = gp.titleState;
            }
        }
    }
    public void inventoryState(int code){
        if(code == KeyEvent.VK_B){
            gp.gameState = gp.playState;
        }
        if(code == KeyEvent.VK_ESCAPE){;
            gp.gameState = gp.playState;
        }
        if(code == KeyEvent.VK_W){
            if(gp.ui.slotRow!=0){
            gp.ui.slotRow--;
            gp.playSE(9);
            }
        }
        if(code == KeyEvent.VK_A){
            if(gp.ui.slotCol!=0){
            gp.ui.slotCol--;
            gp.playSE(9);
            }
        }
        if(code == KeyEvent.VK_S){
            if(gp.ui.slotRow!=2){
            gp.ui.slotRow++;
            gp.playSE(9);
            }
        }
        if(code == KeyEvent.VK_D){
            if(gp.ui.slotCol!=12){
            gp.ui.slotCol++;
            gp.playSE(9);
            }
        }
        if(code==KeyEvent.VK_ENTER){
            gp.player.selectItem();
        }
    }
   
    public void dialogueState(int code){
        if(code == KeyEvent.VK_ENTER){
                    gp.gameState = gp.playState;
                }
                if(code == KeyEvent.VK_ESCAPE){;
                    gp.gameState = gp.playState;
                }
                
                
                
    }
    public void characterState(int code){
        if(code == KeyEvent.VK_C){
                gp.gameState = gp.playState;
            }
            if(code == KeyEvent.VK_ESCAPE){;
                gp.gameState = gp.playState;
            }
       
        
    }
    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W){
            upPressed=false;
        }
        if (code == KeyEvent.VK_S){
            downPressed=false;
        }
        if (code == KeyEvent.VK_A){
            leftPressed=false;
        }
        if (code == KeyEvent.VK_D){
            rightPressed=false;
        }
        if(code == KeyEvent.VK_F){
            shotKeyPressed = false;
        }
        // if(code == KeyEvent.VK_B){
        //     B
        // }
    }
}
