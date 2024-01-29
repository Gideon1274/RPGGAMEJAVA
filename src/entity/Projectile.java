// package entity;

// import main.GamePanel;

// import java.awt.event.MouseMotionListener;

// import java.awt.event.MouseEvent;

// public class Projectile extends Entity implements MouseMotionListener {
//     Entity user;
//     int mouseX;
//     int mouseY;
//     double targetAngle;
//     public double dx;
//     public double dy;
//     public double screenHeight = gp.screenHeight;
//     public double screenWidth = gp.screenWidth;
//     public Projectile(GamePanel gp) {
//         super(gp);
//         gp.addMouseMotionListener(this);
//     }

//     public void set(int worldX, int worldY, boolean alive, Entity user) {
//         this.worldX = worldX;
//         this.worldY = worldY;
//         this.alive = alive;
//         this.user = user;
//         this.life = this.maxLife;
  
        
//         calculateTargetAngle();
//     }
    
//     private void calculateTargetAngle() {
//         double dx = mouseX - screenWidth/2;
//         double dy = mouseY - screenHeight/2;
//         targetAngle = Math.atan2(dy, dx);
//     }

//     public void update() {
        
//         if (alive) {
//             worldX += speed * Math.cos(targetAngle);
//             worldY += speed * Math.sin(targetAngle);
        
//         if (user == gp.player) {
//             int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
//             if (monsterIndex != 999) {
//                 gp.player.damageMonster(monsterIndex, attack);
//                 alive = false; // projectile alive is false
//             }
//         }
//         if (user != gp.player) {
//             boolean contactPlayer = gp.cChecker.checkPlayer(this);
//             if (!gp.player.invincible && contactPlayer) {
//                 damagePlayer(attack);
//                 alive = false;
//             }
//         }
//         System.out.println("Current Position: X = " + mouseX + ", Y =" + mouseY);
//         System.out.println("WORLDPP Position: X = " + worldX + ", Y =" + worldY);
//         System.out.println("TargetAngle: "+targetAngle);
//         // Update the projectile position based on the mouse position
        
//         // worldX += speed * Math.cos(Math.atan2(mouseY - worldY, mouseX - worldX));
//         // worldY += speed * Math.sin(Math.atan2(mouseY - worldY, mouseX - worldX));
    
        
//         spriteCounter++;
//         if (spriteCounter > 12) {
//             if (spriteCounter == 1) {
//                 spriteNum = 2;
//             } else if (spriteCounter == 2) {
//                 spriteNum = 1;
//             }
//             spriteCounter = 0;
//         }
//     }
//     }

//     @Override
//     public void mouseDragged(MouseEvent e) {
//         // mouseX = e.getX();
//         // mouseY = e.getY();
//     }
//     // public void mouseMoved(MouseEvent e) {
//     //     // Update the mouse position
//     //     mouseX = e.getXOnScreen();
//     //     mouseY = e.getYOnScreen();

//     //     // Calculate the angle based on the current mouse position
        
//     // }
//     public void nothing(double angle){
        
//     }
//     public void mouseMoved(MouseEvent e) {
//         // Update the mouse position
//         mouseX = e.getX();
//         mouseY = e.getY();
       
//         // set(worldX, worldY, alive, user);
//         // Pass the correct mouse position to the set() method
//         // set(worldX, worldY, alive, user);
    
//         // Calculate the angle based on the current mouse position
//         // targetAngle = Math.atan2(mouseY - worldY, mouseX - worldX)*180/Math.PI;
//     }

//     public boolean haveResource(Entity user) {
//         boolean haveResource = false;
//         return haveResource;
//     }

//     public void subtractResource(Entity user) {
//     }

//     // 768x576 pixels
// }
package entity;

import main.GamePanel;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class Projectile extends Entity implements MouseMotionListener {
    Entity user;
    int mouseX;
    int mouseY;
    double targetAngle;
    public double dx;
    public double dy;
    public double screenHeight = gp.screenHeight;
    public double screenWidth = gp.screenWidth;
    public double shotAvailableCounter;
    public Projectile(GamePanel gp) {
        super(gp);
        gp.addMouseMotionListener(this);
    }

    public void set(int worldX, int worldY, Entity user) {
        this.worldX = worldX;
        this.worldY = worldY;
        // this.alive = alive;
        this.user = user;
        this.life = this.maxLife;

        calculateTargetAngle();
    }

    private void calculateTargetAngle() {
        double dx = mouseX - screenWidth / 2;
        double dy = mouseY - screenHeight / 2;
        targetAngle = Math.atan2(dy, dx);
    }
    public void update() {
            
            worldX += speed * Math.cos(targetAngle);
            worldY += speed * Math.sin(targetAngle);

            if (user == gp.player) {
                int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
                if (monsterIndex != 999) {
                    gp.player.damageMonster(monsterIndex, attack);
                    alive = false; // projectile alive is false
                }
            }
            if (user != gp.player) {
                boolean contactPlayer = gp.cChecker.checkPlayer(this);
                if (!gp.player.invincible && contactPlayer) {
                    damagePlayer(attack);
                    alive = false;
                }
            }
            life--;
            System.out.println("Current Position: X = " + mouseX + ", Y =" + mouseY);
            System.out.println("WORLDPP Position: X = " + worldX + ", Y =" + worldY);
            System.out.println("TargetAngle: " + targetAngle);

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
    
    

    @Override
    public void mouseDragged(MouseEvent e) {
        // mouseX = e.getX();
        // mouseY = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public boolean haveResource(Entity user) {
        boolean haveResource = false;
        return haveResource;
    }

    public void subtractResource(Entity user) {
    }
}
