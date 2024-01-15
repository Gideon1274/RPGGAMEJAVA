package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Wood extends Entity{
    public OBJ_Shield_Wood(GamePanel gp){
        super(gp);

        type = type_shield;
        name = "Wood Shield";
        down1 = setup("/pics/objects/shield_wood", gp.tileSize, gp.tileSize);
        defenseValue = 2;

        description = "[" + name + "]\n is an old wooden shield.";
    }
}
