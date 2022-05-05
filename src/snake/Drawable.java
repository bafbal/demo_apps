package snake;

import java.awt.*;

public interface Drawable {

    int gridSize = 30;

    void draw(Graphics graphics);

    void paintItBlack(Graphics graphics);
}
