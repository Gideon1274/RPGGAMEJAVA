package object;


import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
    

    public OBJ_Heart(GamePanel gp){
        super(gp);
        
        name = "heart";
        image = setup("/pics/objects/heart_full");
        image2 = setup("/pics/objects/heart_half");
        image3 = setup("/pics/objects/heart_blank");
    }
}
