package main;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseAdapter;

public class MouseHandler extends MouseAdapter implements MouseMotionListener {
    public boolean leftClicked = false;
    GamePanel gp;
    public MouseHandler(GamePanel gp){
        this.gp =gp;
        gp.addMouseListener(this);
        gp.addMouseMotionListener(this);
    }

    

    // @Override
    // public void mouseMoved(MouseEvent e) {
    //     // Handle mouse move event
    //     System.out.println("Mouse Moved at: " + e.getX() + ", " + e.getY());
    // }
    @Override
    public void mouseMoved(MouseEvent e) {
        // Get the mouse position whenever it moves
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Example: Output the current mouse position
        System.out.println("Mouse Moved - Current Position: " + mouseX + ", " + mouseY);

        // Add more logic based on your specific requirements
    }
    // @Override
    // public void mouseClicked(MouseEvent e) {
    //     // Handle mouse click event
    //     System.out.println("Mouse Clicked at: " + e.getX() + ", " + e.getY());
    // }
    // @Override
    // public void mouseClicked(MouseEvent e) {
    //     // Handle mouse click event
    //     int mouseX = e.getX();
    //     int mouseY = e.getY();

    //     // Calculate the mouse position relative to a specific component in the game
    //     double targetX = mouseX - (gp.getLocationOnScreen().x + gp.player.worldX);
    //     double targetY = mouseY - (gp.getLocationOnScreen().y + gp.player.worldY);

    //     // Example: Output the calculated target position
    //     System.out.println("Target Position: " + targetX + ", " + targetY);
        
    //     System.out.println();

    //     // Add more logic based on your specific requirements
    // }

    @Override
    public void mousePressed(MouseEvent e) {
        int code = e.getButton();
        if (code == MouseEvent.BUTTON1) {
            leftClicked = true;
            int mouseX = e.getX();
            int mouseY = e.getY();
            System.out.println("Mouse Pressed at: " + mouseX + ", " + mouseY);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse release event
        System.out.println("Mouse Released at: " + e.getX() + ", " + e.getY());
        leftClicked = false;
    }

    public static void main(String[] args) {
        // Example of how to use the MouseHandler
        // Assuming you have a JFrame or JPanel
        // Add the following lines where you initialize your GUI components
        // For example, in your JFrame constructor:

        // JFrame frame = new JFrame("Mouse Handler Example");
        // frame.setSize(500, 500);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel panel = new JPanel();
        // MouseHandler mouseHandler = new MouseHandler();
        // panel.addMouseListener(mouseHandler);
        // panel.addMouseMotionListener(mouseHandler);

        // frame.add(panel);
        // frame.setVisible(true);
    }

}

