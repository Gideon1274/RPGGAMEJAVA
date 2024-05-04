package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_PortalOrange extends Entity{
    public OBJ_PortalOrange(GamePanel gp){
        super(gp);
        name = "Portal Orange";
        down1 = setup("/pics/objects/portalorange", gp.tileSize, gp.tileSize);
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
