package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {
    GamePanel gp;
    public OBJ_Key(GamePanel gp){
        super(gp);
        name = "Key";
        stackable = true;
        down1 = setup("/pics/objects/key", gp.tileSize, gp.tileSize);
        
        collision = true;
        description = "[" + name + "]\n can be used to open doors.";
    }
}

