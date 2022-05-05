package spinthefox;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Graphics graphics;
    private boolean initialized;
    private List<Polyhedron> polyhedrons = new ArrayList<>();

    public void run () {
        if (!initialized){
            polyhedrons.add(new Polyhedron("src/spinthefox/200x200x200square.csv"));
            initialized = true;
            draw();
        } else {
            draw();
        }

//

    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
        for (Polyhedron polyhedron : polyhedrons) {
            for (Edge edge : polyhedron.getEdges()) {
                edge.draw(graphics);
            }
        }
        Graphics2D g2 = (Graphics2D) graphics;
//        g2.setRenderingHint(
//                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Serif", Font.PLAIN, 32);
        g2.setFont(font);
        g2.drawString(String.valueOf((int) polyhedrons.get(0).getVertices().get(1).getXyz()[0]), 0, 200);
        g2.drawString(String.valueOf((int) polyhedrons.get(0).getVertices().get(1).getXyz()[1]), 0, 250);
        g2.drawString(String.valueOf((int) polyhedrons.get(0).getVertices().get(1).getXyz()[2]), 0, 300);
        g2.drawString(String.valueOf((int) polyhedrons.get(0).getVertices().get(1).getRadius()), 0, 350);
        g2.drawString(String.valueOf(polyhedrons.get(0).getVertices().get(1).getAngles()[0]), 0, 400);
        g2.drawString(String.valueOf(polyhedrons.get(0).getVertices().get(1).getAngles()[1]), 0, 450);
        g2.drawString(String.valueOf(polyhedrons.get(0).getVertices().get(1).getAngles()[2]), 0, 500);
    }

    public List<Polyhedron> getPolyhedrons() {
        return polyhedrons;
    }
}
