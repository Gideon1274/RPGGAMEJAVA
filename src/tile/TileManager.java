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
        // loadMap("/pics/maps/sad.txt");
        loadMap("/pics/maps/bago.txt");

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
            setup(74, "074", false);
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


            setup(102, "102", true);
            setup(103, "103", true);
            setup(104, "104", true);
            setup(105, "105", true);
            setup(106, "106", true);
            setup(107, "107", true);
            setup(108, "108", true);
            setup(109, "109", true);
            setup(110, "110", true);
            setup(111, "111", true);
            setup(112, "112", true);
            setup(113, "113", true);
            setup(114, "114", true);
            setup(115, "115", true);

            setup(116, "116", false);
            setup(117, "117", false);
            setup(118, "118", false);
            setup(119, "119", false);
            setup(120, "120", false); 
            setup(121, "121", false); 
            setup(122, "122", false); 
            setup(123, "123", false); 
            setup(124, "124", false); 
            setup(125, "125", false); 
            setup(126, "126", false); 
            setup(127, "127", false); 
            setup(128, "128", false); 
            setup(129, "129", false); 
            setup(130, "130", false); 
            setup(131, "131", false); 
            setup(132, "132", false); 
            setup(133, "133", false); 
            setup(134, "134", false); 
            setup(135, "135", false); 
            setup(136, "136", false); 
            setup(137, "137", false); 
            setup(138, "138", false); 
            setup(139, "139", false); 

            setup(140, "140", true);
            setup(141, "141", true);
            setup(142, "142", true);
            setup(143, "143", true);
            setup(144, "144", true);
            setup(145, "145", true);
            setup(146, "146", true);
            setup(147, "147", true);
            setup(148, "148", true);
            setup(149, "149", true);
            setup(150, "150", true);
            setup(151, "151", true);
            setup(152, "152", true);
            setup(153, "153", true);
            setup(154, "154", true);
            setup(155, "155", true);
            setup(156, "156", true);
            setup(157, "157", true);
            setup(158, "158", true);
            setup(159, "159", true);
            setup(160, "160", true);
            setup(161, "161", true);
            setup(162, "162", true);
            setup(163, "163", true);
            setup(164, "164", true);
            setup(165, "165", true);
            setup(166, "166", true);
            setup(167, "167", true);
            setup(168, "168", true);
            setup(169, "169", true);
            setup(170, "170", true);
            setup(171, "171", true);
            setup(172, "172", true);
            setup(173, "173", true);
            setup(174, "174", true);
            setup(175, "175", true);
            setup(176, "176", true);
            setup(177, "177", true);
            setup(178, "178", true);
            setup(179, "179", true);
            setup(180, "180", true);
            setup(181, "181", true);
            setup(182, "182", true);
            setup(183, "183", true);
            setup(184, "184", true);
            setup(185, "185", true);
            setup(186, "186", true);
            setup(187, "187", true);
            setup(188, "188", true);
            setup(189, "189", true);
            setup(190, "190", true);
            setup(191, "191", true);
            setup(192, "192", true);
            setup(193, "193", true);
            setup(194, "194", true);
            setup(195, "195", true);
            setup(196, "196", true);
            setup(197, "197", true);
            setup(198, "198", true);
            setup(199, "199", true);

            setup(200, "200", true);
            setup(201, "201", true);
            setup(202, "202", true);
            setup(203, "203", true);
            setup(204, "204", true);
            setup(205, "205", true);
            setup(206, "206", true);
            setup(207, "207", true);
            setup(208, "208", true);
            setup(209, "209", true);
            setup(210, "210", true);
            setup(211, "211", true);
            setup(212, "212", true);
            setup(213, "213", true);
            setup(214, "214", true);
            setup(215, "215", true);
            setup(216, "216", true);
            setup(217, "217", true);
            setup(218, "218", true);
            setup(219, "219", true);
            setup(220, "220", true);
            setup(221, "221", true);
            setup(222, "222", true);
            setup(223, "223", true);
            setup(224, "224", true);
            setup(225, "225", true);
            setup(226, "226", true);
            setup(227, "227", true);
            setup(228, "228", true);
            setup(229, "229", true);
            setup(230, "230", true);
            setup(231, "231", true);
            setup(232, "232", true);
            setup(233, "233", true);
            setup(234, "234", true);
            setup(235, "235", true);
            setup(236, "236", true);
            setup(237, "237", true);
            setup(238, "238", true);
            setup(239, "239", true);
            setup(240, "240", true);
            setup(241, "241", true);
            setup(242, "242", true);
            setup(243, "243", true);
            setup(244, "244", true);
            setup(245, "245", true);
            setup(246, "246", true);
            setup(247, "247", true);
            setup(248, "248", true);
            setup(249, "249", true);
            setup(250, "250", true);
            setup(251, "251", true);
            setup(252, "252", true);
            setup(253, "253", true);
            setup(254, "254", true);
            setup(255, "255", true);
            setup(256, "256", true);
            setup(257, "257", true);
            setup(258, "258", true);
            setup(259, "259", true);
            setup(260, "260", true);
            setup(261, "261", true);
            setup(262, "262", true);
            setup(263, "263", true);
            setup(264, "264", true);
            setup(265, "265", true);
            setup(266, "266", true);
            setup(267, "267", true);
            setup(268, "268", true);
            setup(269, "269", true);
            setup(270, "270", true);
            setup(271, "271", true);
            setup(272, "272", true);
            setup(273, "273", true);
            setup(274, "274", true);
            setup(275, "275", true);
            setup(276, "276", true);
            setup(277, "277", true);
            setup(278, "278", true);
            setup(279, "279", true);
            setup(280, "280", true);
            setup(281, "281", true);
            setup(282, "282", true);
            setup(283, "283", true);
            setup(284, "284", true);
            setup(285, "285", true);
            setup(286, "286", true);
            setup(287, "287", true);
            setup(288, "288", true);
            setup(289, "289", true);
            setup(290, "290", true);
            setup(291, "291", true);
            setup(292, "292", true);
            setup(293, "293", true);
            setup(294, "294", true);
            setup(295, "295", true);
            setup(296, "296", true);
            setup(297, "297", true);
            setup(298, "298", true);
            setup(299, "299", true);
            setup(300, "300", true);
            setup(301, "301", true);
            setup(302, "302", true);
            setup(303, "303", true);
            setup(304, "304", true);
            setup(305, "305", true);
            setup(306, "306", true);
            setup(307, "307", true);
            setup(308, "308", true);
            setup(309, "309", true);
            setup(310, "310", true);
            setup(311, "311", true);
            setup(312, "312", true);
            setup(313, "313", true);
            setup(314, "314", true);
            setup(315, "315", true);
            setup(316, "316", true);
            setup(317, "317", true);
            setup(318, "318", true);
            setup(319, "319", true);
            setup(320, "320", true);
            setup(321, "321", true);
            setup(322, "322", true);
            setup(323, "323", true);
            setup(324, "324", true);
            setup(325, "325", true);
            setup(326, "326", true);
            setup(327, "327", true);
            setup(328, "328", true);
            setup(329, "329", true);
            setup(330, "330", true);
            setup(331, "331", true);
            setup(332, "332", true);
            setup(333, "333", true);

            setup(334, "334", true);
            setup(335, "335", true);
            setup(336, "336",true);
            setup(337, "337", true);
            setup(338, "338", true);
            setup(339, "339", true);
            setup(340, "340",true);
            setup(341, "341", true);
            setup(342, "342", true);
            setup(343, "343", true);
            setup(344, "344",true);
            setup(345, "345", true);
            setup(346, "346", true);
            setup(347, "347", true);
            setup(348, "348",true);

    }

    public void setup(int index, String imageName, boolean collision){
        System.out.println(index);
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
                    if (tile[tileNum] != null && tile[tileNum].image != null) {
                        g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    } else {
                        System.err.println("Error: tile[" + tileNum + "] is null or tile.image is null");
                    }
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            worldCol++;


            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;


            }
        }
        // if(drawPath == false){
        //     g2.setColor(new Color(255,0,0,70));

        //     for(int i = 0;i<gp.pFinder.pathList.size();i++){
        //         int worldX =  gp.pFinder.pathList.get(i).col*gp.tileSize;
        //         int worldY =  gp.pFinder.pathList.get(i).row*gp.tileSize;
        //         int screenX = worldX - gp.player.worldX + gp.player.screenX;
        //         int screenY = worldY - gp.player.worldY + gp.player.screenY;
                
        //         g2.fillRect(screenX,screenY, gp.tileSize, gp.tileSize);
        //     }
        // }
    }

}