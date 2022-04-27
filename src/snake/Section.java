package snake;

import java.awt.*;

public class Section implements Drawable{

    protected Color bodyColor;
    protected Color skinColor;
    protected int[] coordinate;
//    protected int gridSize = Game.gridSize;

    public Section(Color bodyColor, Color skinColor, int[] coordinate) {
        this.bodyColor = bodyColor;
        this.skinColor = skinColor;
        this.coordinate = new int[]{coordinate[0], coordinate[1]};
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(skinColor);
        graphics.fillRect(coordinate[0] * gridSize, coordinate[1] * gridSize,gridSize,gridSize);
        graphics.setColor(bodyColor);
        graphics.fillRect((int) (coordinate[0] * gridSize + gridSize * 0.1), (int) (coordinate[1] * gridSize + gridSize * 0.1), (int) (gridSize*0.8), (int) (gridSize*0.8));
    }

    @Override
    public void paintItBlack(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(coordinate[0] * gridSize, coordinate[1] * gridSize,gridSize,gridSize);
    }

    public void delete() {

    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }
}
