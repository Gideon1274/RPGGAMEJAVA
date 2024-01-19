package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Blue extends Entity{
    public OBJ_Shield_Blue(GamePanel gp){
        super(gp);

        type = type_shield;
        name = "Blue Shield";
        down1 = setup("/pics/objects/shield_blue", gp.tileSize, gp.tileSize);
        defenseValue = 4;

        description = "[" + name + "]\n is an old blue shield.";
    }
}
