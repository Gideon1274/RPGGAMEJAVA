package tile;

import main.GamePanel;
import main.UtilityTool;

import java.io.BufferedReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.io.InputStreamReader;
public class TileManager{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];


    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/pics/maps/mappodesu.txt");

    }
    public void getTileImage(){       
            //placeholder
            setup(0, "010", false);
            setup(1, "010", false);
            setup(2, "010", false);
            setup(3, "010", false);
            setup(4, "010", false);
            setup(5, "010", false);
            setup(6, "010", false);
            setup(7, "010", false);
            setup(8, "010", false);
            setup(9, "010", false);
            //placeholder


            setup(10, "010", false); 
            setup(11, "011", false);
            setup(12, "012", true);
            setup(13, "013", true);
            setup(14, "014", false);
            setup(15, "015", true);
            setup(16, "016", false);
            setup(17, "017", false);
            setup(18, "018", false);
            setup(19, "019", false);
            setup(20, "020", false);
            setup(21, "021", false);
            setup(22, "022", false);
            setup(23, "023", false);
            setup(24, "024", true);
            setup(25, "025", true);
            setup(26, "026", false);
            setup(27, "027", false);
            setup(28, "028", false);
            setup(29, "029", false);
            // setup(22, "022", false);
            // setup(23, "023", false);
            // setup(24, "024", false);
            // setup(25, "025", false);
            // setup(26, "026", false);
            // setup(27, "027", false);
            // setup(28, "028", false);
 



            

    }

    public void setup(int index, String imageName, boolean collision){
        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/pics/tiles/"+ imageName +".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String number[] = line.split(" ");

                    int num = Integer.parseInt(number[col]);

                    mapTileNum[col] [row] = num;
                    col++;

                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol<gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;


            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            worldCol++;


            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;


            }
        }
    }

}