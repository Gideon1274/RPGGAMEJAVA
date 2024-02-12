package entity;

import main.GamePanel;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Projectile extends Entity implements MouseMotionListener,MouseListener,Cloneable {
    Entity user;
    public int mouseX;
    public int mouseY;
    double targetAngle;
    public double dx;
    public double dy;
    public boolean leftClicked;
    public double screenHeight = gp.screenHeight;
    public double screenWidth = gp.screenWidth;
    public double shotAvailableCounter;
    public Projectile(GamePanel gp) {
        super(gp);
        gp.addMouseMotionListener(this);
    }

    public void set(int worldX, int worldY, boolean alive, Entity user) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;

        calculateTargetAngle();
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
        // Additional logic for deep cloning if necessary
    }
    private void calculateTargetAngle() {
        double dx = mouseX - screenWidth / 2;
        double dy = mouseY - screenHeight / 2;
        targetAngle = Math.atan2(dy, dx);
    }
    public void update() {
        
            worldX += speed * Math.cos(targetAngle);
            worldY += speed * Math.sin(targetAngle);

            // if (user == gp.player) {
            //     int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            //     if (monsterIndex != 999) {
            //         gp.player.damageMonster(monsterIndex, attack);
            //         alive = false; // projectile alive is false
            //         System.out.println("COllision");
                    
            //     }
            // }
            // if (user != gp.player) {
            //     boolean contactPlayer = gp.cChecker.checkPlayer(this);
            //     if (!gp.player.invincible && contactPlayer) {
            //         damagePlayer(attack);
            //         alive = false;
            //         System.out.println("COllision");
            //     }
            // }
            life--;
            if(life<=0){
                alive = false;
            }
            // System.out.println("Current Position: X = " + mouseX + ", Y =" + mouseY);
            // System.out.println("WORLDPP Position: X = " + worldX + ", Y =" + worldY);
            // System.out.println("TargetAngle: " + targetAngle);

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteCounter == 1) {
                    spriteNum = 2;
                } else if (spriteCounter == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    
    

    
    public boolean haveResource(Entity user) {
        boolean haveResource = false;
        return haveResource;
    }

    public void subtractResource(Entity user) {
    }

    public void mouseClicked(MouseEvent e){
        leftClicked = true;
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        // mouseX = e.getX();
        // mouseY = e.getY();
        // System.out.println("pressed");
    }
    public void mouseReleased(MouseEvent e){
       
        leftClicked =false;
        // System.out.println("released");
    }
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        // System.out.println("Leftclicked: "+leftClicked+" mosueX: "+mouseX+" mouseY: "+mouseY);
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        // System.out.println("Leftclicked: "+leftClicked+" mosueX: "+mouseX+" mouseY: "+mouseY);
    }

}
