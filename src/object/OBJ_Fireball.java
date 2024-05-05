package object;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import entity.Entity;
import entity.Player;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile{
    GamePanel gp;
    Projectile p;
    // double dx = mouseX - screenWidth / 2;
    //     double dy = mouseY - screenHeight / 2;
    //     double angle = Math.atan2(dy, dx);
        double lastAngle;
        public Entity user;
        public int attack;
        
    public OBJ_Fireball(GamePanel gp){
        super(gp);
        this.gp = gp;
        
        name = "Fireball";
        speed = 20;
        maxLife = 200;
        life = maxLife;
        useCost = 1;
        alive = false;
        getImage();
        skillMultiplier = 2;
        // direction = "down";
        type = 10;
        lastAngle = 0;
    }
    public void getImage() {
        // Set imageProjectile1 and imageProjectile2 based on mouse direction
        // down1 = setup("/pics/projectile/fireball_right_1", gp.tileSize, gp.tileSize);
        // down2 = setup("/pics/projectile/fireball_right_2", gp.tileSize, gp.tileSize);   
        // d images based on the calculated angle
        
        down1 = setup("/pics/projectile/fireball_right_", gp.tileSize, gp.tileSize);
        
    }
    
    // Helper method to rotate an image
    private BufferedImage rotateImage(BufferedImage image, double angle) {
        AffineTransform tx = new AffineTransform();
        tx.rotate(angle, image.getWidth() / 2, image.getHeight() / 2);
    
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(image, null);
    }
    
    public boolean haveResource(Entity user){
        boolean haveResource = false;
        if(user.mana >= useCost){
            user.mana-=useCost;
            haveResource = true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        // user.mana -= useCost;
    }
    public void update() {
        double newDx = mouseX - screenWidth / 2;
        double newDy = mouseY - screenHeight / 2;
        double newAngle = Math.atan2(newDy, newDx);

        // Check if the direction has changed
        if (newAngle != lastAngle) {
            down1 = rotateImage(down1, newAngle);

            lastAngle = newAngle; 
        }
        if (user != gp.player) {

            
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            if (monsterIndex != 999) {
                gp.player.damageMonster(monsterIndex, gp.player.projectileDamage*(int)skillMultiplier);
                alive = false; // projectile alive is false
                
            }
        }
        if (user == gp.player) {
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if (!gp.player.invincible && contactPlayer) {
                damagePlayer(attack);
                alive = false;
            }
        }
        if (alive) {
            worldX += speed * Math.cos(newAngle);
            worldY += speed * Math.sin(newAngle);
            life--;
    
            // Check if the projectile's life has expired
            if (life <= 0) {
                alive = false;
            }
        }
    }
    
    
}

// up1 = setup("/pics/projectile/fireball_up_1", gp.tileSize, gp.tileSize);
        // up2 = setup("/pics/projectile/fireball_up_2", gp.tileSize, gp.tileSize);
        // down1 = setup("/pics/projectile/fireball_down_1", gp.tileSize, gp.tileSize);
        // down2 = setup("/pics/projectile/fireball_down_2", gp.tileSize, gp.tileSize);
        // left1 = setup("/pics/projectile/fireball_left_1", gp.tileSize, gp.tileSize);
        // left2 = setup("/pics/projectile/fireball_left_2", gp.tileSize, gp.tileSize);
        // right1 = setup("/pics/projectile/fireball_right_1", gp.tileSize, gp.tileSize);
        // right2 = setup("/pics/projectile/fireball_right_2", gp.tileSize, gp.tileSize);   