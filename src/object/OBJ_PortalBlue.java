package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_PortalBlue extends Entity{
    public OBJ_PortalBlue(GamePanel gp){
        super(gp);
        name = "Portal Blue";
        down1 = setup("/pics/objects/portalblue", gp.tileSize, gp.tileSize);
        collision = false;
        obtainable = false;
        solidArea.x=0;
        solidArea.y= 0;
        solidArea.width = 36;
        solidArea.height = 26;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        
    }
}
