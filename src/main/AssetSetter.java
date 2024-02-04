package main;

import entity.Entity;
import entity.NPC_OldMan;
import monster.MON_Crab;
import monster.MON_GreenSlime;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
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
        // gp.obj[i] = new OBJ_Door(gp);
        // gp.obj[i].worldX = gp.tileSize*26;
        // gp.obj[i].worldY = gp.tileSize*16;
        // gp.obj[i].collision = false;
        // i++;

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

        // gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;

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
        // gp.npc[0] = new NPC_OldMan(gp);
        // gp.npc[0].worldX = gp.tileSize*9;
        // gp.npc[0].worldY = gp.tileSize*10;
        
    }
    public void setMonster(){
        int i  = 0;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 11;
        // gp.monster[i].worldY = gp.tileSize * 10;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 11;
        // gp.monster[i].worldY = gp.tileSize * 11;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 23;
        // gp.monster[i].worldY = gp.tileSize * 35;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 23;
        // gp.monster[i].worldY = gp.tileSize * 36;
        // i++;
        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 23;
        // gp.monster[i].worldY = gp.tileSize * 37;
        // i++;
        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 23;
        // gp.monster[i].worldY = gp.tileSize * 38;
        // i++;
        
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 40;
        
        i++;

        gp.monster[i] = new MON_Crab(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 39;
        i++;
    }
    public void setTree(){
        int i = 0;
        // Tree(i, 12, 12);i++;
        // Tree(i, 12, 13);i++;
        // Tree(i, 12, 14);i++;
        // Tree(i, 12, 15);i++;
        // Tree(i, 12, 16);i++;
        // Tree(i, 12, 17);i++;

        // Tree(i, 14, 12);i++;
        // Tree(i, 14, 13);i++;
        // Tree(i, 14, 14);i++;
        // Tree(i, 14, 15);i++;
        // Tree(i, 14, 16);i++;
        // Tree(i, 14, 17);i++;

        
        // Tree(i, 16, 12);i++;
        // Tree(i, 16, 13);i++;
        // Tree(i, 16, 14);i++;
        // Tree(i, 16, 15);i++;
        // Tree(i, 16, 16);i++;
        // Tree(i, 16, 17);i++;

        
        // Tree(i, 18, 12);i++;
        // Tree(i, 18, 13);i++;
        // Tree(i, 18, 14);i++;
        // Tree(i, 18, 15);i++;
        // Tree(i, 18, 16);i++;
        // Tree(i, 18, 17);i++;
        
        // Tree(i, 20, 12);i++;
        // Tree(i, 20, 13);i++;
        // Tree(i, 20, 14);i++;
        // Tree(i, 20, 15);i++;
        // Tree(i, 20, 16);i++;
        // Tree(i, 20, 17);i++;

        // Tree(i, 25, 12);i++;
        // Tree(i, 25, 13);i++;
        // Tree(i, 25, 14);i++;
        // Tree(i, 25, 15);i++;
        // Tree(i, 25, 16);i++;
        // Tree(i, 25, 17);i++;

        // Tree(i, 27, 12);i++;
        // Tree(i, 27, 13);i++;
        // Tree(i, 27, 14);i++;
        // Tree(i, 27, 15);i++;
        // Tree(i, 27, 16);i++;
        // Tree(i, 27, 17);i++;

        
        // Tree(i, 29, 12);i++;
        // Tree(i, 29, 13);i++;
        // Tree(i, 29, 14);i++;
        // Tree(i, 29, 15);i++;
        // Tree(i, 29, 16);i++;
        // Tree(i, 29, 17);i++;

        
        // Tree(i, 31, 12);i++;
        // Tree(i, 31, 13);i++;
        // Tree(i, 31, 14);i++;
        // Tree(i, 31, 15);i++;
        // Tree(i, 31, 16);i++;
        // Tree(i, 31, 17);i++;

        
        // Tree(i, 33, 12);i++;
        // Tree(i, 33, 13);i++;
        // Tree(i, 33, 14);i++;
        // Tree(i, 33, 15);i++;
        // Tree(i, 33, 16);i++;
        // Tree(i, 33, 17);i++;

        // // ////
        // Tree(i, 12, 21);i++;
        // Tree(i, 12, 22);i++;
        // Tree(i, 12, 23);i++;
        // Tree(i, 12, 24);i++;
        // Tree(i, 12, 25);i++;
        // Tree(i, 12, 26);i++;

        // Tree(i, 14, 21);i++;
        // Tree(i, 14, 22);i++;
        // Tree(i, 14, 23);i++;
        // Tree(i, 14, 24);i++;
        // Tree(i, 14, 25);i++;
        // Tree(i, 14, 26);i++;

        // Tree(i, 16, 21);i++;
        // Tree(i, 16, 22);i++;
        // Tree(i, 16, 23);i++;
        // Tree(i, 16, 24);i++;
        // Tree(i, 16, 25);i++;
        // Tree(i, 16, 26);i++;

        // Tree(i, 18, 21);i++;
        // Tree(i, 18, 22);i++;
        // Tree(i, 18, 23);i++;
        // Tree(i, 18, 24);i++;
        // Tree(i, 18, 25);i++;
        // Tree(i, 18, 26);i++;

        // Tree(i, 20, 21);i++;
        // Tree(i, 20, 22);i++;
        // Tree(i, 20, 23);i++;
        // Tree(i, 20, 24);i++;
        // Tree(i, 20, 25);i++;
        // Tree(i, 20, 26);i++;

        // Tree(i, 25, 21);i++;
        // Tree(i, 25, 22);i++;
        // Tree(i, 25, 23);i++;
        // Tree(i, 25, 24);i++;
        // Tree(i, 25, 25);i++;
        // Tree(i, 25, 26);i++;


        // Tree(i, 27, 21);i++;
        // Tree(i, 27, 22);i++;
        // Tree(i, 27, 23);i++;
        // Tree(i, 27, 24);i++;
        // Tree(i, 27, 25);i++;
        // Tree(i, 27, 26);i++;


        
        // Tree(i, 29, 21);i++;
        // Tree(i, 29, 22);i++;
        // Tree(i, 29, 23);i++;
        // Tree(i, 29, 24);i++;
        // Tree(i, 29, 25);i++;
        // Tree(i, 29, 26);i++;

        // Tree(i, 31, 21);i++;
        // Tree(i, 31, 22);i++;
        // Tree(i, 31, 23);i++;
        // Tree(i, 31, 24);i++;
        // Tree(i, 31, 25);i++;
        // Tree(i, 31, 26);i++;
        



        
    }


    public void Tree(int i, int x, int y){
        gp.obj[i] = new OBJ_Trees(gp);
        gp.obj[i].worldX = gp.tileSize*x;
        gp.obj[i].worldY = gp.tileSize*y;
    }
}
