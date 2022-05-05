package spinthefox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;

public class GUI extends JComponent implements KeyListener {

    final static int height = 800;
    final static int width = 800;
    private Controller controller;

    public GUI() {
        controller = new Controller();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        controller.setGraphics(graphics);
        controller.run();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spin the Fox");
        GUI gui = new GUI();
//        frame.getContentPane().setBackground(Color.BLACK);
        frame.setPreferredSize(new Dimension(width, height));
        frame.add(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
//        gui.setBackground(Color.BLACK);
        frame.addKeyListener(gui);
//        int delay = 0; // delay for 5 sec.
//        int period = 150; // repeat every sec.
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                gui.repaint();
//            }
//        }, delay, period);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundZ((-1 * Math.PI) / 15);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundZ((Math.PI) / 15);
                }
            }
        }
        repaint();
    }

}