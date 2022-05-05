package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;

public class GUI extends JComponent implements KeyListener {

    final static int height = 1000;
    final static int width = 1000;
    private Game game;

    public GUI() {
        game = new Game();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        game.setGraphics(graphics);
        game.run();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        GUI gui = new GUI();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setPreferredSize(new Dimension(width, height));
        frame.add(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        gui.setBackground(Color.BLACK);
        frame.addKeyListener(gui);
        int delay = 0; // delay for 5 sec.
        int period = 150; // repeat every sec.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                gui.repaint();
            }
        }, delay, period);
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
            if (game.getSnakes().get(0).getSections().get(1).getCoordinate()[1] != game.getSnakes().get(0).getSections().get(0).getCoordinate()[1] - 1) {
                game.getSnakes().get(0).setDirection(0, -1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (game.getSnakes().get(0).getSections().get(1).getCoordinate()[1] != game.getSnakes().get(0).getSections().get(0).getCoordinate()[1] + 1) {
                game.getSnakes().get(0).setDirection(0, 1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (game.getSnakes().get(0).getSections().get(1).getCoordinate()[0] != game.getSnakes().get(0).getSections().get(0).getCoordinate()[0] - 1) {
                game.getSnakes().get(0).setDirection(-1, 0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (game.getSnakes().get(0).getSections().get(1).getCoordinate()[0] != game.getSnakes().get(0).getSections().get(0).getCoordinate()[0] + 1) {
                game.getSnakes().get(0).setDirection(1, 0);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            if (game.getSnakes().get(1).getSections().get(1).getCoordinate()[1] != game.getSnakes().get(1).getSections().get(0).getCoordinate()[1] - 1) {
                game.getSnakes().get(1).setDirection(0, -1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (game.getSnakes().get(1).getSections().get(1).getCoordinate()[1] != game.getSnakes().get(1).getSections().get(0).getCoordinate()[1] + 1) {
                game.getSnakes().get(1).setDirection(0, 1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (game.getSnakes().get(1).getSections().get(1).getCoordinate()[0] != game.getSnakes().get(1).getSections().get(0).getCoordinate()[0] - 1) {
                game.getSnakes().get(1).setDirection(-1, 0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (game.getSnakes().get(1).getSections().get(1).getCoordinate()[0] != game.getSnakes().get(1).getSections().get(0).getCoordinate()[0] + 1) {
                game.getSnakes().get(1).setDirection(1, 0);
            }
        }




    }
}