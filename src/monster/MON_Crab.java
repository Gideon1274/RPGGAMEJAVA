package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Fireball;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

public class MON_Crab extends Entity {
         GamePanel gp;

    public MON_Crab(GamePanel gp){
        
        super(gp);
       
        this.gp=gp;

        type = type_monster;
        name = "Crab";
        speed = 5;
        maxLife = 500;
        life = maxLife;
        attack = 10;
        defense = 20;
        exp = 20;
        projectile = new OBJ_Rock(gp);
        // projectile = new OBJ_Fireball(gp);
        solidArea.x = 4;
        solidArea.y = 4;
        solidArea.width = 40;
        solidArea.height = 44;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 48;
        attackArea.height = 48;

        getImage();
        getAttackImage();
    }

    public void getImage(){
        up1 = setup("/pics/monster/crab/up00", gp.tileSize*2, gp.tileSize*2);
        up2 = setup("/pics/monster/crab/up01", gp.tileSize*2, gp.tileSize*2);
        up3 = setup("/pics/monster/crab/up02", gp.tileSize*2, gp.tileSize*2);
        up4 = setup("/pics/monster/crab/up00", gp.tileSize*2, gp.tileSize*2);

        down1 = setup("/pics/monster/crab/down00", gp.tileSize*2, gp.tileSize*2);
        down2 = setup("/pics/monster/crab/down01", gp.tileSize*2, gp.tileSize*2);
        down3 = setup("/pics/monster/crab/down02", gp.tileSize*2, gp.tileSize*2);
        down4 = setup("/pics/monster/crab/down00", gp.tileSize*2, gp.tileSize*2);

        left1 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        left2 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        left3 = setup("/pics/monster/crab/left02", gp.tileSize*2, gp.tileSize*2);
        left4 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);

        right1 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        right2 = setup("/pics/monster/crab/right01", gp.tileSize*2, gp.tileSize*2);
        right3 = setup("/pics/monster/crab/right02", gp.tileSize*2, gp.tileSize*2);
        right4 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);

        
        downleft1 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        downleft2 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        downleft3 = setup("/pics/monster/crab/left02", gp.tileSize*2, gp.tileSize*2);
        downleft4 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);

        upleft1 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        upleft2 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        upleft3 = setup("/pics/monster/crab/left02", gp.tileSize*2, gp.tileSize*2);
        upleft4 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);

        downright1 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        downright2 = setup("/pics/monster/crab/right01", gp.tileSize*2, gp.tileSize*2);
        downright3 = setup("/pics/monster/crab/right02", gp.tileSize*2, gp.tileSize*2);
        downright4 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);

        upright1 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        upright2 = setup("/pics/monster/crab/right01", gp.tileSize*2, gp.tileSize*2);
        upright3 = setup("/pics/monster/crab/right02", gp.tileSize*2, gp.tileSize*2);
        upright4 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
    }
    public void getAttackImage(){
        attackLeft1 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        attackLeft2 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        attackLeft3 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        attackLeft4 = setup("/pics/monster/crab/left02", gp.tileSize*2, gp.tileSize*2);
        
        attackRight1 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        attackRight2 = setup("/pics/monster/crab/right01", gp.tileSize*2, gp.tileSize*2);
        attackRight3 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        attackRight4 = setup("/pics/monster/crab/right02", gp.tileSize*2, gp.tileSize*2);

        attackUp1 = setup("/pics/monster/crab/up00", gp.tileSize*2, gp.tileSize*2);
        attackUp2 = setup("/pics/monster/crab/up01", gp.tileSize*2, gp.tileSize*2);
        attackUp3 = setup("/pics/monster/crab/up00", gp.tileSize*2, gp.tileSize*2);
        attackUp4 = setup("/pics/monster/crab/up02", gp.tileSize*2, gp.tileSize*2);
        
        attackDown1 = setup("/pics/monster/crab/down00", gp.tileSize*2, gp.tileSize*2);
        attackDown2 = setup("/pics/monster/crab/down01", gp.tileSize*2, gp.tileSize*2);
        attackDown3 = setup("/pics/monster/crab/down01", gp.tileSize*2, gp.tileSize*2);
        attackDown4 = setup("/pics/monster/crab/down02", gp.tileSize*2, gp.tileSize*2);

        attackupLeft1 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        attackupLeft2 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        attackupLeft3 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        attackupLeft4 = setup("/pics/monster/crab/left02", gp.tileSize*2, gp.tileSize*2);
        
        attackupRight1 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        attackupRight2 = setup("/pics/monster/crab/right01", gp.tileSize*2, gp.tileSize*2);
        attackupRight3 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        attackupRight4 = setup("/pics/monster/crab/right02", gp.tileSize*2, gp.tileSize*2);

        attackdownLeft1 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        attackdownLeft2 = setup("/pics/monster/crab/left01", gp.tileSize*2, gp.tileSize*2);
        attackdownLeft3 = setup("/pics/monster/crab/left00", gp.tileSize*2, gp.tileSize*2);
        attackdownLeft4 = setup("/pics/monster/crab/left02", gp.tileSize*2, gp.tileSize*2);
        
        attackdownRight1 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        attackdownRight2 = setup("/pics/monster/crab/right01", gp.tileSize*2, gp.tileSize*2);
        attackdownRight3 = setup("/pics/monster/crab/right00", gp.tileSize*2, gp.tileSize*2);
        attackdownRight4 = setup("/pics/monster/crab/right02", gp.tileSize*2, gp.tileSize*2);
    }
    public void setAction(){
        
        if(onPath == true){
            //mo hunong kong ang tiledistane kay 20
            checkStopChasingOrNot(gp.player, 30, 100);
            
            searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
        }else{
            
            checkStartChasingOrNot(gp.player, 10, 0);
    
            getRandomDirection();

        }

    
        int i = new Random().nextInt(100)+1;
        if(i>99 && projectile.alive == false && shotAvailableCounter == 30){
            projectile.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(projectile);
            shotAvailableCounter = 0;
        }
        
        //check if its attacks
        if(attacking == false){
            checkAttackOrNot(30, gp.tileSize*6, gp.tileSize*2);
        }
        
    }
    public void damageReaction() {
        actionLockCounter = 0;
        
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
        // if(i==1){
        //     dropItem(new OBJ_Coin_Bronze(gp));
            
        // }
        // if(i==2){
        //     dropItem(new OBJ_Coin_Bronze(gp));
        //     dropItem(new OBJ_Coin_Bronze(gp));
        // }
        // if(i==3){
        //     dropItem(new OBJ_Coin_Bronze(gp));
        //     dropItem(new OBJ_Coin_Bronze(gp));
        // }
        dropItem(new OBJ_ManaCrystal(gp));

    }
}
