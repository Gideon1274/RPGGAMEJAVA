package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Rock extends Projectile{
    GamePanel gp;
    public OBJ_Rock(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "Fireball";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();

    }
    public void getImage(){
        up1 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        down1 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        left1 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        right1 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/projectile/rock_down_1", gp.tileSize, gp.tileSize);


    }
    public boolean haveResource(Entity user){
        boolean haveResource = false;
        if(user.ammo >= useCost){
            haveResource = true;
            System.out.println("out of ammo");
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        user.ammo -= useCost;
    }
}
