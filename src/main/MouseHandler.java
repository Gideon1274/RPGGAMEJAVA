package main;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;

public class MouseHandler extends MouseAdapter implements MouseMotionListener,MouseListener {
    
    GamePanel gp;
    Graphics2D g2;
    private static int mouseX = -1 , mouseY = -1, mouseB = -1;
    public static int getX(){
        return mouseX;
    }
    public static int getY(){
        return mouseY;
    }
    public static int getButton(){
        return mouseB;
    }
    
    public MouseHandler(GamePanel gp){
        this.gp =gp;
        
        gp.addMouseListener(this);
        gp.addMouseMotionListener(this);
    }


    public void mouseDragged(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        // leftClicked = true;
        // System.out.println("Leftclicked: "+leftClicked+"mosueX: "+mouseX+"mouseY: "+mouseY);
    }
    public void mouseMoved(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
    }
        @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        // mouseX = e.getX();
        // mouseY = e.getY();
        // mouseB = e.getButton();
        if(gp.gameState == gp.dialogueState){
            if (e.getButton() == MouseEvent.BUTTON1) {
                gp.gameState = gp.playState;
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            gp.leftClicked = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            gp.rightClicked=true;
        }
        
        // System.out.println("clicked");
    }
    public void mouseReleased(MouseEvent e){
        mouseB = -1;
        gp.leftClicked =false;
        gp.rightClicked = false;
        // System.out.println("released");
    }





    

    // // @Override
    // // public void mouseMoved(MouseEvent e) {
    // //     // Handle mouse move event
    // //     System.out.println("Mouse Moved at: " + e.getX() + ", " + e.getY());
    // // // }
    // // @Override
    // public void mouseMoved(MouseEvent e) {
    //     // Get the mouse position whenever it moves
    //     mouseX = e.getX();
    //     mouseY = e.getY();

    //     // Example: Output the current mouse position
    //     System.out.println("Mouse Moved - Current Position: " + mouseX + ", " + mouseY);

    // //     // Add more logic based on your specific requirements
    // }
    // // @Override
    // // public void mouseClicked(MouseEvent e) {
    // //     // Handle mouse click event
    // //     System.out.println("Mouse Clicked at: " + e.getX() + ", " + e.getY());
    // // }
    // // @Override
    // // public void mouseClicked(MouseEvent e) {
    // //     // Handle mouse click event
    // //     int mouseX = e.getX();
    // //     int mouseY = e.getY();

    // //     // Calculate the mouse position relative to a specific component in the game
    // //     double targetX = mouseX - (gp.getLocationOnScreen().x + gp.player.worldX);
    // //     double targetY = mouseY - (gp.getLocationOnScreen().y + gp.player.worldY);

    // //     // Example: Output the calculated target position
    // //     System.out.println("Target Position: " + targetX + ", " + targetY);
        
    // //     System.out.println();

    // //     // Add more logic based on your specific requirements
    // // }

    // @Override
    // public void mousePressed(MouseEvent e) {
    //     int code = e.getButton();
    //     if (code == MouseEvent.BUTTON1) {
    //         leftClicked = true;
    //         int mouseX = e.getX();
    //         int mouseY = e.getY();
    //         // System.out.println("Mouse Pressed at: " + mouseX + ", " + mouseY);
    //     }
    // }

    // @Override
    // public void mouseReleased(MouseEvent e) {
    //     // Handle mouse release event
    //     // System.out.println("Mouse Released at: " + e.getX() + ", " + e.getY());
    //     leftClicked = false;
    // }

    // public static void main(String[] args) {
    //     // Example of how to use the MouseHandler
    //     // Assuming you have a JFrame or JPanel
    //     // Add the following lines where you initialize your GUI components
    //     // For example, in your JFrame constructor:

    //     // JFrame frame = new JFrame("Mouse Handler Example");
    //     // frame.setSize(500, 500);
    //     // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     // JPanel panel = new JPanel();
    //     // MouseHandler mouseHandler = new MouseHandler();
    //     // panel.addMouseListener(mouseHandler);
    //     // panel.addMouseMotionListener(mouseHandler);

    //     // frame.add(panel);
    //     // frame.setVisible(true);
    // }

}

