package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Torch extends Entity {
    public OBJ_Torch(GamePanel gp){
        super(gp);
        name = "Torch";
        // down1 = setup("/pics/objects/tree", gp.tileSize*2, gp.tileSize*3);
        down1 = setup("/pics/objects/torch", gp.tileSize, gp.tileSize);
        collision = true;
        obtainable = false;
        solidArea.x= 0;
        solidArea.y= 0;
        solidArea.width = (int)(gp.tileSize/1.5);
        solidArea.height = (int)(gp.tileSize/1.5);
        // solidArea.x=33;
        // solidArea.y= 60;
        // solidArea.width = 50;
        // solidArea.height = 100;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
    }

        
    }