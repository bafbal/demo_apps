package sierpinski;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {

    final static int height = 1000;
    final static int width = 1000;
    private int[][] iterationArray;
    private Sierpinski sierpinski;


    public Canvas() {
        iterationArray = new int[][]{{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, 0}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.BLACK);
        Sierpinski.drawSquareWithGivenCentreAndSide(graphics,width / 2, height / 2, height / 3, 6);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski carpet");
        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(height, width));
        canvas.setVisible(true);
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}