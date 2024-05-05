package entity;


import java.util.Random;

import main.GamePanel;


public class NPC_OldMan extends Entity{
    public NPC_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 10;
        getImage();
        setDialogue();
    }

    public void getImage() {
        
        up1 = setup("/pics/npc/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/pics/npc/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/pics/npc/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/pics/npc/oldman_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/pics/npc/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/pics/npc/oldman_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/pics/npc/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/pics/npc/oldman_right_2", gp.tileSize, gp.tileSize);
    }
    public void setDialogue(){
        dialogues[0] = "Hello, idiotsqqw eqw e\nqweqwe qwe qwe qwe ";
        dialogues[1] = "So, youve come bakatare qwe qwe qwe qweqweqweqw qw ";
        dialogues[2] = "blah blaahqwe qwe qwe qwe qwe qwe qwe qwe qwe";
        dialogues[3] = "blah blahqwe qwe qwe qwe qwe qwe";

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