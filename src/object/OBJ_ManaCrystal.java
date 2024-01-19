package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_ManaCrystal extends Entity {
    GamePanel gp;
    public OBJ_ManaCrystal(GamePanel gp){
        super(gp);
        this.gp =gp;
        name = "Mana Crystal";
        image = setup("/pics/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image2 = setup("/pics/objects/manacrystal_blank", gp.tileSize, gp.tileSize);
    }   
}
