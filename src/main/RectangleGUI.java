package main;

import javax.swing.*;
import java.awt.*;

public class RectangleGUI extends JFrame {

    public RectangleGUI() {
        setTitle("Rectangle GUI");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a custom panel to draw the rectangle
        RectanglePanel rectanglePanel = new RectanglePanel();
        add(rectanglePanel);

        setVisible(true);
    }

    // Custom JPanel for drawing the rectangle
    private static class RectanglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Set color to blue for the rectangle
            g.setColor(Color.BLUE);

            // Create a rectangle at coordinates (50, 50) with width 100 and height 80
            int x = 0;
            int y = 0;
            int width = 100;
            int height = 100;

            // Draw the rectangle
            g.fillRect(x, y, width, height);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RectangleGUI());
    }
}
