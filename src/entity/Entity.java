package entity;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.Random;

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
    

    public BufferedImage up1,up2,up3,up4,up5, down1, down2,down3,down4,down5;
    public BufferedImage left1,left2,left3,left4,left5,left6,left7;
    public BufferedImage right1,right2,right3,right4,right5,right6,right7;
    public BufferedImage upright1,upright2,upright3,upright4, upleft1,upleft2,upleft3,upleft4, downright1,downright2,downright3,downright4, downleft1,downleft2,downleft3,downleft4;
    public BufferedImage attackUp1,attackUp2,attackUp3,attackUp4, attackDown1, attackDown2,attackDown3, attackDown4;
    public BufferedImage attackRight1, attackRight2,attackRight3, attackRight4, attackLeft1, attackLeft2,attackLeft3, attackLeft4;
    public BufferedImage attackupRight1, attackupRight2,attackupRight3, attackupRight4, attackupLeft1, attackupLeft2,attackupLeft3, attackupLeft4;
    public BufferedImage attackdownRight1, attackdownRight2,attackdownRight3, attackdownRight4, attackdownLeft1, attackdownLeft2,attackdownLeft3, attackdownLeft4;
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
    

    //state
    public int shotAvailableCounter = 0;
	public int actionLockCounter = 0;
    public boolean attacking = false;
    public boolean alive = true;
    public boolean dying  = false;
    boolean hpBarOn =false;
    int hpBarCounter = 0;
    public boolean onPath = false;

	String dialogues[] = new String[20];
	int dialogueIndex = 0;

    public BufferedImage image,image2, image3,image4,image5,image6,image7,image8, image9;
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
    public boolean stackable = false;
    public int amount = 1;

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
    public void checkCollision(){
        collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this,false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
        if(this.type == type_monster && contactPlayer == true){
            damagePlayer(attack);
        }
    }
    public void update(){
        if(attacking  == true){
            attacking();
        }
        setAction();
		checkCollision();

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
        // spriteCounter++;
        if(spriteCounter>15){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 3;
            }else if(spriteNum == 3){
                spriteNum = 4;
            }else if(spriteNum == 4){
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
                int tempScreenX = screenX;
                int tempScreenY = screenY;
                
            
                
                switch(direction){
                    case "up":
                    if(attacking ==false){
                        if(spriteNum ==1){image = up1;}
                        if(spriteNum==2){image =up2;}
                        if(spriteNum==3){image = up3;}
                        if(spriteNum==4){image =up4;}
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
                            // tempScreenY = screenY - (int)(gp.tileSize/1);
                            if(spriteNum ==1){image = attackUp1;}
                            System.out.println(spriteNum);
                            if(spriteNum==2){image = attackUp2;}
                            System.out.println(spriteNum);
                            if(spriteNum ==3){image = attackUp3;}
                            if(spriteNum==4){image = attackUp4;}
                        }
                        
                        break;
                    case "down":
                    if(attacking ==false){
                        if(spriteNum ==1){image = down1;}
                        if(spriteNum==2){image =down2;}
                        if(spriteNum ==3){image = down3;}
                        if(spriteNum==4){image =down4;}
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
                            // tempScreenY = screenY + (int)(gp.tileSize/1);
                            if(spriteNum ==1){image = attackDown1;}
                            if(spriteNum==2){image = attackDown2;}
                            if(spriteNum ==3){image = attackDown3;}
                            if(spriteNum==4){image = attackDown4;}
        
                        }
                        break;
                    case "left":
                    if(attacking ==false){
                        if(spriteNum ==1){image = left1;}
                        if(spriteNum==2){image =left2;}
                        if(spriteNum ==3){image = left3;}
                        if(spriteNum==4){image =left4;}
                    }
                        if(attacking == true){
                            // tempScreenX = screenX - (int)(gp.tileSize/1);
                            if(spriteNum ==1){image = attackLeft1;}
                            if(spriteNum==2){image = attackLeft2;}
                            if(spriteNum ==3){image = attackLeft3;}
                            if(spriteNum==4){image = attackLeft4;}
                        }
                        break;
                    case "right":
                    if(attacking ==false){
                        if(spriteNum ==1){image = right1;}
                        if(spriteNum==2){image =right2;}
                        if(spriteNum ==3){image = right3;}
                        if(spriteNum==4){image =right4;}
                    }
                        if(attacking == true){
                            // tempScreenX = screenX + (int)(gp.tileSize/1);
                            if(spriteNum ==1){image = attackRight1;}
                            if(spriteNum==2){image = attackRight2;}
                            if(spriteNum ==3){image = attackRight3;}
                            if(spriteNum==4){image = attackRight4;}
                        }
                        break;
        
                    //8 DIRECTION
                    case "upright":
                    if(attacking ==false){
                        if(spriteNum ==1){image = right1;}
                        if(spriteNum==2){image =right2;}
                        if(spriteNum ==3){image = right3;}
                        if(spriteNum==4){image =right4;}
                    }if(attacking == true){
                        // tempScreenX = screenX + (int)(gp.tileSize/1);
                        // tempScreenY = screenY - (int)(gp.tileSize/1);
                        if(spriteNum ==1){image = attackupRight1;}
                        if(spriteNum==2){image = attackupRight2;}
                        if(spriteNum ==3){image = attackupRight3;}
                        if(spriteNum==4){image = attackupRight4;}
                    }
        
                        break;
                    case "upleft":
                    if(attacking ==false){
                        if(spriteNum ==1){image = left1;}
                        if(spriteNum==2){image =left2;}
                        if(spriteNum ==3){image = left3;}
                        if(spriteNum==4){image =left4;}
                    }if(attacking == true){
                        // tempScreenX = screenX - (int)(gp.tileSize/1);
                        // tempScreenY = screenY - (int)(gp.tileSize/1);
                        if(spriteNum ==1){image = attackupLeft1;}
                        if(spriteNum==2){image = attackupLeft2;}
                        if(spriteNum ==3){image = attackupLeft3;}
                        if(spriteNum==4){image = attackupLeft4;}
                    }
                        break;
                    case "downright":
                    if(attacking ==false){
                        if(spriteNum ==1){image = right1;}
                        if(spriteNum==2){image =right2;}
                        if(spriteNum ==3){image = right3;}
                        if(spriteNum==4){image =right4;}
                    }if(attacking == true){
                        // tempScreenX = screenX + (int)(gp.tileSize/1);
                        // tempScreenY = screenY + (int)(gp.tileSize/1);
                        if(spriteNum ==1){image = attackdownRight1;}
                        if(spriteNum==2){image = attackdownRight2;}
                        if(spriteNum ==3){image = attackdownRight3;}
                        if(spriteNum==4){image = attackdownRight4;}
                    }
                        break;
                    case "downleft":
                    if(attacking ==false){
                        if(spriteNum ==1){image = left1;}
                        if(spriteNum==2){image =left2;}
                        if(spriteNum ==3){image = left3;}
                        if(spriteNum==4){image =left4;}
                    }if(attacking == true){
                        // tempScreenX = screenX - (int)(gp.tileSize/1);
                        // tempScreenY = screenY + (int)(gp.tileSize/1);
                        if(spriteNum ==1){image = attackdownLeft1;}
                        if(spriteNum==2){image = attackdownLeft2;}
                        if(spriteNum ==3){image = attackdownLeft3;}
                        if(spriteNum==4){image = attackdownLeft4;}
                    }
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
			g2.drawImage(image, tempScreenX,tempScreenY, null);
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
        System.out.println(imagePath);
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
    public int getXdistance(Entity target)
    {
        int xDistance = Math.abs(getCenterX() - target.getCenterX());
        return xDistance;
    }
    public int getYdistance(Entity target)
    {
        int yDistance = Math.abs(getCenterY() - target.getCenterY());
        return yDistance;
    }
    public int getTileDistance(Entity target)
    {
        int tileDistance = (getXdistance(target) + getYdistance(target))/gp.tileSize;
        return tileDistance;
    }
    public int getGoalCol(Entity target){
        return (target.worldX + target.solidArea.x)/gp.tileSize;   
    }
    public int getGoalRow(Entity target){
        return (target.worldY + target.solidArea.y)/gp.tileSize;   
    }
    public BufferedImage adjustOpacity(BufferedImage image, float opacity) {
        // Create a RescaleOp object with the desired opacity
        float[] scales = {1f, 1f, 1f, opacity}; // RGBA scales
        float[] offsets = new float[4];
        RescaleOp op = new RescaleOp(scales, offsets, null);
    
        // Apply the opacity adjustment to the image
        BufferedImage transparentImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = transparentImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return op.filter(transparentImage, null);
    }

     public void searchPath(int goalCol, int goalRow)
    {
        int startCol = (worldX + solidArea.x) / gp.tileSize;
        int startRow = (worldY + solidArea.y) / gp.tileSize;
        gp.pFinder.setNodes(startCol,startRow,goalCol,goalRow,this);
        if(gp.pFinder.search() == true)
        {
            //Next WorldX and WorldY
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            //Entity's solidArea position
            int enLeftX = worldX + solidArea.x;
            int enRightX = worldX + solidArea.x + solidArea.width;
            int enTopY = worldY + solidArea.y;
            int enBottomY = worldY + solidArea.y + solidArea.height;

            // TOP PATH
            if(enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize)
            {
                direction = "up";
            }
            // BOTTOM PATH
            else if(enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize)
            {
                direction = "down";
            }
            // RIGHT - LEFT PATH
            else if(enTopY >= nextY && enBottomY < nextY + gp.tileSize)
            {
                //either left or right
                // LEFT PATH
                if(enLeftX > nextX)
                {
                    direction = "left";
                }
                // RIGHT PATH
                if(enLeftX < nextX)
                {
                    direction = "right";
                }
            }
            //OTHER EXCEPTIONS
            else if(enTopY > nextY && enLeftX > nextX)
            {
                // up or left
                direction = "up";
                checkCollision();
                if(collisionOn == true)
                {
                    direction = "left";
                }
            }
            else if(enTopY > nextY && enLeftX < nextX)
            {
                // up or right
                direction = "up";
                checkCollision();
                if(collisionOn == true)
                {
                    direction = "right";
                }
            }
            else if(enTopY < nextY && enLeftX > nextX)
            {
                // down or left
                direction = "down";
                checkCollision();
                if(collisionOn == true)
                {
                    direction = "left";
                }
            }
            else if(enTopY < nextY && enLeftX < nextX)
            {
                // down or right
                direction = "down";
                checkCollision();
                if(collisionOn == true)
                {
                    direction = "right";
                }
            }
            // for following player, disable this. It should be enabled when npc walking to specified location
        //    int nextCol = gp.pFinder.pathList.get(0).col;
        //    int nextRow = gp.pFinder.pathList.get(0).row;
        //    if(nextCol == goalCol && nextRow == goalRow)
        //    {
        //        onPath = false;
        //    }
        }
    }

    public void checkStartChasingOrNot(Entity target, int distance, int rate)
    {   
        // System.out.println("Start Chase: "+ getTileDistance(target));
        if(getTileDistance(target) < distance)
        {
            // int i = new Random().nextInt(rate);
            // if(i == 0)
            // {
                onPath = true;
            // }
        }
    }
    public void checkStopChasingOrNot(Entity target, int distance, int rate)
    {
        if(getTileDistance(target) > distance)
        {
            // int i = new Random().nextInt(rate);
            // if(i == 0)
            // {
                onPath = false;
            // }
        }
    }
    public void moveTowardPlayer(int interval)
    {
        actionLockCounter++;

        if(actionLockCounter > interval)
        {
            if(getXdistance(gp.player) > getYdistance(gp.player)) //if entity far to the player on X axis moves right or left
            {
                if(gp.player.getCenterX() < getCenterX()) //Player is left side, entity moves to left
                {
                    direction = "left";
                }
                else
                {
                    direction = "right";
                }
            }
            else if(getXdistance(gp.player) < getYdistance(gp.player))  //if entity far to the player on Y axis moves up or down
            {
                if(gp.player.getCenterY() < getCenterY()) //Player is up side, entity moves to up
                {
                    direction = "up";
                }
                else
                {
                    direction = "down";
                }
            }
            actionLockCounter = 0;
        }
    }
    public void getRandomDirection(){
        actionLockCounter++;
        if(actionLockCounter > 120){
            int i = new Random().nextInt(128)+1;
            // if(i == 0)
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
    }
    
    public void checkShootOrNot(int rate, int shotInterval)
    {
        // int i = new Random().nextInt(rate);
        // if(i == 0 && projectile.alive == false && shotAvailableCounter == shotInterval)
        // {
        //     projectile.set(worldX,worldY,true,this);
        //     //gp.projectileList.add(projectile);
        //     //CHECK VACANCY
        //     for(int ii = 0; ii < gp.projectile[1].length;ii++)
        //     {
        //         if(gp.projectile[ii] == null)
        //         {
        //             gp.projectile[ii] = projectile;
        //             break;
        //         }
        //     }
        //     shotAvailableCounter = 0;
        // }
    }
    public void attacking(){
        if(spriteCounter>30){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 3;
            }else if(spriteNum == 3){
                spriteNum = 4;
            }else if(spriteNum == 4){
                spriteNum = 1;
            }
            // System.out.println(spriteNum);
            spriteCounter=0;
        }
        
        if(spriteCounter > 5 && spriteCounter <=10){
            spriteNum = 4;
            //save the current worldX, WorldY
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            // adjust player's worldx/y for the attackarea
            switch(direction){
                case "up": worldY -= attackArea.height;System.out.println("1");break;
                case "down": worldY += attackArea.height;System.out.println("2");break;
                case "left": worldX -= attackArea.width;System.out.println("3");break;
                case "right": worldX += attackArea.width;System.out.println("4");break;

                case "upright": worldX += attackArea.width*0.7; worldY -= attackArea.height*0.7;System.out.println("5");break;
                case "upleft": worldX -= attackArea.width*0.7; worldY -= attackArea.height*0.7;System.out.println("6");break;
                case "downright": worldY += attackArea.height*0.7; worldX+=attackArea.width*0.7;System.out.println("7");break;
                case "downleft": worldY += attackArea.height*0.7; worldX -=attackArea.width * 0.7;System.out.println("8");break;

            }

            //attackarea becomes solid Area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            //check monster collision with the updated worldX, worldY and solid Area
            

            if(type == type_monster){
                if(gp.cChecker.checkPlayer(this) == true){
                    damagePlayer(attack);
                }
            }else{
                int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);
                gp.player.damageMonster(monsterIndex, attack);
            }
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
    public int getCenterX()
    {
        int centerX = worldX + left1.getWidth()/2;
        return centerX;
    }
    public int getCenterY()
    {
        int centerY = worldY + up1.getWidth()/2;
        return centerY;
    }
    public void checkAttackOrNot(int rate, int straight, int horizontal)
    {
        boolean tartgetInRange = false;
        int xDis = getXdistance(gp.player);
        int yDis = getYdistance(gp.player);

        switch (direction)
        {
            case "up":
                if(gp.player.getCenterY() < getCenterY()  && yDis < straight && xDis < horizontal)
                {
                    tartgetInRange = true;
                }
                break;
            case "down":
                if(gp.player.getCenterY()  > getCenterY()  && yDis < straight && xDis < horizontal)
                {
                    tartgetInRange = true;
                }
                break;
            case "left":
                if(gp.player.getCenterX()  < getCenterX() && xDis < straight && yDis < horizontal)
                {
                    tartgetInRange = true;
                }
                break;
            case "right":
                if(gp.player.getCenterX() > getCenterX() && xDis < straight && yDis < horizontal)
                {
                    tartgetInRange = true;
                }
                break;
        }

        // if(tartgetInRange == true)
        // {
        //     //Check if it initiates an attack
        //     int i = new Random().nextInt(rate);
        //     if(i == 0)
        //     {
        //         attacking = true;
        //         spriteNum = 1;
        //         spriteCounter = 0;
        //         shotAvailableCounter = 0;
        //     }
        // }

    }

}




