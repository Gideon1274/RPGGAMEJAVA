package object;


import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
    GamePanel gp;

    public OBJ_Heart(GamePanel gp){
        super(gp);
        this.gp=gp;
        type = type_pickupOnly;
        name = "heart";
        value = 2;
        down1 = setup("/pics/objects/heart_full", gp.tileSize, gp.tileSize);
        // image = setup("/pics/objects/heart_full", gp.tileSize, gp.tileSize);
        image = setup("/pics/objects/heart", gp.tileSize, gp.tileSize);
        // image2 = setup("/pics/objects/heart_half", gp.tileSize, gp.tileSize);
        // image3 = setup("/pics/objects/heart_blank", gp.tileSize, gp.tileSize);


    }
    public void use(Entity entity){
        gp.playSE(2);
        gp.ui.addMessage("Life +"+value);
        entity.life+=value;
    }
}
