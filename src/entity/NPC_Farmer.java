package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_Farmer extends Entity{
    public NPC_Farmer(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 2;
        getImage();
        setDialogue();
    }

    public void getImage() {
        
        up1 = setup("/pics/npc/farmer/up00", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/npc/farmer/up01", gp.tileSize, gp.tileSize);
        up3 = setup("/pics/npc/farmer/up02", gp.tileSize, gp.tileSize);
        up4 = setup("/pics/npc/farmer/up03", gp.tileSize, gp.tileSize);

        down1 = setup("/pics/npc/farmer/down00", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/npc/farmer/down01", gp.tileSize, gp.tileSize);
        down3 = setup("/pics/npc/farmer/down02", gp.tileSize, gp.tileSize);
        down4 = setup("/pics/npc/farmer/down03", gp.tileSize, gp.tileSize);

        left1 = setup("/pics/npc/farmer/left00", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/npc/farmer/left01", gp.tileSize, gp.tileSize);
        left3 = setup("/pics/npc/farmer/left02", gp.tileSize, gp.tileSize);
        left4 = setup("/pics/npc/farmer/left03", gp.tileSize, gp.tileSize);

        right1 = setup("/pics/npc/farmer/right00", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/npc/farmer/right01", gp.tileSize, gp.tileSize);
        right3 = setup("/pics/npc/farmer/right02", gp.tileSize, gp.tileSize);
        right4 = setup("/pics/npc/farmer/right03", gp.tileSize, gp.tileSize);

        upleft1 = setup("/pics/npc/farmer/left00", gp.tileSize, gp.tileSize);
        upleft2 = setup("/pics/npc/farmer/left01", gp.tileSize, gp.tileSize);
        upleft3 = setup("/pics/npc/farmer/left02", gp.tileSize, gp.tileSize);
        upleft4 = setup("/pics/npc/farmer/left03", gp.tileSize, gp.tileSize);

        upright1 = setup("/pics/npc/farmer/right00", gp.tileSize, gp.tileSize);
        upright2 = setup("/pics/npc/farmer/right01", gp.tileSize, gp.tileSize);
        upright3 = setup("/pics/npc/farmer/right02", gp.tileSize, gp.tileSize);
        upright4 = setup("/pics/npc/farmer/right03", gp.tileSize, gp.tileSize);

        downleft1 = setup("/pics/npc/farmer/left00", gp.tileSize, gp.tileSize);
        downleft2 = setup("/pics/npc/farmer/left01", gp.tileSize, gp.tileSize);
        downleft3 = setup("/pics/npc/farmer/left02", gp.tileSize, gp.tileSize);
        downleft4 = setup("/pics/npc/farmer/left03", gp.tileSize, gp.tileSize);

        downright1 = setup("/pics/npc/farmer/right00", gp.tileSize, gp.tileSize);
        downright2 = setup("/pics/npc/farmer/right01", gp.tileSize, gp.tileSize);
        downright3 = setup("/pics/npc/farmer/right02", gp.tileSize, gp.tileSize);
        downright4 = setup("/pics/npc/farmer/right03", gp.tileSize, gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0] = "Hello Stranger, You look strong. Here's a gift";
        dialogues[1] = "Our place is surrounded by evil doers.\n If you defeat them you will receive a reward.";

    }
    public void setAction()
    {
        if(onPath == true)
        {
        //    int goalCol = 40;
        //    int goalRow = 40;

            int goalCol = (gp.player.worldX + gp.player.solidArea.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y) / gp.tileSize;
            searchPath(goalCol, goalRow);

        }
        else
        {
            actionLockCounter++;

            if(actionLockCounter == 120)
            {
                Random random = new Random();
                int i = random.nextInt(100) + 1;  // pick up  a number from 1 to 100
                if(i <= 25)
                {
                    direction = "up";
                }
                if(i>25 && i <= 50)
                {
                    direction = "down";
                }
                if(i>50 && i <= 75)
                {
                    direction = "left";
                }
                if(i>75 && i <= 100)
                {
                    direction = "right";
                }
                actionLockCounter = 0; // reset
            }
        }
    }
    public void speak(){
       super.speak();
       onPath = true;
}
}