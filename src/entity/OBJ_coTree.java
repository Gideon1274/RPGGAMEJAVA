package entity;


import java.util.Random;

import main.GamePanel;


public class OBJ_coTree extends Entity{
    public OBJ_coTree(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 0;
        getImage();
        obtainable  = true;
        setDialogue();
        collisionOn =false;
    }

    public void getImage() {
        
        up1 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        up3 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        up4 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);

        down1 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        down3 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        down4 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        left1 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        left3 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        left4 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        right1 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        right3 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        right4 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);

        upright1 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        upright2 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        downright1 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        downright2 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        upleft1 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        upleft2 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        downleft1 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        downleft2 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        
        upright3 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        upright4 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        downright3 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        downright4 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        upleft3 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        upleft4 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        downleft3 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        downleft4 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        
    }
    public void setDialogue(){
        dialogues[0] = "*swush*";
        dialogues[1] = "*swush*";
        dialogues[2] = "*swush*";
        dialogues[3] = "*swush*";
        dialogues[4] = "*swush*";
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
    }
    public void speak(){
    //    super.speak();
}
}