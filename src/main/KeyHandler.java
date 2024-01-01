package main;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed,rightPressed;
    GamePanel gp;
    // debugg
    boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp){
        this.gp =gp;
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }
    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
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

        //pause and play
        if (code == KeyEvent.VK_Q){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }

        //debug
        if (code == KeyEvent.VK_T){
            if(checkDrawTime == false){
                checkDrawTime = true;
            }else if(checkDrawTime == true){
                checkDrawTime = false;
            }
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
    }
}
