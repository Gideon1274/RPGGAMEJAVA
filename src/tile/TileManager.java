package tile;

import main.GamePanel;
import main.UtilityTool;

import java.io.BufferedReader;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.io.InputStreamReader;
public class TileManager{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    boolean drawPath = false;

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[500];
        mapTileNum = new int[gp.maxWorldCol*2][gp.maxWorldRow*2];
        getTileImage();
        // loadMap("/pics/maps/mappodesu.txt");
        loadMap("/pics/maps/waltermap.txt");

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
            setup(17, "017", true); // rightedge
            setup(18, "018", false); // leftedge
            setup(19, "019", false);
            setup(20, "020", false);
            setup(21, "021", false);
            setup(22, "022", false);
            setup(23, "023", true);
            setup(24, "024", true);
            setup(25, "025", true);
            setup(26, "026", false);
            setup(27, "027", false);
            setup(28, "028", true);
            setup(29, "029", true); // tree
            setup(30, "030", true);
            setup(31, "031", true);
            setup(32, "032", true);
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
            setup(56, "056", true);
            setup(57, "057", true);
            setup(58, "058", true);
            setup(59, "059", true);
            setup(60, "060", true);//snow tree
            setup(61, "061", true);//cut tree
            setup(62, "062", true);//cut tree
            setup(63, "063", true);//cut tree
            setup(64, "064", true);
            setup(65, "065", true);
            setup(66, "066", true);
            setup(67, "067", true);
            setup(68, "068", true);
            setup(69, "069", false);
            setup(70, "070", true);
            setup(71, "071", false);
            setup(72, "072", false);
            setup(73, "073", false);
            setup(74, "074", true);
            setup(75, "075", false);
            setup(76, "076", true);
            setup(77, "077", true);
            setup(78, "078", true);
            setup(79, "079", true);
            setup(80, "080", true);
            setup(81, "081", true);
            setup(82, "082", false);
            setup(83, "083", false);
            setup(84, "084", false);
            setup(85, "085", false);
            setup(86, "086", false);
            setup(87, "087", false);
            setup(88, "088", false);
            setup(89, "089", false);
            setup(90, "090", true);
            setup(91, "091", true);//edge
            setup(92, "092", true);//edge
            setup(93, "093", true);
            setup(94, "094", true);
            setup(95, "095", true);
            setup(96, "096", true);
            setup(97, "097", true);
            setup(98, "098", true);
            setup(99, "099", true);
            setup(100, "100", true);
            setup(101, "101", true);

    }

    public void setup(int index, String imageName, boolean collision){
        // System.out.println(index);
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
        if(drawPath == false){
            g2.setColor(new Color(255,0,0,70));

            for(int i = 0;i<gp.pFinder.pathList.size();i++){
                int worldX =  gp.pFinder.pathList.get(i).col*gp.tileSize;
                int worldY =  gp.pFinder.pathList.get(i).row*gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;
                
                g2.fillRect(screenX,screenY, gp.tileSize, gp.tileSize);
            }
        }
    }

}