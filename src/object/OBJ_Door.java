package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity{
    public OBJ_Door(GamePanel gp){
        super(gp);
        name = "Door";
        down1 = setup("/pics/objects/door", gp.tileSize, gp.tileSize);
        collision = true;
        solidArea.x=0;
        solidArea.y= 0;
        solidArea.width = 36;
        solidArea.height = 26;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
}
