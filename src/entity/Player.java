package entity;

import main.GamePanel;
import main.KeyHandler;
import main.MouseHandler;
import java.awt.event.MouseMotionListener;

import object.OBJ_Arrow;
import object.OBJ_Fireball;
import object.OBJ_Getsuga;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_KnifeThrow;
import object.OBJ_MageBlast;
import object.OBJ_Rock;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class Player extends Entity implements Cloneable{
    
    KeyHandler keyH;
    MouseHandler mouseH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    public boolean attackCanceled = false;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 39;
    public int playerClass;
    public Random rand = new Random();
    public Player(GamePanel gp, KeyHandler keyH,MouseHandler mouseH){
        super(gp);
        
        this.keyH = keyH;
        this.mouseH = mouseH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        // solidArea = new Rectangle(8, 16 , 24, 24);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 24;

        //ATTACK AREA
        attackArea = new Rectangle(0,0,36,36);

        //height bottom
        //width top
        // x = right
    }
    public void setPlayerDefaultLocation(){
        worldX = gp.tileSize * 26;
        worldY = gp.tileSize * 23;
    }
    public void setPlayerClass(int playerClass){
        this.playerClass = playerClass;

        setPlayerDefaultLocation();
        level = 1;
        speed = 20;
        exp = 0;
        life = 10;
        nextLevelExp = 5;
        coin = 0;
        direction = "down";
        gp.gwapoko = true;
        if(this.playerClass == 1){
            setDefaultValuesForKnight();
        }
        if(this.playerClass == 2){
            setDefaultValuesForAssassin();
        }
        if(this.playerClass == 3){
            setDefaultValuesForMage();
        }
        
    }
    public void setDefaultValuesForMage(){

        maxLife = 10;
        life = maxLife;
        strength = 1;
        dexterity = 1;
        maxMana = 200;
        mana = maxMana;
        rateOfFire = 10;
        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        projectile = new OBJ_MageBlast(gp);
        // projectile = new OBJ_Getsuga(gp);
        // projectile = new OBJ_Arrow(gp);
        // projectile = new OBJ_Rock(gp);
        attack = getAttack();
        defense = getDefense();
        projectileDamage = getProjectileDamage();
        setItems();
        getPlayerImageForKnight();
        getPlayerAttackImageForKnight();
    }
    public void setDefaultValuesForKnight(){
        
        // worldX = gp.tileSize * 8;
        // worldY = gp.tileSize * 6;
        
        
        // directionformoving = "hasmoveddown";
        
        //player life status
        
        maxLife = 10;
        life = maxLife;
        strength = 1;
        dexterity = 1;
        maxMana = 200;
        mana = maxMana;
        rateOfFire = 10;
        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        // projectile = new OBJ_Fireball(gp);
        // projectile = new OBJ_Getsuga(gp);
        projectile = new OBJ_Arrow(gp);
        // projectile = new OBJ_Rock(gp);
        attack = getAttack();
        defense = getDefense();
        projectileDamage = getProjectileDamage();
        setItems();
        getPlayerImageForKnight();
        getPlayerAttackImageForKnight();
    }
    public void getPlayerImageForKnight(){
        left1 = setup("/pics/player/swordsman/swordmanleft1", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/player/swordsman/swordmanleft2", gp.tileSize, gp.tileSize);
        left3 = setup("/pics/player/swordsman/swordmanleft3", gp.tileSize, gp.tileSize);
        left4 = setup("/pics/player/swordsman/swordmanleft4", gp.tileSize, gp.tileSize);
        left5 = setup("/pics/player/swordsman/swordmanleft5", gp.tileSize, gp.tileSize);
        
        right1 = setup("/pics/player/swordsman/swordmanright1", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/player/swordsman/swordmanright2", gp.tileSize, gp.tileSize);
        right3 = setup("/pics/player/swordsman/swordmanright3", gp.tileSize, gp.tileSize);
        right4 = setup("/pics/player/swordsman/swordmanright4", gp.tileSize, gp.tileSize);
        right5 = setup("/pics/player/swordsman/swordmanright5", gp.tileSize, gp.tileSize);

        up1 = setup("/pics/player/swordsman/swordmanup1", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/player/swordsman/swordmanup2", gp.tileSize, gp.tileSize);
        up3 = setup("/pics/player/swordsman/swordmanup3", gp.tileSize, gp.tileSize);
        up4 = setup("/pics/player/swordsman/swordmanup4", gp.tileSize, gp.tileSize);
        up5 = setup("/pics/player/swordsman/swordmanup5", gp.tileSize, gp.tileSize);

        down1 = setup("/pics/player/swordsman/swordmandown1", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/player/swordsman/swordmandown2", gp.tileSize, gp.tileSize);
        down3 = setup("/pics/player/swordsman/swordmandown3", gp.tileSize, gp.tileSize);
        down4 = setup("/pics/player/swordsman/swordmandown4", gp.tileSize, gp.tileSize);
        down5 = setup("/pics/player/swordsman/swordmandown5", gp.tileSize, gp.tileSize);
        
    }
    public void getPlayerAttackImageForKnight(){
        // attackRight1 = setup("/pics/player/gokuattack00", gp.tileSize, gp.tileSize);
        // attackRight2 = setup("/pics/player/gokuattack01", gp.tileSize, gp.tileSize);

        attackRight1 = setup("/pics/player/swordsman/swordmanattackright1", gp.tileSize, gp.tileSize);
        attackRight2 = setup("/pics/player/swordsman/swordmanattackright2", gp.tileSize, gp.tileSize);
        attackRight3 = setup("/pics/player/swordsman/swordmanattackright3", gp.tileSize, gp.tileSize);
        attackRight4 = setup("/pics/player/swordsman/swordmanattackright4", gp.tileSize, gp.tileSize);

        attackLeft1 = setup("/pics/player/swordsman/swordmanattackleft1", gp.tileSize, gp.tileSize);
        attackLeft2 = setup("/pics/player/swordsman/swordmanattackleft2", gp.tileSize, gp.tileSize);
        attackLeft3 = setup("/pics/player/swordsman/swordmanattackleft3", gp.tileSize, gp.tileSize);
        attackLeft4 = setup("/pics/player/swordsman/swordmanattackleft4", gp.tileSize, gp.tileSize);

        attackUp1 = setup("/pics/player/swordsman/swordmanattackup1", gp.tileSize, gp.tileSize);
        attackUp2 = setup("/pics/player/swordsman/swordmanattackup2", gp.tileSize, gp.tileSize);
        attackUp3 = setup("/pics/player/swordsman/swordmanattackup3", gp.tileSize, gp.tileSize);
        attackUp4 = setup("/pics/player/swordsman/swordmanattackup4", gp.tileSize, gp.tileSize);

        attackDown1 = setup("/pics/player/swordsman/swordmanattackdown1", gp.tileSize, gp.tileSize);
        attackDown2 = setup("/pics/player/swordsman/swordmanattackdown2", gp.tileSize, gp.tileSize);
        attackDown3 = setup("/pics/player/swordsman/swordmanattackdown3", gp.tileSize, gp.tileSize);
        attackDown4 = setup("/pics/player/swordsman/swordmanattackdown4", gp.tileSize, gp.tileSize);
        
        //

        attackupRight1 = setup("/pics/player/swordsman/swordmanattackright1", gp.tileSize, gp.tileSize);
        attackupRight2 = setup("/pics/player/swordsman/swordmanattackright2", gp.tileSize, gp.tileSize);
        attackupRight3 = setup("/pics/player/swordsman/swordmanattackright3", gp.tileSize, gp.tileSize);
        attackupRight4 = setup("/pics/player/swordsman/swordmanattackright4", gp.tileSize, gp.tileSize);

        attackupLeft1 = setup("/pics/player/swordsman/swordmanattackleft1", gp.tileSize, gp.tileSize);
        attackupLeft2 = setup("/pics/player/swordsman/swordmanattackleft2", gp.tileSize, gp.tileSize);
        attackupLeft3 = setup("/pics/player/swordsman/swordmanattackleft3", gp.tileSize, gp.tileSize);
        attackupLeft4 = setup("/pics/player/swordsman/swordmanattackleft4", gp.tileSize, gp.tileSize);

        attackdownRight1 = setup("/pics/player/swordsman/swordmanattackright1", gp.tileSize, gp.tileSize);
        attackdownRight2 = setup("/pics/player/swordsman/swordmanattackright2", gp.tileSize, gp.tileSize);
        attackdownRight3 = setup("/pics/player/swordsman/swordmanattackright3", gp.tileSize, gp.tileSize);
        attackdownRight4 = setup("/pics/player/swordsman/swordmanattackright4", gp.tileSize, gp.tileSize);

        attackdownLeft1 = setup("/pics/player/swordsman/swordmanattackleft1", gp.tileSize, gp.tileSize);
        attackdownLeft2 = setup("/pics/player/swordsman/swordmanattackleft2", gp.tileSize, gp.tileSize);
        attackdownLeft3 = setup("/pics/player/swordsman/swordmanattackleft3", gp.tileSize, gp.tileSize);
        attackdownLeft4 = setup("/pics/player/swordsman/swordmanattackleft4", gp.tileSize, gp.tileSize);
    }

    public void setDefaultValuesForAssassin(){
        
        // worldX = gp.tileSize * 8;
        // worldY = gp.tileSize * 6;
        
        maxLife = 1000;
        life = maxLife;
        strength = 50;
        dexterity = 50;
        maxMana = 1000;
        mana = maxMana;
        rateOfFire = 10;
        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        // projectile = new OBJ_Fireball(gp);
        // projectile = new OBJ_Getsuga(gp);
        projectile = new OBJ_KnifeThrow(gp);
        // projectile = new OBJ_Rock(gp);
        attack = getAttack();
        defense = getDefense();
        projectileDamage = getProjectileDamage();
        setItems();
        getPlayerImageForKnight();
        getPlayerAttackImageForKnight();
    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new OBJ_Key(gp));
        
    }
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue*10;
    }
    public int getProjectileDamage(){
        return strength+dexterity*(int)(currentWeapon.attackValue*0.1);
    }
    public int getDefense(){
        return defense = dexterity * currentShield.defenseValue;
    }
    public void getPlayerImage() {
        
        // up1 = setup("/pics/player/boy_up_1", gp.tileSize, gp.tileSize);
        // up2 = setup("/pics/player/boy_up_2", gp.tileSize, gp.tileSize);
        // upleft1 = setup("/pics/player/boy_left_1", gp.tileSize, gp.tileSize);
        // upleft2 = setup("/pics/player/boy_left_2", gp.tileSize, gp.tileSize);
        // upright1 = setup("/pics/player/boy_right_1", gp.tileSize, gp.tileSize);
        // upright2 = setup("/pics/player/boy_right_2", gp.tileSize, gp.tileSize);

        // down1 = setup("/pics/player/boy_down_1", gp.tileSize, gp.tileSize);
        // down2 = setup("/pics/player/boy_down_2", gp.tileSize, gp.tileSize);

        // downleft1 = setup("/pics/player/boy_left_1", gp.tileSize, gp.tileSize);
        // downleft2 = setup("/pics/player/boy_left_2", gp.tileSize, gp.tileSize);
        // downright1 = setup("/pics/player/boy_right_1", gp.tileSize, gp.tileSize);
        // downright2 = setup("/pics/player/boy_right_2", gp.tileSize, gp.tileSize);

        // left1 = setup("/pics/player/boy_left_1", gp.tileSize, gp.tileSize);
        // left2 = setup("/pics/player/boy_left_2", gp.tileSize, gp.tileSize);
        // right1 = setup("/pics/player/boy_right_1", gp.tileSize, gp.tileSize);
        // right2 = setup("/pics/player/boy_right_2", gp.tileSize, gp.tileSize);
        
        left1 = setup("/pics/player/walking/lwa1", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/player/walking/lwa2", gp.tileSize, gp.tileSize);
        left3 = setup("/pics/player/walking/lwa3", gp.tileSize, gp.tileSize);
        left4 = setup("/pics/player/walking/lwa4", gp.tileSize, gp.tileSize);
        left5 = setup("/pics/player/walking/lwa5", gp.tileSize, gp.tileSize);

        right1 = setup("/pics/player/walking/wa1", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/player/walking/wa2", gp.tileSize, gp.tileSize);
        right3 = setup("/pics/player/walking/wa3", gp.tileSize, gp.tileSize);
        right4 = setup("/pics/player/walking/wa4", gp.tileSize, gp.tileSize);
        right5 = setup("/pics/player/walking/wa5", gp.tileSize, gp.tileSize);
        
        
    }
    public void getPlayerAttackImage(){
        if(currentWeapon.type == type_sword){
            attackUp1 = setup("/pics/playerattack/boy_attack_up_1", gp.tileSize, gp.tileSize*2);
            attackUp2 = setup("/pics/playerattack/boy_attack_up_2", gp.tileSize, gp.tileSize*2);
            attackDown1 = setup("/pics/playerattack/boy_attack_down_1", gp.tileSize, gp.tileSize*2);
            attackDown2 = setup("/pics/playerattack/boy_attack_down_2", gp.tileSize, gp.tileSize*2);
            attackLeft1 = setup("/pics/playerattack/boy_attack_left_1", gp.tileSize*2, gp.tileSize);
            attackLeft2 = setup("/pics/playerattack/boy_attack_left_2", gp.tileSize*2, gp.tileSize);
            attackRight1 = setup("/pics/playerattack/boy_attack_right_1", gp.tileSize*2, gp.tileSize);
            attackRight2 = setup("/pics/playerattack/boy_attack_right_2", gp.tileSize*2, gp.tileSize);
        }
        if(currentWeapon.type == type_axe){
            attackUp1 = setup("/pics/playerattack/boy_axe_up_1", gp.tileSize, gp.tileSize*2);
            attackUp2 = setup("/pics/playerattack/boy_axe_up_2", gp.tileSize, gp.tileSize*2);
            attackDown1 = setup("/pics/playerattack/boy_axe_down_1", gp.tileSize, gp.tileSize*2);
            attackDown2 = setup("/pics/playerattack/boy_axe_down_2", gp.tileSize, gp.tileSize*2);
            attackLeft1 = setup("/pics/playerattack/boy_axe_left_1", gp.tileSize*2, gp.tileSize);
            attackLeft2 = setup("/pics/playerattack/boy_axe_left_2", gp.tileSize*2, gp.tileSize);
            attackRight1 = setup("/pics/playerattack/boy_axe_right_1", gp.tileSize*2, gp.tileSize);
            attackRight2 = setup("/pics/playerattack/boy_axe_right_2", gp.tileSize*2, gp.tileSize);
        }
        
    }
    public void update(){
        if(attacking==true){
            attacking();
            keyH.enterPressed = false;
        }
        else if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true || keyH.enterPressed == true && attacking == false){
            if(keyH.upPressed==true){
              if(keyH.leftPressed==true){
                  direction = "upleft";
              }else if(keyH.rightPressed==true){
                  direction = "upright";
              }
              else{direction ="up";}
          
          }else if(keyH.downPressed==true){
              if(keyH.leftPressed == true){
                  direction = "downleft";
              }else if(keyH.rightPressed == true){
                  direction = "downright";
              }
              else{direction="down";}
              
          }else if(keyH.leftPressed==true){ 
              if(keyH.upPressed==true){
                  direction = "upleft";
              }else if(keyH.downPressed==true){
                  direction = "downleft";
              }
              else{direction="left";}
          
          }else if(keyH.rightPressed==true){
              if(keyH.upPressed== true){
                  direction ="upright";
              }else if(keyH.downPressed == true){
                  direction ="downright";
              }
              else{direction = "right";}
            }
            // System.out.println("Speed: "+speed);
        // tig check sa collison
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //check objection collision
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);

        //check npc collision
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        //check monster collision
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);

        //check event 
        gp.eHandler.checkEvent();

        
        // if collision is false, player can move
        //para lihod
        if(collisionOn == false && keyH.enterPressed == false){
            switch(direction){
                case "up":worldY-=speed;break;
                case "down":worldY+=speed;break;
                case "left":worldX-=speed;break;
                case "right":worldX+=speed;break;
                case "upleft":
                    worldY-=(speed*0.7);
                    worldX-=(speed*0.7);
                    break;
                case "upright":
                    worldY-=(speed*0.7);
                    worldX+=(speed*0.7);
                    break;
                case "downleft":
                    worldY+=(speed*0.7);
                    worldX-=(speed*0.7);
                    break;
                case "downright":
                    worldY+=(speed*0.7);
                    worldX+=(speed*0.7);
            //     case "upleft":
            //     worldY-=speed;
            //     worldX-=speed;
            //     break;
            // case "upright":
            //     worldY-=speed;
            //     worldX+=speed;
            //     break;
            // case "downleft":
            //     worldY+=speed;
            //     worldX-=speed;
            //     break;
            // case "downright":
            //     worldY+=speed;
            //     worldX+=speed;
                
            }
        }
        
        if(keyH.enterPressed == true && attackCanceled == false){

            gp.playSE(7);
            attacking = true;
            spriteCounter = 0;
        } else if( gp.rightClicked==true && attackCanceled == false){
            gp.playSE(7);
            attacking = true;
            spriteCounter = 0;
        }
        
        attackCanceled = false;
        gp.keyH.enterPressed =false;
        spriteCounter++;
        if(spriteCounter>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 3;
            }
            else if(spriteNum == 3){
                spriteNum = 4;
            }
            else if(spriteNum == 4){
                spriteNum = 5;
            }
            else if(spriteNum == 5){
                spriteNum = 1;
            }
            spriteCounter=0;
        }
        }
        
        // if(gp.keyH.shotKeyPressed == true && shotAvailableCounter == 30 && projectile.haveResource(this) == true){
        //     //set default coorindatesd
        //     // projectile.set(worldX, worldY, direction, true, this);
        //     projectile.set(worldX, worldY, this);

        //     //subtract source
        //     projectile.subtractResource(this);

        //     // add it to the list
        //     gp.projectileList.add(projectile);
        //     shotAvailableCounter = 0;
        //     gp.playSE(10);
        // }
        // else 
        // if(mouseH.leftClicked == true  && shotAvailableCounter == 30 && projectile.haveResource(this) == true){
        //     //set default coorindatesd
        //     // projectile.set(worldX, worldY, direction, true, this);
        //     projectile.set(worldX, worldY,true, this);
        //     //subtract source
        //     projectile.subtractResource(this);

        //     // add it to the list
        //     gp.projectileList.add(projectile);
        //     shotAvailableCounter = 0;
        //     gp.playSE(10);
        // }
        if (gp.leftClicked && shotAvailableCounter == rateOfFire && projectile.haveResource(this)) {
            // Cloning the projectile
            Projectile clonedProjectile = null;
            try {
                clonedProjectile = (Projectile) projectile.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        
            if (clonedProjectile != null) {
                clonedProjectile.set(worldX, worldY, true, this);
                projectile.subtractResource(this);
                gp.projectileList.add(clonedProjectile);
                shotAvailableCounter = 0;
        
                // Play sound effect
                // gp.playSE(10);
            }
        }
        
        //this needs to be outside of key if statement
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter >60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(shotAvailableCounter < rateOfFire){
            shotAvailableCounter++;
        }
        if(life>maxLife){
            life = maxLife;
        }if(life<0){
            life = 0;
        }

        if(mana>maxMana){
            mana = maxMana;
        }
      
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Player clonedObject = (Player) super.clone();
        
        // Now you can handle specific cloning logic for your class if needed
        
        // For example, if projectile is also cloneable
        if (this.projectile != null && this.projectile instanceof Cloneable) {
            clonedObject.projectile = (Projectile) this.projectile.clone();
        }

        return clonedObject;
    }

    public void attacking(){
        spriteCounter++;
        if(spriteCounter<=5){
            spriteNum =1;
        }
        if(spriteCounter > 5 && spriteCounter <=10){
            int random = rand.nextInt(2);
            spriteNum = 2+random;
            //save the current worldX, WorldY
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            // adjust player's worldx/y for the attackarea
            switch(direction){
                case "up": worldY -= attackArea.height;break;
                case "down": worldY += attackArea.height;break;
                case "left": worldX -= attackArea.width;break;
                case "right": worldX += attackArea.width;break;

            }

            //attackarea becomes solid Area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            //check monster collision with the updated worldX, worldY and solid Area
            int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);
            damageMonster(monsterIndex, attack);

            //after checing collision, restore the original state
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spriteCounter >25){
            spriteNum =1;
            spriteCounter = 0;
            attacking = false;
        }

    }
    public void pickUpObject(int i){

        if(i!=999){
            //pick up only items
            if(gp.obj[i].type == type_pickupOnly){
                gp.obj[i].use(this);
                gp.obj[i] = null;
            }

            //invetory items
            else{
                String text;
                if(inventory.size()!=maxInventorySize&&gp.obj[i].obtainable==true){
                    inventory.add(gp.obj[i]);
                gp.playSE(1);
                text = "Got a " + gp.obj[i].name + "!";
                gp.obj[i] = null;    
                }
            }
            // else if(gp.obj[i].obtainable == false){
            //     text = "Item cannot be obtained!";
            // }
            // else{
            //     text = "You cannot carry any more!";
            // }
            // gp.ui.addMessage(text);
            
            }
        }
        

    
    public void interactNPC(int i){
        if(gp.keyH.enterPressed == true){
            if(i!=999){
                attackCanceled = true;
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
            
        }
    }
    public void contactMonster(int i){
        if(i!=999){
            if(invincible == false && gp.monster[i].dying == false){
                gp.playSE(6);
                int damage = gp.monster[i].attack -defense;
                if(damage<0){
                    damage = 0;
                }
                life-=1;
                invincible = true;
            }
            
        }
    }    
    public void damageMonster(int i, int attack) {
        
		if(i != 999) {
			
			if(gp.monster[i].invincible == false) {
				
                gp.playSE(10);

                int damage = attack - gp.monster[i].defense;
                if(damage<0){
                    damage = 0;
                }
                
                gp.ui.addMessage(damage+" damage!");
				gp.monster[i].life -= damage;
				gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();

                // System.out.println("Monster life: "+gp.monster[i].life);
				if(gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
                    gp.ui.addMessage("Killed the " + gp.monster[i].name +"!");
                    gp.ui.addMessage("Exp " + gp.monster[i].exp +" earned!");
                    exp+=gp.monster[i].exp;
                    checkLevelUp();
				}
			}
		}
	}
    // public void checkLevelUp(){
    //     if(exp>=nextLevelExp){
    //         level++;
    //         nextLevelExp = nextLevelExp * 2;
    //         maxLife+=2;
    //         strength++;
    //         dexterity++;
    //         attack = getAttack();
    //         defense = getDefense();
    //         gp.playSE(8);
    //         gp.gameState = gp.dialogueState;
    //         gp.ui.currentDialogue = "You are now level "+level+"!\n"
    //                                 +"Your  is stronger!";
    //         exp = 0;
    //     }
    // }
    public void checkLevelUp(){
        if(exp >= nextLevelExp){
            //adds the excess exp
            exp -= nextLevelExp;

            level++;
            nextLevelExp = nextLevelExp * 2;
            maxLife += 2;
            maxMana = (int)(maxMana*1.1);
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            projectileDamage = getProjectileDamage();
            gp.playSE(8);
            gp.ui.addMessage("Level up: "+level);
        }
    }
    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexOnSlot();
        if(itemIndex < inventory.size()){
            Entity selectedItem= inventory.get(itemIndex);
            if(selectedItem.type == type_sword||selectedItem.type==type_axe){
                currentWeapon = selectedItem;
                attack = getAttack();
                getPlayerAttackImage();
            }
            if(selectedItem.type == type_shield){
                currentShield = selectedItem;
                defense = getDefense();
            }
            if(selectedItem.type == type_consumable){
                selectedItem.use(this);
                inventory.remove(itemIndex);
            }
        }

    }
    
    public int searchItemInInventory(String itemName){
        int itemIndex = 999;

        for (int i = 0;i<inventory.size();i++){
            if(inventory.get(i).name.equals(itemName)){
                itemIndex = 1;
                break;
            }
        }
        return itemIndex; 
    }
    public boolean canObtainItem(Entity item){
        boolean canObtain  = false;
        if(item.stackable == true){
            int index = searchItemInInventory(item.name);
            
            if(index!=999){
                inventory.get(index).amount++;
                canObtain =true;
            }else{//that means it is a new item
                if(inventory.size() != maxInventorySize){
                    inventory.add(item);
                    canObtain = true;
                }
            }
        }else{//meaning item is not stackable
            if(inventory.size() != maxInventorySize){
                inventory.add(item);
                canObtain = true;
            }
        }
        return canObtain;
    }
    public void draw(Graphics2D g2){

        // g2.setColor(Color.white); 
        // g2.fillRect(x,y,gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        
    
        
        switch(direction){
            case "up":
            if(attacking ==false){
                if(spriteNum ==1){image = up1;}
                if(spriteNum==2){image =up2;}
                if(spriteNum==3){image =up3;}
                if(spriteNum==4){image =up4;}
                if(spriteNum==5){image =up5;}
                // if(spriteNum==6){image =left6;}
                // if(spriteNum==7){image =left7;}
            }
                // if(attacking ==false && gp.mouseH.getX()>=0 && gp.mouseH.getX()<=gp.screenWidth/2){
                //     if(spriteNum ==1){image = up1;}
                //     if(spriteNum==2){image =up2;}
                //     if(spriteNum==3){image =up3;}
                //     if(spriteNum==4){image =up4;}
                //     if(spriteNum==5){image =up5;}
                //     // if(spriteNum==6){image =left6;}
                //     // if(spriteNum==7){image =left7;}
                // }
                // if(attacking ==false && gp.mouseH.getX()>=gp.screenWidth/2 && gp.mouseH.getX()<=gp.screenWidth){
                //     if(spriteNum ==1){image = right1;}
                //     if(spriteNum==2){image =right2;}
                //     if(spriteNum==3){image =right3;}
                //     if(spriteNum==4){image =right4;}
                //     if(spriteNum==5){image =right5;}
                //     if(spriteNum==6){image =right6;}
                //     if(spriteNum==7){image =right7;}
                // }
                if(attacking == true){
                    tempScreenY = screenY - (int)(gp.tileSize/1.7);
                    if(spriteNum ==1){image = attackUp1;}
                    if(spriteNum==2){image = attackUp2;}
                    if(spriteNum==3){image = attackUp3;}
                    if(spriteNum==4){image = attackUp4;}
                    if(spriteNum==5){image = attackUp4;}
                }
                
                break;
            case "down":
            if(attacking ==false){
                if(spriteNum ==1){image = down1;}
                if(spriteNum==2){image =down2;}
                if(spriteNum==3){image =down3;}
                if(spriteNum==4){image =down4;}
                if(spriteNum==5){image =down5;}
            }
            // if(attacking ==false && gp.mouseH.getX()>=0 && gp.mouseH.getX()<=gp.screenWidth/2){
            //     if(spriteNum ==1){image = left1;}
            //     if(spriteNum==2){image =left2;}
            //     if(spriteNum==3){image =left3;}
            //     if(spriteNum==4){image =left4;}
            //     if(spriteNum==5){image =left5;}
            //     if(spriteNum==6){image =left6;}
            //     if(spriteNum==7){image =left7;}
            // }if(attacking ==false && gp.mouseH.getX()>=gp.screenWidth/2 && gp.mouseH.getX()<=gp.screenWidth){
            //     if(spriteNum ==1){image = right1;}
            //     if(spriteNum==2){image =right2;}
            //     if(spriteNum==3){image =right3;}
            //     if(spriteNum==4){image =right4;}
            //     if(spriteNum==5){image =right5;}
            //     if(spriteNum==6){image =right6;}
            //     if(spriteNum==7){image =right7;}
            // }
                if(attacking == true){
                    tempScreenY = screenY + (int)(gp.tileSize/1.7);
                    if(spriteNum ==1){image = attackDown1;}
                    if(spriteNum==2){image = attackDown2;}
                    if(spriteNum==3){image = attackDown2;}
                    if(spriteNum==4){image = attackDown3;}
                    if(spriteNum==5){image = attackDown4;}

                }
                break;
            case "left":
            if(attacking ==false){
                if(spriteNum ==1){image = left1;}
                if(spriteNum==2){image =left2;}
                if(spriteNum==3){image =left3;}
                if(spriteNum==4){image =left4;}
                if(spriteNum==5){image =left5;}
            }
                if(attacking == true){
                    tempScreenX = screenX - (int)(gp.tileSize/1.7);
                    if(spriteNum ==1){image = attackLeft1;}
                    if(spriteNum==2){image = attackLeft2;}
                    if(spriteNum==3){image = attackLeft3;}
                    if(spriteNum==4){image = attackLeft4;}
                    if(spriteNum==5){image = attackLeft4;}
                }
                break;
            case "right":
            if(attacking ==false){
                if(spriteNum ==1){image = right1;}
                if(spriteNum==2){image =right2;}
                if(spriteNum==3){image =right3;}
                if(spriteNum==4){image =right4;}
                if(spriteNum==5){image =right5;}
            }
                if(attacking == true){
                    tempScreenX = screenX + (int)(gp.tileSize/1.7);
                    if(spriteNum ==1){image = attackRight1;}
                    if(spriteNum==2){image = attackRight2;}
                    if(spriteNum==3){image = attackRight3;}
                    if(spriteNum==4){image = attackRight4;}
                    if(spriteNum==5){image = attackRight4;}
                }
                break;

            //8 DIRECTION
            case "upright":
            if(attacking ==false){
                if(spriteNum ==1){image = right1;}
                if(spriteNum==2){image =right2;}
                if(spriteNum==3){image =right3;}
                if(spriteNum==4){image =right4;}
                if(spriteNum==5){image =right5;}
            }if(attacking == true){
                tempScreenX = screenX + gp.tileSize/2;
                tempScreenY = screenY - gp.tileSize/2;
                if(spriteNum ==1){image = attackupRight1;}
                if(spriteNum==2){image = attackupRight2;}
                if(spriteNum==3){image = attackupRight3;}
                if(spriteNum==4){image = attackupRight4;}
                if(spriteNum==5){image = attackupRight4;}
            }

                break;
            case "upleft":
            if(attacking ==false){
                if(spriteNum ==1){image = left1;}
                if(spriteNum==2){image =left2;}
                if(spriteNum==3){image =left3;}
                if(spriteNum==4){image =left4;}
                if(spriteNum==5){image =left5;}
            }if(attacking == true){
                tempScreenX = screenX - gp.tileSize/2;
                tempScreenY = screenY - gp.tileSize/2;
                if(spriteNum ==1){image = attackupLeft1;}
                if(spriteNum==2){image = attackupLeft2;}
                if(spriteNum==3){image = attackupLeft3;}
                if(spriteNum==4){image = attackupLeft4;}
                if(spriteNum==5){image = attackupLeft4;}
            }
                break;
            case "downright":
            if(attacking ==false){
                if(spriteNum ==1){image = right1;}
                if(spriteNum==2){image =right2;}
                if(spriteNum==3){image =right3;}
                if(spriteNum==4){image =right4;}
                if(spriteNum==5){image =right5;}
            }if(attacking == true){
                tempScreenX = screenX + gp.tileSize/2;
                tempScreenY = screenY + gp.tileSize/2;
                if(spriteNum ==1){image = attackdownRight1;}
                if(spriteNum==2){image = attackdownRight2;}
                if(spriteNum==3){image = attackdownRight3;}
                if(spriteNum==4){image = attackdownRight4;}
                if(spriteNum==5){image = attackdownRight4;}
            }
                break;
            case "downleft":
            if(attacking ==false){
                if(spriteNum ==1){image = left1;}
                if(spriteNum==2){image =left2;}
                if(spriteNum==3){image =left3;}
                if(spriteNum==4){image =left4;}
                if(spriteNum==5){image =left5;}
            }if(attacking == true){
                tempScreenX = screenX - gp.tileSize/2;
                tempScreenY = screenY + gp.tileSize/2;
                if(spriteNum ==1){image = attackdownLeft1;}
                if(spriteNum==2){image = attackdownLeft2;}
                if(spriteNum==3){image = attackdownLeft3;}
                if(spriteNum==4){image = attackdownLeft4;}
                if(spriteNum==5){image = attackdownLeft4;}
            }
                break;
        }
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        g2.drawImage(image,tempScreenX,tempScreenY, null);
        //healthbar
        

        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //debug
        // g2.setFont(new Font("Arial", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invicible: "+invincibleCounter, 10, 400);


    }
}
