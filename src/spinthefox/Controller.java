package spinthefox;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {

    private Graphics graphics;
    private boolean initialized;
    private List<Polyhedron> polyhedrons = new ArrayList<>();

    public void run() {
        if (!initialized) {
            polyhedrons.add(new Polyhedron("src/spinthefox/200x200x200square.csv", "src/spinthefox/200x200x200xsquarefacets.csv"));
            initialized = true;
            draw();
        } else {
            draw();
        }
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
        for (Polyhedron polyhedron : polyhedrons) {
            polyhedron.getFacets().stream()
                    .sorted(Comparator.reverseOrder())
                    .forEach(f -> f.draw(graphics));
        }
    }

    public void drawEdges() {
        for (Polyhedron polyhedron : polyhedrons) {
            for (Edge edge : polyhedron.getEdges()) {
                edge.draw(graphics);
            }
        }
    }

    public List<Polyhedron> getPolyhedrons() {
        return polyhedrons;
    }
}
