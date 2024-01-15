package entity;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Player extends Entity{
    
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    public boolean attackCanceled = false;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;

    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
    
        this.keyH = keyH;

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
        // attackArea = new Rectangle(0,0,36,36);


        //height bottom
        //width top
        // x = right
        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
        setItems();
    }
    public void setDefaultValues(){
        
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        // worldX = gp.tileSize * 10;
        // worldY = gp.tileSize * 13;
        speed = 8;
        direction = "down";
        
        //player life status
        level = 1;
        maxLife = 6;
        life = maxLife;
        strength = 1;
        dexterity = 1;
        
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        attack = getAttack();
        defense = getDefense();

    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new OBJ_Key(gp));
        
    }
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue;
    }
    public int getDefense(){
        return defense = dexterity * currentShield.defenseValue;
    }
    public void getPlayerImage() {
        
        up1 = setup("/pics/player/boy_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/player/boy_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/pics/player/boy_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/player/boy_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/pics/player/boy_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/player/boy_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/pics/player/boy_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/player/boy_right_2", gp.tileSize, gp.tileSize);
    }
    public void getPlayerAttackImage(){
        attackUp1 = setup("/pics/playerattack/boy_attack_up_1", gp.tileSize, gp.tileSize*2);
        attackUp2 = setup("/pics/playerattack/boy_attack_up_2", gp.tileSize, gp.tileSize*2);
        attackDown1 = setup("/pics/playerattack/boy_attack_down_1", gp.tileSize, gp.tileSize*2);
        attackDown2 = setup("/pics/playerattack/boy_attack_down_2", gp.tileSize, gp.tileSize*2);
        attackLeft1 = setup("/pics/playerattack/boy_attack_left_1", gp.tileSize*2, gp.tileSize);
        attackLeft2 = setup("/pics/playerattack/boy_attack_left_2", gp.tileSize*2, gp.tileSize);
        attackRight1 = setup("/pics/playerattack/boy_attack_right_1", gp.tileSize*2, gp.tileSize);
        attackRight2 = setup("/pics/playerattack/boy_attack_right_2", gp.tileSize*2, gp.tileSize);
    }

    public void update(){
        if(attacking==true){
            attacking();
        }

        else if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true || keyH.enterPressed == true){
              if(keyH.upPressed==true){
            direction ="up";
            
        }else if(keyH.downPressed==true){
            direction="down";
            
        }else if(keyH.leftPressed==true){ 
            direction="left";
        
        }else if(keyH.rightPressed==true){
            direction = "right";

        }
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
        if(collisionOn == false && keyH.enterPressed == false){
            switch(direction){
                case "up":worldY-=speed;break;
                case "down":worldY+=speed;break;
                case "left":worldX-=speed;break;
                case "right":worldX+=speed;break;
                    
            }
        }
        if(keyH.enterPressed == true && attackCanceled == false){
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
                spriteNum = 1;
            }
            spriteCounter=0;
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
      
    }
    public void attacking(){
        spriteCounter++;
        if(spriteCounter<=5){
            spriteNum =1;
        }
        if(spriteCounter > 5 && spriteCounter <=25){
            spriteNum = 2;

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
            damageMonster(monsterIndex);

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
            String text;
            if(inventory.size()!=maxInventorySize&&gp.obj[i].obtainable==true){
                inventory.add(gp.obj[i]);
                gp.playSE(1);
                text = "Got a " + gp.obj[i].name + "!";
                gp.obj[i] = null;    
            }
            else if(gp.obj[i].obtainable == false){
                text = "Item cannot be obtained!";
            }
            else{
                text = "You cannot carry any more!";
            }
            gp.ui.addMessage(text);
            
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
            if(invincible == false){
                gp.playSE(6);
                int damage = gp.monster[i].attack -defense;
                if(damage<0){
                    damage = 0;
                }
                System.out.println("contact");
                life-=1;
                invincible = true;
            }
            
        }
    }
    
    public void damageMonster(int i) {
        
		if(i != 999) {
			
			if(gp.monster[i].invincible == false) {
				
                gp.playSE(5);

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
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
    
            gp.playSE(8);
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You are now level " + level + "!\n"
                                    + "Your dick is stronger!";
        }
    }
    public void selectItem(){
        
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
                }
                if(attacking == true){
                    tempScreenY = screenY - gp.tileSize;
                    if(spriteNum ==1){image = attackUp1;}
                    if(spriteNum==2){image = attackUp2;}
                }
                
                break;
            case "down":
                if(attacking ==false){
                    if(spriteNum ==1){image = down1;}
                    if(spriteNum==2){image =down2;}
                }
                if(attacking == true){
                    if(spriteNum ==1){image = attackDown1;}
                    if(spriteNum==2){image = attackDown2;}
                }
                break;
            case "left":
                if(attacking ==false){
                    if(spriteNum ==1){image = left1;}
                    if(spriteNum==2){image =left2;}
                }
                if(attacking == true){
                    tempScreenX = screenX - gp.tileSize;
                    if(spriteNum ==1){image = attackLeft1;}
                    if(spriteNum==2){image = attackLeft2;}
                }
                break;
            case "right":
                if(attacking ==false){
                    if(spriteNum ==1){image = right1;}
                    if(spriteNum==2){image =right2;}
                }
                if(attacking == true){
                    if(spriteNum ==1){image = attackRight1;}
                    if(spriteNum==2){image = attackRight2;}
                }
                break;
        }
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        g2.drawImage(image,tempScreenX,tempScreenY, null);
        
        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        //debug
        // g2.setFont(new Font("Arial", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invicible: "+invincibleCounter, 10, 400);
    }
}
