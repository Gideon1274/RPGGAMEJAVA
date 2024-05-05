package data;

import entity.Entity; import main.GamePanel; import object.*;

import java.io.*;

public class SaveLoad {

GamePanel gp;

public SaveLoad(GamePanel gp)
{
    this.gp = gp;
}

public void save()
{
    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
        DataStorage ds = new DataStorage();

        //PLAYER STATS
        ds.level = gp.player.level;
        ds.maxLife = gp.player.maxLife;
        ds.life = gp.player.life;
        ds.maxMana = gp.player.maxMana;
        ds.mana = gp.player.mana;
        ds.strength = gp.player.strength;
        ds.dexterity = gp.player.dexterity;
        ds.exp = gp.player.exp;
        ds.nextLevelExp = gp.player.nextLevelExp;
        ds.coin = gp.player.coin;
        
        //PLAYER INVENTORY
        for(int i = 0;i < gp.player.inventory.size(); i++)
        {
            ds.itemNames.add(gp.player.inventory.get(i).name);
            ds.itemAmounts.add(gp.player.inventory.get(i).amount);
        }

        for(int mapNum = 0; mapNum < 2; mapNum++)
        {
            for(int i = 0; i < 500; i++)
            {
                if(gp.obj[i] == null)
                {
                    ds.mapObjectNames[mapNum][i] = "NA";
                }
                else
                {
                    ds.mapObjectNames[mapNum][i] = gp.obj[i].name;
                    ds.mapObjectWorldX[mapNum][i] = gp.obj[i].worldX;
                    ds.mapObjectWorldY[mapNum][i] = gp.obj[i].worldY;
                    
                }
            }
        }

        //Write the DataStorage object
        oos.writeObject(ds);

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
public void load()
{
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));

        //Read the DataStorage object
        DataStorage ds =  (DataStorage)ois.readObject();

        //PLAYER STATS
        gp.player.level = ds.level;
        gp.player.maxLife = ds.maxLife;
        gp.player.life = ds.life;
        gp.player.maxMana = ds.maxMana;
        gp.player.mana = ds.mana;
        gp.player.strength = ds.strength;
        gp.player.dexterity = ds.dexterity;
        gp.player.exp = ds.exp;
        gp.player.nextLevelExp = ds.nextLevelExp;
        gp.player.coin = ds.coin;

        //PLAYER INVENTORY
        gp.player.inventory.clear();
        for(int i = 0; i < ds.itemNames.size(); i++)
        {
            
            gp.player.inventory.get(i).amount = ds.itemAmounts.get(i);
        }

        //PLAYER EQUIPMENT
        gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeaponSlot);
        gp.player.currentShield = gp.player.inventory.get(ds.currentShieldSlot);
        gp.player.getAttack();
        gp.player.getDefense();
        gp.player.getPlayerAttackImageForKnight();

        //OBJECTS ON MAP
        for(int mapNum = 0; mapNum < 2; mapNum++)
        {
            for(int i = 0; i < 500; i++)
            {
                if(ds.mapObjectNames[mapNum][i].equals("NA"))
                {
                    gp.obj[i] = null;
                }
                else
                {

                    gp.obj[i].worldX = ds.mapObjectWorldX[mapNum][i];
                    gp.obj[i].worldY = ds.mapObjectWorldY[mapNum][i];
                    
                    
                    
                }

            }
        }
    } catch (Exception e) {
        System.out.println("Load Exception!");
    }
}
}