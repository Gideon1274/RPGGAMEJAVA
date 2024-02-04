package entity;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;


public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    

    public BufferedImage up1,up2, down1, down2,down3,down4;
    public BufferedImage left1,left2,left3,left4,left5,left6,left7;
    public BufferedImage right1,right2,right3,right4,right5,right6,right7;
    public BufferedImage upright1,upright2, upleft1,upleft2,downright1,downright2,downleft1,downleft2;
    public BufferedImage attackUp1,attackUp2, attackDown1, attackDown2, attackRight1, attackRight2, attackLeft1, attackLeft2;
    public BufferedImage imageProjectile1,imageProjectile2;
    public String direction = "down";
    // public String directionformoving = "hasmoveddown";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int spriteNumMobs = 1;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    int dyingCounter = 0;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);

    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    public int shotAvailableCounter = 0;
	public int actionLockCounter = 0;
    public boolean attacking = false;
    public boolean alive = true;
    public boolean dying  = false;
    boolean hpBarOn =false;
    int hpBarCounter = 0;

	String dialogues[] = new String[20];
	int dialogueIndex = 0;

    public BufferedImage image,image2, image3;
    public boolean collision  = false;
    public boolean obtainable = true;

    public int projectileHeight;
    public int projectileWidth;

	//character status 
	public int maxLife;
	public int life;
    public int maxMana;
    public int mana;
    public String name;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int ammo;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public int speed;
    public int rateOfFire;
    public int projectileDamage;
    public double skillMultiplier;

    public Entity currentWeapon;
    public Entity currentShield;
    public Projectile projectile;

    // item attributes
    public int value;
    public int attackValue;
    public int defenseValue;
    public String description = "";
    public int useCost;

    // type
    public int type; // 0 = player, 1 = npc, 2 monster
    public final int type_player=0;
    public final int type_npc = 1;
    public final int type_monster = 2;
    public final int type_sword = 3;
    public final int type_axe = 4;
    public final int type_shield = 5;
    public final int type_consumable = 6;
    public final int type_pickupOnly = 7;
    public final int type_bullet = 10;


    public Entity(GamePanel gp){
		
        this.gp = gp;
    }
    public void setAction(){
    }
    public void damageReaction(){
    }
	public void speak(){
		if(dialogues[dialogueIndex] == null){
            dialogues[dialogueIndex] = "Do what must be done qwe qwe qwe qwe qwe qwe";
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction ="up";
                break;
            case "left":
                direction ="right";
                break;
            case "right":
                direction = "left";
                break;
            default:
                break;
        }
	}
    public Rectangle getAdjustedSolidArea() {
        Rectangle adjustedSolidArea = new Rectangle(solidArea);
        adjustedSolidArea.x += worldX;
        adjustedSolidArea.y += worldY;
        return adjustedSolidArea;
    }
    public void use(Entity entity){}
    public void checkDrop(){}
    public void dropItem(Entity droppedItem){
        for(int i = 0;i<gp.obj.length;i++){
            if(gp.obj[i] == null){
                gp.obj[i] = droppedItem;
                gp.obj[i].worldX = worldX; //the dead monster's worldx;
                gp.obj[i].worldY = worldY;  //the dead monster's worldy;
                break;
            }
        }
    }
    public void update(){
        setAction();

		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this,false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
        if(this.type == type_monster && contactPlayer == true){
            damagePlayer(attack);
        }

		if(collisionOn == false){
            switch(direction){
                case "up":worldY-=speed;break;
                case "down":worldY+=speed;break;
                case "left":worldX-=speed;break;
                case "right":worldX+=speed;break;
                case "upright":worldY-=speed;worldX+=speed;break;
                case "upleft":worldY-=speed;worldX-=speed;break;
                case "downright":worldY+=speed;worldX+=speed;break;
                case "downleft":worldY+=speed;worldX-=speed;break;
            }
        }
        spriteCounter++;
        if(spriteCounter>12){
            if(spriteNumMobs == 1){
                spriteNumMobs = 2;
            }
            
            else if(spriteNumMobs == 2){
                spriteNumMobs = 1;
            }
        spriteCounter++;
        if(spriteCounter>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 3;
            }else if(spriteNum == 3){
                spriteNum = 4;
            }else if(spriteNum == 4){
                spriteNum = 5;
            }else if(spriteNum == 5){
                spriteNum = 6;
            }else if(spriteNum == 6){
                spriteNum = 7;
            }else if(spriteNum == 7){
                spriteNum = 1;
            }
            // System.out.println(spriteNum);
            spriteCounter=0;
        }
    }


        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter >15){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(shotAvailableCounter < 30){
            shotAvailableCounter++;
        }
    }
    public void damagePlayer(int attack){
        if(gp.player.invincible == false){
            gp.playSE(6);

            int damage = attack - gp.player.defense;
            if(damage<0){
                damage = 0;
            }
            gp.player.life -= damage;
            gp.ui.addMessage("Damage by "+damage);
            gp.player.invincible = true;
        }
    }
    public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
        
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			switch(direction) {
                
			case "up":
				if (spriteNumMobs == 1) {image = up1;}
				if (spriteNumMobs == 2) {image = up2;}
				break;
			case "down":
				if (spriteNumMobs == 1) {image = down1;}
				if (spriteNumMobs == 2) {image = down2;}
				break;
			case "left":
				if (spriteNumMobs == 1) {image = left1;}
				if (spriteNumMobs == 2) {image = left2;}
				break;
			case "right":
				if (spriteNumMobs == 1) {image = right1;}
				if (spriteNumMobs == 2) {image = right2;}
				break;
            
            case "upright":
				if (spriteNumMobs == 1) {image = upright1;}
				if (spriteNumMobs == 2) {image = upright2;}
				break;
            case "upleft":
				if (spriteNumMobs == 1) {image = upleft1;}
				if (spriteNumMobs == 2) {image = upleft2;}
				break;
            case "downright":
				if (spriteNumMobs == 1) {image = downright1;}
				if (spriteNumMobs == 2) {image = downright2;}
				break;
            case "downleft":
				if (spriteNumMobs == 1) {image = downleft1;}
				if (spriteNumMobs == 2) {image = downleft2;}
				break;
            
            
			}
            
        
            
            //monster healthbar
            if(type == 2 && hpBarOn == true){

                double oneScale = (double)gp.tileSize/maxLife;
                double hpBarValue = oneScale*life;

                g2.setColor(new Color(35,35,35));
                g2.fillRect(screenX - 1, screenY -16, gp.tileSize, 12);

                g2.setColor(new Color(255,0,30));
                g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);
                
                hpBarCounter++;
                if(hpBarCounter>600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }
            
            
            if(invincible == true){
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4F);
            }
            if(dying == true){
                dyingAnimation(g2);
            }
			g2.drawImage(image, screenX, screenY, null);
            changeAlpha(g2,1F);
			
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
		}
	}
    public void dyingAnimation(Graphics2D g2){

        dyingCounter++;
        int i=5;
        if(dyingCounter<=i){changeAlpha(g2, 0f);}
        if(dyingCounter>i && dyingCounter<=i*2){changeAlpha(g2, 1f);}
        if(dyingCounter>i*2 && dyingCounter<=i*3){changeAlpha(g2, 0f);}
        if(dyingCounter>i*3 && dyingCounter<=i*4){changeAlpha(g2, 1f);}
        if(dyingCounter>i*4 && dyingCounter<=i*5){changeAlpha(g2, 0f);}
        if(dyingCounter>i*5 && dyingCounter<=i*6){changeAlpha(g2, 1f);}
        if(dyingCounter>i*6 && dyingCounter<=i*7){changeAlpha(g2, 0f);}
        if(dyingCounter>i*7 && dyingCounter<=i*8){changeAlpha(g2, 1f);}
        if(dyingCounter>i*8){
            // dying = false;
            alive = false;
        }
        

        
    }
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
    
    public BufferedImage setup(String imagePath, int width, int height){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

    
}
