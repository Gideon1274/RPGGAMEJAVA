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

        tile = new Tile[500];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/pics/maps/mappodesu.txt");
        // loadMap("/pics/maps/worldV2.txt");

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


            setup(10, "010", false); // grass
            setup(11, "011", false); // grass
            setup(12, "012", true); // topleftedge
            setup(13, "013", true); // water
            setup(14, "014", false);
            setup(15, "015", true);
            setup(16, "016", false);
            setup(17, "017", false); // rightedge
            setup(18, "018", true); // leftedge
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
            setup(29, "029", true); // tree
            setup(30, "030", false);
            setup(31, "031", false);
            setup(32, "032", false);
            setup(33, "033", false);
            setup(34, "034", false);
            setup(35, "035", false);
            setup(36, "036", false);
            setup(37, "037", false);
            setup(38, "038", false);
            setup(39, "039", false);
            setup(40, "040", false);
            setup(41, "041", false);
            setup(42, "042", false);
            setup(43, "043", false);
            setup(44, "044", false);
            setup(45, "045", false);
            setup(46, "046", false);
            setup(47, "047", false);
            setup(48, "048", false);
            setup(49, "049", false);
            setup(50, "050", false);
            setup(51, "051", false);
            setup(52, "052", false);
            setup(53, "053", false);
            setup(54, "054", false);
            setup(55, "055", false);
            setup(56, "056", false);
            setup(57, "057", false);
            setup(58, "058", false);
            setup(59, "059", false);


            

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