package snake;

import java.awt.*;
import java.util.Random;

public class Food implements Drawable {

    private int[] coordinate;
    private Color foodColor = Color.BLUE;

    public Food() {
        coordinate = getRandomCoordinates();
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(foodColor);
        graphics.fillRect(coordinate[0] * gridSize, coordinate[1] * gridSize, gridSize, gridSize);
    }

    @Override
    public void paintItBlack(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(coordinate[0] * gridSize, coordinate[1] * gridSize, gridSize, gridSize);
    }

    public int[] getRandomCoordinates() {
        int[] coordinates = new int[2];
        Random random = new Random();
        coordinates[0] = random.nextInt(GUI.width / gridSize-1);
        coordinates[1] = random.nextInt(GUI.height / gridSize-1);
        return coordinates;
    }

    public int[] getCoordinate() {
        return coordinate;
    }
}
