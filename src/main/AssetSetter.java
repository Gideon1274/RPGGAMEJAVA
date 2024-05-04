package main;

import entity.Entity;
import entity.NPC_OldMan;
import entity.OBJ_coTree;
import monster.MON_Crab;
import monster.MON_GreenSlime;
import monster.MON_coTree;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_PortalBlue;
import object.OBJ_PortalOrange;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import object.OBJ_Trees;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setObject(){
        int i =0;
        gp.obj[i] = new OBJ_PortalBlue(gp);
        gp.obj[i].worldX = gp.tileSize*26;
        gp.obj[i].worldY = gp.tileSize*20;
        gp.obj[i].collision = false;i++;
        
        gp.obj[i] = new OBJ_PortalOrange(gp);
        gp.obj[i].worldX = gp.tileSize*55;
        gp.obj[i].worldY = gp.tileSize*55;
        gp.obj[i].collision = false;i++;
        

        // gp.obj[i] = new OBJ_Coin_Bronze(gp);
        // gp.obj[i].worldX = gp.tileSize*25;
        // gp.obj[i].worldY = gp.tileSize*19;
        // i++;

        // gp.obj[i] = new OBJ_Coin_Bronze(gp);
        // gp.obj[i].worldX = gp.tileSize*24;
        // gp.obj[i].worldY = gp.tileSize*19;
        // i++;
        
        // gp.obj[i] = new OBJ_Axe(gp);
        // gp.obj[i].worldX = gp.tileSize*26;
        // gp.obj[i].worldY = gp.tileSize*21;
        // i++;

        // gp.obj[i] = new OBJ_Shield_Blue(gp);
        // gp.obj[i].worldX = gp.tileSize*25;
        // gp.obj[i].worldY = gp.tileSize*21;
        // i++;

        gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*22;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;
         gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;
        gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = gp.tileSize*23;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;
        // gp.obj[i] = new OBJ_Heart(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*29;
        // i++;

        // gp.obj[i] = new OBJ_ManaCrystal(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*31;
        // i++;

        
    }
    public void setNPC(){
        int i=0;
        gp.npc[i] = new NPC_OldMan(gp);
        gp.npc[i].worldX = gp.tileSize*35;
        gp.npc[i].worldY = gp.tileSize*35;i++;

        gp.npc[i] = new NPC_OldMan(gp);
        gp.npc[i].worldX = gp.tileSize*35;
        gp.npc[i].worldY = gp.tileSize*40;i++;
        
        gp.npc[i] = new NPC_OldMan(gp);
        gp.npc[i].worldX = gp.tileSize*35;
        gp.npc[i].worldY = gp.tileSize*45;i++;
        
        for(int q=17;q<=82;q++){
            for(int j=49;j<=54;j++){
                setcoTree(i, q, j);i++;    
            }      
        }
        // for(int q=25;q<=30;q++){
        //     for(int j=12;j<=17;j++){
        //         Tree(i, q, j);i++;    
        //     }      
        // }
        
        
    }

    public void setcoTree(int i, int x, int y){
        gp.npc[i] = new OBJ_coTree(gp);
        gp.npc[i].worldX = gp.tileSize*x;
        gp.npc[i].worldY = gp.tileSize*y;
    }
    public void Tree(int i, int x, int y){
        gp.obj[i] = new OBJ_Trees(gp);
        gp.obj[i].worldX = gp.tileSize*x;
        gp.obj[i].worldY = gp.tileSize*y;
    }
    // up1 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
    // up2 = setup("/pics/objects/cotree00", gp.tileSize, gp.tileSize);
    // down1 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
    // down2 = setup("/pics/objects/cotree01", gp.tileSize, gp.tileSize);
    // left1 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
    // left2 = setup("/pics/objects/cotree02", gp.tileSize, gp.tileSize);
    // right1 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
    // right2 = setup("/pics/objects/cotree03", gp.tileSize, gp.tileSize);
    public void setMonster(){
        int i  = 0;

        // gp.monster[i] = new MON_coTree(gp);
        // gp.monster[i].worldX = gp.tileSize * 30;
        // gp.monster[i].worldY = gp.tileSize * 30;
        // i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 35;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 36;
        i++;
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 37;
        i++;
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 38;
        i++;
        
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 39;
        i++;
        gp.monster[i] = new MON_Crab(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 39;
        i++;
    }
    public void setTree(){
        // int i = 0;
        // for(int q=20;q<=25;q++){
        //     for(int j=12;j<=17;j++){
        //         Tree(i, q, j);i++;    
        //     }      
        // }
        // for(int q=25;q<=30;q++){
        //     for(int j=12;j<=17;j++){
        //         Tree(i, q, j);i++;    
        //     }      
        // }
        
               
    }


    
}
