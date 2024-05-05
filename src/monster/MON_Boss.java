package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Fireball;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Potion_mana;
import object.OBJ_Rock;

public class MON_Boss extends Entity {
         GamePanel gp;

    public MON_Boss(GamePanel gp){
        
        super(gp);
       
        this.gp=gp;

        type = type_monster;
        name = "ACNOLOGIA";
        speed = 10;
        maxLife = 5000;
        life = maxLife;
        attack = 10;
        defense = 100;
        exp = 20;
        projectile = new OBJ_Rock(gp);
        // projectile = new OBJ_Fireball(gp);
        solidArea.x = gp.tileSize;
        solidArea.y = gp.tileSize;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = gp.tileSize*3;
        attackArea.height = gp.tileSize*3;

        getImage();
        getAttackImage();
    }

    public void getImage(){
        up1 = setup("/pics/monster/FINALBOSS/up00", gp.tileSize*4, gp.tileSize*4);
        up2 = setup("/pics/monster/FINALBOSS/up01", gp.tileSize*4, gp.tileSize*4);
        up3 = setup("/pics/monster/FINALBOSS/up02", gp.tileSize*4, gp.tileSize*4);
        up4 = setup("/pics/monster/FINALBOSS/up03", gp.tileSize*4, gp.tileSize*4);

        down1 = setup("/pics/monster/FINALBOSS/down00", gp.tileSize*4, gp.tileSize*4);
        down2 = setup("/pics/monster/FINALBOSS/down01", gp.tileSize*4, gp.tileSize*4);
        down3 = setup("/pics/monster/FINALBOSS/down02", gp.tileSize*4, gp.tileSize*4);
        down4 = setup("/pics/monster/FINALBOSS/down03", gp.tileSize*4, gp.tileSize*4);

        left1 = setup("/pics/monster/FINALBOSS/left00", gp.tileSize*4, gp.tileSize*4);
        left2 = setup("/pics/monster/FINALBOSS/left01", gp.tileSize*4, gp.tileSize*4);
        left3 = setup("/pics/monster/FINALBOSS/left02", gp.tileSize*4, gp.tileSize*4);
        left4 = setup("/pics/monster/FINALBOSS/left03", gp.tileSize*4, gp.tileSize*4);

        right1 = setup("/pics/monster/FINALBOSS/right00", gp.tileSize*4, gp.tileSize*4);
        right2 = setup("/pics/monster/FINALBOSS/right01", gp.tileSize*4, gp.tileSize*4);
        right3 = setup("/pics/monster/FINALBOSS/right02", gp.tileSize*4, gp.tileSize*4);
        right4 = setup("/pics/monster/FINALBOSS/right03", gp.tileSize*4, gp.tileSize*4);

        
        downleft1 = setup("/pics/monster/FINALBOSS/left00", gp.tileSize*4, gp.tileSize*4);
        downleft2 = setup("/pics/monster/FINALBOSS/left01", gp.tileSize*4, gp.tileSize*4);
        downleft3 = setup("/pics/monster/FINALBOSS/left02", gp.tileSize*4, gp.tileSize*4);
        downleft4 = setup("/pics/monster/FINALBOSS/left03", gp.tileSize*4, gp.tileSize*4);

        upleft1 = setup("/pics/monster/FINALBOSS/left00", gp.tileSize*4, gp.tileSize*4);
        upleft2 = setup("/pics/monster/FINALBOSS/left01", gp.tileSize*4, gp.tileSize*4);
        upleft3 = setup("/pics/monster/FINALBOSS/left02", gp.tileSize*4, gp.tileSize*4);
        upleft4 = setup("/pics/monster/FINALBOSS/left03", gp.tileSize*4, gp.tileSize*4);

        downright1 = setup("/pics/monster/FINALBOSS/right00", gp.tileSize*4, gp.tileSize*4);
        downright2 = setup("/pics/monster/FINALBOSS/right01", gp.tileSize*4, gp.tileSize*4);
        downright3 = setup("/pics/monster/FINALBOSS/right02", gp.tileSize*4, gp.tileSize*4);
        downright4 = setup("/pics/monster/FINALBOSS/right03", gp.tileSize*4, gp.tileSize*4);

        upright1 = setup("/pics/monster/FINALBOSS/right00", gp.tileSize*4, gp.tileSize*4);
        upright2 = setup("/pics/monster/FINALBOSS/right01", gp.tileSize*4, gp.tileSize*4);
        upright3 = setup("/pics/monster/FINALBOSS/right02", gp.tileSize*4, gp.tileSize*4);
        upright4 = setup("/pics/monster/FINALBOSS/right03", gp.tileSize*4, gp.tileSize*4);
    }
    public void getAttackImage(){
        attackLeft1 = setup("/pics/monster/FINALBOSS/attackleft01", gp.tileSize*4, gp.tileSize*4);
        attackLeft2 = setup("/pics/monster/FINALBOSS/attackleft00", gp.tileSize*4, gp.tileSize*4);
        attackLeft3 = setup("/pics/monster/FINALBOSS/attackleft01", gp.tileSize*4, gp.tileSize*4);
        attackLeft4 = setup("/pics/monster/FINALBOSS/attackleft00", gp.tileSize*4, gp.tileSize*4);
        
        attackRight1 = setup("/pics/monster/FINALBOSS/attackright00", gp.tileSize*4, gp.tileSize*4);
        attackRight2 = setup("/pics/monster/FINALBOSS/attackright01", gp.tileSize*4, gp.tileSize*4);
        attackRight3 = setup("/pics/monster/FINALBOSS/attackright00", gp.tileSize*4, gp.tileSize*4);
        attackRight4 = setup("/pics/monster/FINALBOSS/attackright01", gp.tileSize*4, gp.tileSize*4);

        attackUp1 = setup("/pics/monster/FINALBOSS/attackup00", gp.tileSize*4, gp.tileSize*4);
        attackUp2 = setup("/pics/monster/FINALBOSS/attackup01", gp.tileSize*4, gp.tileSize*4);
        attackUp3 = setup("/pics/monster/FINALBOSS/attackup00", gp.tileSize*4, gp.tileSize*4);
        attackUp4 = setup("/pics/monster/FINALBOSS/attackup01", gp.tileSize*4, gp.tileSize*4);
        
        attackDown1 = setup("/pics/monster/FINALBOSS/attackdown00", gp.tileSize*4, gp.tileSize*4);
        attackDown2 = setup("/pics/monster/FINALBOSS/attackdown01", gp.tileSize*4, gp.tileSize*4);
        attackDown3 = setup("/pics/monster/FINALBOSS/attackdown01", gp.tileSize*4, gp.tileSize*4);
        attackDown4 = setup("/pics/monster/FINALBOSS/attackdown00", gp.tileSize*4, gp.tileSize*4);

        attackupLeft1 = setup("/pics/monster/FINALBOSS/attackleft00", gp.tileSize*4, gp.tileSize*4);
        attackupLeft2 = setup("/pics/monster/FINALBOSS/attackleft01", gp.tileSize*4, gp.tileSize*4);
        attackupLeft3 = setup("/pics/monster/FINALBOSS/attackleft00", gp.tileSize*4, gp.tileSize*4);
        attackupLeft4 = setup("/pics/monster/FINALBOSS/attackleft01", gp.tileSize*4, gp.tileSize*4);
        
        attackupRight1 = setup("/pics/monster/FINALBOSS/attackright00", gp.tileSize*4, gp.tileSize*4);
        attackupRight2 = setup("/pics/monster/FINALBOSS/attackright01", gp.tileSize*4, gp.tileSize*4);
        attackupRight3 = setup("/pics/monster/FINALBOSS/attackright00", gp.tileSize*4, gp.tileSize*4);
        attackupRight4 = setup("/pics/monster/FINALBOSS/attackright01", gp.tileSize*4, gp.tileSize*4);

        attackdownLeft1 = setup("/pics/monster/FINALBOSS/attackleft00", gp.tileSize*4, gp.tileSize*4);
        attackdownLeft2 = setup("/pics/monster/FINALBOSS/attackleft01", gp.tileSize*4, gp.tileSize*4);
        attackdownLeft3 = setup("/pics/monster/FINALBOSS/attackleft00", gp.tileSize*4, gp.tileSize*4);
        attackdownLeft4 = setup("/pics/monster/FINALBOSS/attackleft01", gp.tileSize*4, gp.tileSize*4);
        
        attackdownRight1 = setup("/pics/monster/FINALBOSS/attackright00", gp.tileSize*4, gp.tileSize*4);
        attackdownRight2 = setup("/pics/monster/FINALBOSS/attackright01", gp.tileSize*4, gp.tileSize*4);
        attackdownRight3 = setup("/pics/monster/FINALBOSS/attackright00", gp.tileSize*4, gp.tileSize*4);
        attackdownRight4 = setup("/pics/monster/FINALBOSS/attackright01", gp.tileSize*4, gp.tileSize*4);
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
            checkAttackOrNot(30, gp.tileSize*10, gp.tileSize*4);
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
        gp.gameState = gp.finalBossDefeated;
        gp.stopMusic();
        gp.playSE(12);

    }
}
