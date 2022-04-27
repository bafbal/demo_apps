package snake;

import java.awt.*;

public interface Drawable {

    int gridSize = 40;

    void draw(Graphics graphics);

    void paintItBlack(Graphics graphics);
}
