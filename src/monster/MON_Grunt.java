package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Potion_mana;
import object.OBJ_Rock;

public class MON_Grunt extends Entity {
         GamePanel gp;

    public MON_Grunt(GamePanel gp){
        
        super(gp);
       
        this.gp=gp;

        type = type_monster;
        name = "Grunt";
        speed = 3;
        maxLife = 100;
        life = maxLife;
        attack = 10;
        defense = 2;
        exp = 20;

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
        up1 = setup("/pics/monster/grunt/up00", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/monster/grunt/up01", gp.tileSize, gp.tileSize);
        up3 = setup("/pics/monster/grunt/up02", gp.tileSize, gp.tileSize);
        up4 = setup("/pics/monster/grunt/up03", gp.tileSize, gp.tileSize);

        down1 = setup("/pics/monster/grunt/down00", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/monster/grunt/down01", gp.tileSize, gp.tileSize);
        down3 = setup("/pics/monster/grunt/down02", gp.tileSize, gp.tileSize);
        down4 = setup("/pics/monster/grunt/down03", gp.tileSize, gp.tileSize);

        left1 = setup("/pics/monster/grunt/left00", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/monster/grunt/left01", gp.tileSize, gp.tileSize);
        left3 = setup("/pics/monster/grunt/left02", gp.tileSize, gp.tileSize);
        left4 = setup("/pics/monster/grunt/left03", gp.tileSize, gp.tileSize);

        right1 = setup("/pics/monster/grunt/right00", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/monster/grunt/right01", gp.tileSize, gp.tileSize);
        right3 = setup("/pics/monster/grunt/right02", gp.tileSize, gp.tileSize);
        right4 = setup("/pics/monster/grunt/right03", gp.tileSize, gp.tileSize);

        
        downleft1 = setup("/pics/monster/grunt/left00", gp.tileSize, gp.tileSize);
        downleft2 = setup("/pics/monster/grunt/left01", gp.tileSize, gp.tileSize);
        downleft3 = setup("/pics/monster/grunt/left02", gp.tileSize, gp.tileSize);
        downleft4 = setup("/pics/monster/grunt/left03", gp.tileSize, gp.tileSize);

        upleft1 = setup("/pics/monster/grunt/left00", gp.tileSize, gp.tileSize);
        upleft2 = setup("/pics/monster/grunt/left01", gp.tileSize, gp.tileSize);
        upleft3 = setup("/pics/monster/grunt/left02", gp.tileSize, gp.tileSize);
        upleft4 = setup("/pics/monster/grunt/left03", gp.tileSize, gp.tileSize);

        downright1 = setup("/pics/monster/grunt/right00", gp.tileSize, gp.tileSize);
        downright2 = setup("/pics/monster/grunt/right01", gp.tileSize, gp.tileSize);
        downright3 = setup("/pics/monster/grunt/right02", gp.tileSize, gp.tileSize);
        downright4 = setup("/pics/monster/grunt/right03", gp.tileSize, gp.tileSize);

        upright1 = setup("/pics/monster/grunt/right00", gp.tileSize, gp.tileSize);
        upright2 = setup("/pics/monster/grunt/right01", gp.tileSize, gp.tileSize);
        upright3 = setup("/pics/monster/grunt/right02", gp.tileSize, gp.tileSize);
        upright4 = setup("/pics/monster/grunt/right03", gp.tileSize, gp.tileSize);
    }
    public void getAttackImage(){
        attackLeft1 = setup("/pics/monster/grunt/attackleft01", gp.tileSize, gp.tileSize);
        attackLeft2 = setup("/pics/monster/grunt/attackleft02", gp.tileSize, gp.tileSize);
        attackLeft3 = setup("/pics/monster/grunt/attackleft03", gp.tileSize, gp.tileSize);
        attackLeft4 = setup("/pics/monster/grunt/attackleft00", gp.tileSize, gp.tileSize);
        
        attackRight1 = setup("/pics/monster/grunt/attackright01", gp.tileSize, gp.tileSize);
        attackRight2 = setup("/pics/monster/grunt/attackright02", gp.tileSize, gp.tileSize);
        attackRight3 = setup("/pics/monster/grunt/attackright03", gp.tileSize, gp.tileSize);
        attackRight4 = setup("/pics/monster/grunt/attackright00", gp.tileSize, gp.tileSize);

        attackUp1 = setup("/pics/monster/grunt/attackup01", gp.tileSize, gp.tileSize);
        attackUp2 = setup("/pics/monster/grunt/attackup02", gp.tileSize, gp.tileSize);
        attackUp3 = setup("/pics/monster/grunt/attackup03", gp.tileSize, gp.tileSize);
        attackUp4 = setup("/pics/monster/grunt/attackup00", gp.tileSize, gp.tileSize);
        
        attackDown1 = setup("/pics/monster/grunt/attackdown00", gp.tileSize, gp.tileSize);
        attackDown2 = setup("/pics/monster/grunt/attackdown01", gp.tileSize, gp.tileSize);
        attackDown3 = setup("/pics/monster/grunt/attackdown02", gp.tileSize, gp.tileSize);
        attackDown4 = setup("/pics/monster/grunt/attackdown03", gp.tileSize, gp.tileSize);

        attackupLeft1 = setup("/pics/monster/grunt/attackleft01", gp.tileSize, gp.tileSize);
        attackupLeft2 = setup("/pics/monster/grunt/attackleft02", gp.tileSize, gp.tileSize);
        attackupLeft3 = setup("/pics/monster/grunt/attackleft03", gp.tileSize, gp.tileSize);
        attackupLeft4 = setup("/pics/monster/grunt/attackleft00", gp.tileSize, gp.tileSize);
        
        attackupRight1 = setup("/pics/monster/grunt/attackright01", gp.tileSize, gp.tileSize);
        attackupRight2 = setup("/pics/monster/grunt/attackright02", gp.tileSize, gp.tileSize);
        attackupRight3 = setup("/pics/monster/grunt/attackright03", gp.tileSize, gp.tileSize);
        attackupRight4 = setup("/pics/monster/grunt/attackright00", gp.tileSize, gp.tileSize);

        attackdownLeft1 = setup("/pics/monster/grunt/attackleft01", gp.tileSize, gp.tileSize);
        attackdownLeft2 = setup("/pics/monster/grunt/attackleft02", gp.tileSize, gp.tileSize);
        attackdownLeft3 = setup("/pics/monster/grunt/attackleft03", gp.tileSize, gp.tileSize);
        attackdownLeft4 = setup("/pics/monster/grunt/attackleft00", gp.tileSize, gp.tileSize);
        
        attackdownRight1 = setup("/pics/monster/grunt/attackright01", gp.tileSize, gp.tileSize);
        attackdownRight2 = setup("/pics/monster/grunt/attackright02", gp.tileSize, gp.tileSize);
        attackdownRight3 = setup("/pics/monster/grunt/attackright03", gp.tileSize, gp.tileSize);
        attackdownRight4 = setup("/pics/monster/grunt/attackright00", gp.tileSize, gp.tileSize);
    }
    public void setAction(){
        
        if(onPath == true){
            //mo hunong kong ang tiledistane kay 20
            checkStopChasingOrNot(gp.player, 15, 100);
            
            searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
        }else{
            
            checkStartChasingOrNot(gp.player, 5, 0);
    
            getRandomDirection();

        }

    
        // int i = new Random().nextInt(100)+1;
        // if(i>99 && projectile.alive == false && shotAvailableCounter == 30){
        //     projectile.set(worldX, worldY, direction, true, this);
        //     gp.projectileList.add(projectile);
        //     shotAvailableCounter = 0;
        // }
        
        //check if its attacks
        if(attacking == false){
            checkAttackOrNot(30, gp.tileSize*4, gp.tileSize);
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
        int i = new Random().nextInt(2)+1;
        // // SET MONSTER DROP 
        if(i==1){
            dropItem(new OBJ_Potion_mana(gp));
            dropItem(new OBJ_Coin_Bronze(gp));
            
        }
        if(i==2){
            dropItem(new OBJ_Potion_Red(gp));
            dropItem(new OBJ_Coin_Bronze(gp));
        }

    }
}
