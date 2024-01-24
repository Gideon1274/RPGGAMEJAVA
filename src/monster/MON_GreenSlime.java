package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

public class MON_GreenSlime extends Entity {
         GamePanel gp;

    public MON_GreenSlime(GamePanel gp){
        
        super(gp);
       
        this.gp=gp;

        type = type_monster;
        name = "Green Slime";
        speed = 1;
        maxLife = 6;
        life = maxLife;
        attack = 5;
        defense = 0;
        exp = 6;
        projectile = new OBJ_Rock(gp);

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
        
    }
    public void getImage(){
        up1 = setup("/pics/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
        down1 = setup("/pics/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/pics/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
        right1 = setup("/pics/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
    }
    public void setAction(){
            actionLockCounter++;
    
            if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i<=25){
                direction ="up";
    
            }
            if(i>25 && i<=50){
                direction = "down";
            }
            if(i>50 && i <=75){
                direction = "left";
            }
            if(i>75 &&i<=100){
                direction ="right";
            }
            actionLockCounter = 0;
        }
        // int i = new Random().nextInt(100)+1;
        // if(i>99 && projectile.alive == false && shotAvailableCounter == 30){
        //     projectile.set(worldX, worldY, direction, true, this);
        //     gp.projectileList.add(projectile);
        //     shotAvailableCounter = 0;
        // }
        
    }
    public void damageReaction() {
        actionLockCounter = 0;
        
        switch (gp.player.direction) {
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            default:
        }
    }
    public void checkDrop(){
        //SET DROP RATE
        int i = new Random().nextInt(3)+1;
        // SET MONSTER DROP 
        if(i==1){
            dropItem(new OBJ_Coin_Bronze(gp));
            System.out.println(i);
        }
        if(i==2){
            dropItem(new OBJ_Heart(gp));
            System.out.println(i);
        }
        if(i==3){
            dropItem(new OBJ_ManaCrystal(gp));
            System.out.println(i);
        }
        else{
            System.out.println(i);
        }

    }
}
