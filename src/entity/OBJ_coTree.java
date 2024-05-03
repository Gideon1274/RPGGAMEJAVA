package entity;


import java.util.Random;

import main.GamePanel;


public class OBJ_coTree extends Entity{
    public OBJ_coTree(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        
        up1 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
        down1 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
        left1 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
        right1 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
        
    }
    public void setDialogue(){

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