package object;


import entity.Entity;
import main.GamePanel;

public class OBJ_Trees extends Entity{
    public OBJ_Trees(GamePanel gp){
        super(gp);
        name = "Door";
        down1 = setup("/pics/objects/tree", gp.tileSize*2, gp.tileSize*3);
        collision = true;
        obtainable = false;
        solidArea.x=33;
        solidArea.y= 60;
        solidArea.width = 50;
        solidArea.height = 100;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
    }
    
}
