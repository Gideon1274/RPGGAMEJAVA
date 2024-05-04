package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity{
    GamePanel gp;
    
    public OBJ_Potion_Red(GamePanel gp){
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "Red Potion";
        value = 5;
        stackable = true;
        down1 = setup("/pics/objects/potion_red",gp.tileSize, gp.tileSize);
        description = "[ "+ name+ " ]\nA potion that heals your\n health!";
    }
    @Override
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the " + name +"!\n"
                        + "Your life has been recovered by "+ value+ ".";
        entity.life+=value;
        if(gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
        gp.playSE(2);
    }
}
