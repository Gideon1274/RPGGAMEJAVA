package main;
import java.awt.event.KeyListener;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed,rightPressed, enterPressed;
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

        //title state
        if(gp.gameState == gp.titleState){
            if (code == KeyEvent.VK_W){
                
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum = 2;
                }
            }
            if (code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1){
                    // add
                }
                if(gp.ui.commandNum == 2){
                    System.exit(0);
                }
            }
        }

        if(gp.gameState == gp.playState){
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
                //pause and play
                if (code == KeyEvent.VK_Q){
                    gp.gameState = gp.pauseState;
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

        //pause state
        else if(gp.pauseState == gp.gameState){
            //pause and play                
                if (code == KeyEvent.VK_Q){
                    gp.gameState = gp.playState;
                }
        }
        //dialogue state
        else if(gp.dialogueState == gp.gameState){
                if(code == KeyEvent.VK_ENTER){
                    gp.gameState = gp.playState;
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
