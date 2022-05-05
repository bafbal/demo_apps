package spinthefox;

import java.awt.*;

public class Controller {

    Graphics graphics;

    public void run () {
        Polyhedron polyhedron = new Polyhedron("src/spinthefox/200x200x200square.csv");
        for (Vertex vertex : polyhedron.getVertices()) {
            vertex.rotateAroundZ((Math.PI)/8);
        }
        for (Edge edge : polyhedron.getEdges()) {
            edge.draw(graphics);
        }
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
