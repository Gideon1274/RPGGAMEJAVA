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
        maxLife = 100;
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
        up1 = setup("/pics/monster/slimes/up00", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/monster/slimes/up01", gp.tileSize, gp.tileSize);

        down1 = setup("/pics/monster/slimes/down00", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/monster/slimes/down01", gp.tileSize, gp.tileSize);

        left1 = setup("/pics/monster/slimes/left00", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/monster/slimes/left01", gp.tileSize, gp.tileSize);

        right1 = setup("/pics/monster/slimes/right00", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/monster/slimes/right01", gp.tileSize, gp.tileSize);

        
        downleft1 = setup("/pics/monster/slimes/left00", gp.tileSize, gp.tileSize);
        downleft2 = setup("/pics/monster/slimes/left01", gp.tileSize, gp.tileSize);

        upleft1 = setup("/pics/monster/slimes/left00", gp.tileSize, gp.tileSize);
        upleft2 = setup("/pics/monster/slimes/left01", gp.tileSize, gp.tileSize);

        downright1 = setup("/pics/monster/slimes/right00", gp.tileSize, gp.tileSize);
        downright2 = setup("/pics/monster/slimes/right01", gp.tileSize, gp.tileSize);

        upright1 = setup("/pics/monster/slimes/right00", gp.tileSize, gp.tileSize);
        upright2 = setup("/pics/monster/slimes/right01", gp.tileSize, gp.tileSize);
    }
    public void setAction(){
            actionLockCounter++;
    
            if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(128)+1;
            if(i<=16){
                direction ="up";
    
            }
            if(i>16 && i<=32){
                direction = "down";
            }
            if(i>32 && i <=48){
                direction = "left";
            }
            if(i>48 &&i<=64){
                direction ="right";
            }if(i>64 &&i<=80){
                direction ="upright";
            }if(i>80 &&i<=96){
                direction ="upleft";
            }if(i>96 &&i<=112){
                direction ="downright";
            }if(i>112 &&i<=128){
                direction ="downleft";
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
            
        }
        if(i==2){
            dropItem(new OBJ_Coin_Bronze(gp));
            dropItem(new OBJ_Coin_Bronze(gp));
        }
        if(i==3){
            dropItem(new OBJ_Coin_Bronze(gp));
            dropItem(new OBJ_Coin_Bronze(gp));
        }

    }
}
