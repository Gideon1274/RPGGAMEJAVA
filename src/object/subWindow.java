package object;


import entity.Entity;
import main.GamePanel;

public class subWindow extends Entity {
    public subWindow(GamePanel gp){
        super(gp);
        
        image = setup("/pics/subwindow/topleft", gp.tileSize, gp.tileSize);
        image2 = setup("/pics/subwindow/top", gp.tileSize, gp.tileSize);
        image3 = setup("/pics/subwindow/topright", gp.tileSize, gp.tileSize);
        image4 = setup("/pics/subwindow/left", gp.tileSize, gp.tileSize);
        image5 = setup("/pics/subwindow/middle", gp.tileSize, gp.tileSize);
        image6 = setup("/pics/subwindow/right", gp.tileSize, gp.tileSize);
        image7 = setup("/pics/subwindow/bottomleft", gp.tileSize, gp.tileSize);
        image8 = setup("/pics/subwindow/bottom", gp.tileSize, gp.tileSize);
        image9 = setup("/pics/subwindow/bottomright", gp.tileSize, gp.tileSize);

        
        
    }

        
    }

