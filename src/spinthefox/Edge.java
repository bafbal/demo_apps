package spinthefox;

import java.awt.*;

public class Edge {

    private Vertex[] endpoints = new Vertex[2];

    public Edge (Vertex vertex1, Vertex vertex2) {
        endpoints[0] = vertex1;
        endpoints[1] = vertex2;
    }

    public void draw (Graphics graphics) {
        graphics.drawLine(endpoints[0].getShadow()[0],endpoints[0].getShadow()[1],endpoints[1].getShadow()[0],endpoints[1].getShadow()[1]);
    }
}
