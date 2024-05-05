package main;

import entity.Entity;
import entity.NPC_Farmer;
import entity.NPC_FarmerNot;
import entity.NPC_OldMan;
import entity.OBJ_coTree;
import monster.MON_ArmormedDemon;
import monster.MON_Boss;
import monster.MON_Captain;
import monster.MON_Crab;
import monster.MON_GreenSlime;
import monster.MON_Grunt;
import monster.MON_PurpleDemon;
import monster.MON_RedDemon;
import monster.MON_RedDragon;
import monster.MON_Skeleton;
import monster.MON_YellowDragon;
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
import object.OBJ_Shelf;
import object.OBJ_ShelfLeft;
import object.OBJ_ShelfRight;
import object.OBJ_Shield_Blue;
import object.OBJ_Skeleton;
import object.OBJ_Torch;
import object.OBJ_Trees;
import object.OBJ_Banner;
import object.OBJ_BarrelDown;
import object.OBJ_BarrelUp;
import object.OBJ_Table;
import object.OBJ_SkeleFragment;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }

    public void setObject(){
        int i =0;
        // gp.obj[i] = new OBJ_PortalBlue(gp);
        // gp.obj[i].worldX = gp.tileSize*80;
        // gp.obj[i].worldY = gp.tileSize*47;
        // gp.obj[i].collision = false;i++;
        
        // gp.obj[i] = new OBJ_PortalOrange(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*64;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_PortalBlue(gp);
        // gp.obj[i].worldX = gp.tileSize*40;
        // gp.obj[i].worldY = gp.tileSize*86;
        // gp.obj[i].collision = false;i++;
        
        // gp.obj[i] = new OBJ_PortalOrange(gp);
        // gp.obj[i].worldX = gp.tileSize*56;
        // gp.obj[i].worldY = gp.tileSize*58;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*63;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*19;
        // gp.obj[i].worldY = gp.tileSize*63;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*29;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*33;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*36;
        // gp.obj[i].worldY = gp.tileSize*69;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*37;
        // gp.obj[i].worldY = gp.tileSize*69;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*33;
        // gp.obj[i].worldY = gp.tileSize*75;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*75;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*75;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*26;
        // gp.obj[i].worldY = gp.tileSize*75;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*37;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*79;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*87;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Torch(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*87;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Banner(gp);
        // gp.obj[i].worldX = gp.tileSize*31;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Banner(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Banner(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*87;
        // gp.obj[i].collision = false;i++;

        // gp.obj[i] = new OBJ_Banner(gp);
        // gp.obj[i].worldX = gp.tileSize*29;
        // gp.obj[i].worldY = gp.tileSize*87;
        // gp.obj[i].collision = false;i++;      

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_Shelf(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*24;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*25;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*38;
        // gp.obj[i].worldY = gp.tileSize*86;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*86;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*40;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*88;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*88;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*91;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*31;
        // gp.obj[i].worldY = gp.tileSize*91;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*91;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*91;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*82;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*24;
        // gp.obj[i].worldY = gp.tileSize*82;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfLeft(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*67;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_ShelfRight(gp);
        // gp.obj[i].worldX = gp.tileSize*40;
        // gp.obj[i].worldY = gp.tileSize*67;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_Table(gp);
        // gp.obj[i].worldX = gp.tileSize*26;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;
        
        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*27;
        // gp.obj[i].worldY = gp.tileSize*78;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*19;
        // gp.obj[i].worldY = gp.tileSize*67;
        // gp.obj[i].collision = false;
        // i++;

       

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*26;
        // gp.obj[i].worldY = gp.tileSize*67;
        // gp.obj[i].collision = false;
        // i++;

       

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*37;
        // gp.obj[i].worldY = gp.tileSize*70;
        // gp.obj[i].collision = false;
        // i++;

     

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*29;
        // gp.obj[i].worldY = gp.tileSize*70;
        // gp.obj[i].collision = false;
        // i++;

        

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*67;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*33;
        // gp.obj[i].worldY = gp.tileSize*68;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*79;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*79;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*25;
        // gp.obj[i].worldY = gp.tileSize*84;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*25;
        // gp.obj[i].worldY = gp.tileSize*85;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*88;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*31;
        // gp.obj[i].worldY = gp.tileSize*88;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*32;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*31;
        // gp.obj[i].worldY = gp.tileSize*73;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_Skeleton(gp);
        // gp.obj[i].worldX = gp.tileSize*21;
        // gp.obj[i].worldY = gp.tileSize*78;
        // gp.obj[i].collision = false;
        // i++;



        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*29;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*29;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*68;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*69;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*69;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*70;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*72;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*39;
        // gp.obj[i].worldY = gp.tileSize*73;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*75;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*30;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*20;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*20;
        // gp.obj[i].worldY = gp.tileSize*67;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*33;
        // gp.obj[i].worldY = gp.tileSize*75;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*33;
        // gp.obj[i].worldY = gp.tileSize*76;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*27;
        // gp.obj[i].worldY = gp.tileSize*78;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*27;
        // gp.obj[i].worldY = gp.tileSize*79;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*81;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*32;
        // gp.obj[i].worldY = gp.tileSize*81;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*32;
        // gp.obj[i].worldY = gp.tileSize*82;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*65;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*34;
        // gp.obj[i].worldY = gp.tileSize*66;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*77;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*22;
        // gp.obj[i].worldY = gp.tileSize*78;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*81;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*88;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*89;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*89;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*28;
        // gp.obj[i].worldY = gp.tileSize*90;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*31;
        // gp.obj[i].worldY = gp.tileSize*91;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*31;
        // gp.obj[i].worldY = gp.tileSize*92;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*24;
        // gp.obj[i].worldY = gp.tileSize*91;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*24;
        // gp.obj[i].worldY = gp.tileSize*92;
        // gp.obj[i].collision = true;
        // i++;

        // gp.obj[i] = new OBJ_BarrelUp(gp);
        // gp.obj[i].worldX = gp.tileSize*38;
        // gp.obj[i].worldY = gp.tileSize*79;
        // gp.obj[i].collision = false;
        // i++;

        // gp.obj[i] = new OBJ_BarrelDown(gp);
        // gp.obj[i].worldX = gp.tileSize*38;
        // gp.obj[i].worldY = gp.tileSize*80;
        // gp.obj[i].collision = true;
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
        //  gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;
        // gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
        // gp.obj[i].worldY = gp.tileSize*27;
        // i++;gp.obj[i] = new OBJ_Potion_Red(gp);
        // gp.obj[i].worldX = gp.tileSize*23;
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
        int i=0;
        gp.npc[i] = new NPC_FarmerNot(gp);
        gp.npc[i].worldX = gp.tileSize*17;
        gp.npc[i].worldY = gp.tileSize*35;i++;

        gp.npc[i] = new NPC_FarmerNot(gp);
        gp.npc[i].worldX = gp.tileSize*17;
        gp.npc[i].worldY = gp.tileSize*34;i++;
        

        gp.npc[i] = new NPC_Farmer(gp);
        gp.npc[i].worldX = gp.tileSize*20;
        gp.npc[i].worldY = gp.tileSize*11;i++;
        
        gp.npc[i] = new NPC_Farmer (gp);
        gp.npc[i].worldX = gp.tileSize*30;
        gp.npc[i].worldY = gp.tileSize*14;i++;
        
        gp.npc[i] = new NPC_Farmer (gp);
        gp.npc[i].worldX = gp.tileSize*34;
        gp.npc[i].worldY = gp.tileSize*22;i++;
        
        gp.npc[i] = new NPC_Farmer (gp);
        gp.npc[i].worldX = gp.tileSize*38;
        gp.npc[i].worldY = gp.tileSize*35;i++;
        
        gp.npc[i] = new NPC_Farmer (gp);
        gp.npc[i].worldX = gp.tileSize*30;
        gp.npc[i].worldY = gp.tileSize*40;i++;
        
        // for(int q=17;q<=82;q++){
        //     for(int j=49;j<=54;j++){
        //         setcoTree(i, q, j);i++;    
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
    public void setMonster(){
        int i  = 0;
        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 33;
        // gp.monster[i].worldY = gp.tileSize * 48;
        // i++;
        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 34;
        // gp.monster[i].worldY = gp.tileSize * 48;
        // i++;
        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 45;
        // gp.monster[i].worldY = gp.tileSize * 45;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 43;
        // gp.monster[i].worldY = gp.tileSize * 35;
        // i++;
        
        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 43;
        // gp.monster[i].worldY = gp.tileSize * 35;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 45;
        // gp.monster[i].worldY = gp.tileSize * 26;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 46;
        // gp.monster[i].worldY = gp.tileSize * 26;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 49;
        // gp.monster[i].worldY = gp.tileSize * 26;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 51;
        // gp.monster[i].worldY = gp.tileSize * 26;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 49;
        // gp.monster[i].worldY = gp.tileSize * 36;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 52;
        // gp.monster[i].worldY = gp.tileSize * 38;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 54;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 55;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 56;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 57;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 58;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 55;
        // gp.monster[i].worldY = gp.tileSize * 26;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 55;
        // gp.monster[i].worldY = gp.tileSize * 27;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 55;
        // gp.monster[i].worldY = gp.tileSize * 28;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 60;
        // gp.monster[i].worldY = gp.tileSize * 30;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 60;
        // gp.monster[i].worldY = gp.tileSize * 31;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 60;
        // gp.monster[i].worldY = gp.tileSize * 32;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 60;
        // gp.monster[i].worldY = gp.tileSize * 33;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 62;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 63;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 64;
        // gp.monster[i].worldY = gp.tileSize * 42;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 76;
        // gp.monster[i].worldY = gp.tileSize * 31;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 76;
        // gp.monster[i].worldY = gp.tileSize * 32;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 76;
        // gp.monster[i].worldY = gp.tileSize * 33;
        // i++;
        

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 80;
        // gp.monster[i].worldY = gp.tileSize * 10;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 80;
        // gp.monster[i].worldY = gp.tileSize * 11;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 80;
        // gp.monster[i].worldY = gp.tileSize * 12;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 80;
        // gp.monster[i].worldY = gp.tileSize * 13;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 80;
        // gp.monster[i].worldY = gp.tileSize * 14;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 66;
        // gp.monster[i].worldY = gp.tileSize * 10;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 66;
        // gp.monster[i].worldY = gp.tileSize * 11;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 66;
        // gp.monster[i].worldY = gp.tileSize * 12;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 66;
        // gp.monster[i].worldY = gp.tileSize * 13;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 66;
        // gp.monster[i].worldY = gp.tileSize * 14;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 47;
        // gp.monster[i].worldY = gp.tileSize * 20;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 48;
        // gp.monster[i].worldY = gp.tileSize * 20;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 49;
        // gp.monster[i].worldY = gp.tileSize * 20;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 50;
        // gp.monster[i].worldY = gp.tileSize * 20;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 51;
        // gp.monster[i].worldY = gp.tileSize * 20;
        // i++;

        // gp.monster[i] = new MON_Captain(gp);
        // gp.monster[i].worldX = gp.tileSize * 49;
        // gp.monster[i].worldY = gp.tileSize * 13;
        // i++;







        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 29;
        // gp.monster[i].worldY = gp.tileSize * 69;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 31;
        // gp.monster[i].worldY = gp.tileSize * 68;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 32;
        // gp.monster[i].worldY = gp.tileSize * 70;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 33;
        // gp.monster[i].worldY = gp.tileSize * 67;
        // i++;

        // gp.monster[i] = new MON_GreenSlime(gp);
        // gp.monster[i].worldX = gp.tileSize * 40;
        // gp.monster[i].worldY = gp.tileSize * 70;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 40;
        // gp.monster[i].worldY = gp.tileSize * 71;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 29;
        // gp.monster[i].worldY = gp.tileSize * 78;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 24;
        // gp.monster[i].worldY = gp.tileSize * 80;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 29;
        // gp.monster[i].worldY = gp.tileSize * 81;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 33;
        // gp.monster[i].worldY = gp.tileSize * 81;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 40;
        // gp.monster[i].worldY = gp.tileSize * 82;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 38;
        // gp.monster[i].worldY = gp.tileSize * 85;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 26;
        // gp.monster[i].worldY = gp.tileSize * 90;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 26;
        // gp.monster[i].worldY = gp.tileSize * 91;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 31;
        // gp.monster[i].worldY = gp.tileSize * 90;
        // i++;

        // gp.monster[i] = new MON_Skeleton(gp);
        // gp.monster[i].worldX = gp.tileSize * 21;
        // gp.monster[i].worldY = gp.tileSize * 92;
        // i++;

        // gp.monster[i] = new MON_RedDragon(gp);
        // gp.monster[i].worldX = gp.tileSize * 7;
        // gp.monster[i].worldY = gp.tileSize * 74;
        // i++;

        // gp.monster[i] = new MON_YellowDragon(gp);
        // gp.monster[i].worldX = gp.tileSize * 7;
        // gp.monster[i].worldY = gp.tileSize * 76;
        // i++;

        // gp.monster[i] = new MON_RedDragon(gp);
        // gp.monster[i].worldX = gp.tileSize * 7;
        // gp.monster[i].worldY = gp.tileSize * 78;
        // i++;


        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 55;
        // gp.monster[i].worldY = gp.tileSize * 55;
        // i++;
        // gp.monster[i] = new MON_PurpleDemon(gp);
        // gp.monster[i].worldX = gp.tileSize * 60;
        // gp.monster[i].worldY = gp.tileSize * 60;
        // i++;gp.monster[i] = new MON_RedDemon(gp);
        // gp.monster[i].worldX = gp.tileSize * 57;
        // gp.monster[i].worldY = gp.tileSize * 70;
        // i++;gp.monster[i] = new MON_YellowDragon(gp);
        // gp.monster[i].worldX = gp.tileSize * 81;
        // gp.monster[i].worldY = gp.tileSize * 87;
        // i++;gp.monster[i] = new MON_PurpleDemon(gp);
        // gp.monster[i].worldX = gp.tileSize * 70;
        // gp.monster[i].worldY = gp.tileSize * 55;
        // i++;

        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 62;
        // gp.monster[i].worldY = gp.tileSize * 62;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 61;
        // gp.monster[i].worldY = gp.tileSize * 84;
        // i++;gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 84;
        // gp.monster[i].worldY = gp.tileSize * 60;
        // i++;
        // gp.monster[i] = new MON_Crab(gp);
        // gp.monster[i].worldX = gp.tileSize * 75;    
        // gp.monster[i].worldY = gp.tileSize * 75;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 70;
        // gp.monster[i].worldY = gp.tileSize * 67;
        // i++;
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 71;
        // gp.monster[i].worldY = gp.tileSize * 69;
        // i++;
        
        // gp.monster[i] = new MON_Grunt(gp);
        // gp.monster[i].worldX = gp.tileSize * 72;
        // gp.monster[i].worldY = gp.tileSize * 60;
        // i++;

        // gp.monster[i] = new MON_Boss(gp);
        // gp.monster[i].worldX = gp.tileSize * 70;
        // gp.monster[i].worldY = gp.tileSize * 122;
        // i++;
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
