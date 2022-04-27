package sierpinski;

import java.awt.*;

public class Sierpinski {

    private static final int[][] iterationArray = new int[][]{
            {1, 1}, {1, 0}, {1, -1},
            {0, 1}, {0, 0}, {0, -1},
            {-1, 1}, {-1, 0}, {-1, -1}
    };

    public static void drawSquareWithGivenCentreAndSide(Graphics graphics, int centreX, int centreY, int side, int level) {
        if (level == 0) {
            return;
        }
        graphics.fillRect(centreX - side / 2, centreY - side / 2, side, side);
        for (int i = 0; i < iterationArray.length; i++) {
            drawSquareWithGivenCentreAndSide(graphics, centreX + iterationArray[i][0] * side,
                    centreY + iterationArray[i][1] * side, side / 3, level - 1);
        }
    }
}