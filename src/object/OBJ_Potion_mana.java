package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_mana extends Entity{
    GamePanel gp;
    
    public OBJ_Potion_mana(GamePanel gp){
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "Mana Potion";
        value = 50;
        stackable = true;
        down1 = setup("/pics/objects/mana",gp.tileSize, gp.tileSize);
        description = "[ "+ name+ " ]\nA potion that heals your\n mana!";
    }
    @Override
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the " + name +"!\n"
                        + "Your life has been recovered by "+ value+ ".";
        entity.life+=value;
        if(gp.player.mana > gp.player.maxMana){
            gp.player.mana = gp.player.maxMana;
        }
        gp.playSE(2);
    }
}
