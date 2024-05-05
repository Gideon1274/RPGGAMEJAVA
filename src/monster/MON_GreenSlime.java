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
        up3 = setup("/pics/monster/slimes/up02", gp.tileSize, gp.tileSize);
        up4 = setup("/pics/monster/slimes/up03", gp.tileSize, gp.tileSize);

        down1 = setup("/pics/monster/slimes/down00", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/monster/slimes/down01", gp.tileSize, gp.tileSize);
        down3 = setup("/pics/monster/slimes/down02", gp.tileSize, gp.tileSize);
        down4 = setup("/pics/monster/slimes/down03", gp.tileSize, gp.tileSize);

        left1 = setup("/pics/monster/slimes/left00", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/monster/slimes/left01", gp.tileSize, gp.tileSize);
        left3 = setup("/pics/monster/slimes/left02", gp.tileSize, gp.tileSize);
        left4 = setup("/pics/monster/slimes/left03", gp.tileSize, gp.tileSize);

        right1 = setup("/pics/monster/slimes/right00", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/monster/slimes/right01", gp.tileSize, gp.tileSize);
        right3 = setup("/pics/monster/slimes/right02", gp.tileSize, gp.tileSize);
        right4 = setup("/pics/monster/slimes/right03", gp.tileSize, gp.tileSize);
        
        downleft1 = setup("/pics/monster/slimes/left00", gp.tileSize, gp.tileSize);
        downleft2 = setup("/pics/monster/slimes/left01", gp.tileSize, gp.tileSize);
        downleft3 = setup("/pics/monster/slimes/left02", gp.tileSize, gp.tileSize);
        downleft4 = setup("/pics/monster/slimes/left03", gp.tileSize, gp.tileSize);

        upleft1 = setup("/pics/monster/slimes/left00", gp.tileSize, gp.tileSize);
        upleft2 = setup("/pics/monster/slimes/left01", gp.tileSize, gp.tileSize);
        upleft3 = setup("/pics/monster/slimes/left02", gp.tileSize, gp.tileSize);
        upleft4 = setup("/pics/monster/slimes/left03", gp.tileSize, gp.tileSize);

        downright1 = setup("/pics/monster/slimes/right00", gp.tileSize, gp.tileSize);
        downright2 = setup("/pics/monster/slimes/right01", gp.tileSize, gp.tileSize);
        downright3 = setup("/pics/monster/slimes/right02", gp.tileSize, gp.tileSize);
        downright4 = setup("/pics/monster/slimes/right03", gp.tileSize, gp.tileSize);

        upright1 = setup("/pics/monster/slimes/right00", gp.tileSize, gp.tileSize);
        upright2 = setup("/pics/monster/slimes/right01", gp.tileSize, gp.tileSize);
        upright3 = setup("/pics/monster/slimes/right02", gp.tileSize, gp.tileSize);
        upright4 = setup("/pics/monster/slimes/right03", gp.tileSize, gp.tileSize);
    }
    
    public void setAction(){
        
        int xDistance = getXdistance(gp.player);
        int yDistance = getYdistance(gp.player);

        int tileDistance = (xDistance + yDistance)/gp.tileSize;
        if(onPath == true){
            
            //mo hunong kong ang tiledistane kay 20
            checkStopChasingOrNot(gp.player, 20, 100);
            
            searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
        }else{
            
            checkStartChasingOrNot(gp.player, 5, 100);
            actionLockCounter++;
    
            getRandomDirection();
        }

    
        // int i = new Random().nextInt(100)+1;
        // if(i>99 && projectile.alive == false && shotAvailableCounter == 30){
        //     projectile.set(worldX, worldY, direction, true, this);
        //     gp.projectileList.add(projectile);
        //     shotAvailableCounter = 0;
        // }
        
        
    }
    public void damageReaction() {
        // actionLockCounter = 0;
        
        // switch (gp.player.direction) {
        //     case "left":
        //         direction = "right";
        //         break;
        //     case "right":
        //         direction = "left";
        //         break;
        //     case "up":
        //         direction = "down";
        //         break;
        //     case "down":
        //         direction = "up";
        //         break;
        //     default:
        // }
        onPath = true;
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
