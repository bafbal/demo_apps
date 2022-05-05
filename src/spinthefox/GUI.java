package spinthefox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JComponent implements KeyListener {

    final static int rotationSpeed = 60;
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
        frame.setPreferredSize(new Dimension(width, height));
        frame.add(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(gui);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundX((Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundX((-1 * Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundY((Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundY((-1 * Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundZ((Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundZ((-1 * Math.PI) / rotationSpeed);
                }
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundX((Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundX((-1 * Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundY((Math.PI) / 15);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundY((-1 * Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundZ((Math.PI) / rotationSpeed);
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            for (Polyhedron polyhedron : controller.getPolyhedrons()) {
                for (Vertex vertex : polyhedron.getVertices()) {
                    vertex.rotateAroundZ((-1 * Math.PI) / rotationSpeed);
                }
            }
        }
        repaint();
    }

}