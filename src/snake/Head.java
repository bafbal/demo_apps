package snake;

import java.awt.*;

public class Head extends Section{

    public Head(Color bodyColor, Color skinColor, int[] coordinate) {
        super(bodyColor, skinColor,coordinate);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(skinColor);
        graphics.fillRect(coordinate[0] * gridSize, coordinate[1] * gridSize,gridSize,gridSize);
        graphics.setColor(bodyColor);
        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.1), (int) (coordinate[1] * gridSize + gridSize * 0.1), (int) (gridSize*0.8), (int) (gridSize*0.8));
//        graphics.setColor(Color.RED);
//        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.2), (int) (coordinate[1] * gridSize + gridSize * 0.2), (int) (gridSize*0.2), (int) (gridSize*0.2));
//        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.6), (int) (coordinate[1] * gridSize + gridSize * 0.2), (int) (gridSize*0.2), (int) (gridSize*0.2));
//        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.5), (int) (coordinate[1] * gridSize + gridSize * 0.5), (int) (gridSize*0.1), (int) (gridSize*0.1));
//        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.2), (int) (coordinate[1] * gridSize + gridSize * 0.6), (int) (gridSize*0.1), (int) (gridSize*0.2));
//        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.7), (int) (coordinate[1] * gridSize + gridSize * 0.6), (int) (gridSize*0.1), (int) (gridSize*0.2));
//        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.3), (int) (coordinate[1] * gridSize + gridSize * 0.7), (int) (gridSize*0.4), (int) (gridSize*0.1));
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.1), (int) (coordinate[1] * gridSize + gridSize * 0.3), (int) (gridSize*0.4), (int) (gridSize*0.4));
        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.6), (int) (coordinate[1] * gridSize + gridSize * 0.3), (int) (gridSize*0.4), (int) (gridSize*0.4));
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.2), (int) (coordinate[1] * gridSize + gridSize * 0.4), (int) (gridSize*0.2), (int) (gridSize*0.2));
        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.7), (int) (coordinate[1] * gridSize + gridSize * 0.4), (int) (gridSize*0.2), (int) (gridSize*0.2));

    }
}
