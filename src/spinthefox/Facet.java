package spinthefox;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Facet implements Comparable<Facet>{

    private List<Vertex> vertices = new ArrayList<>();
    private Color color;

    public Facet(List<Vertex> vertices, Color color) {
        for (Vertex vertex : vertices) {
            this.vertices.add(vertex);
        }
        this.color = color;
    }

    private int[] getXPoints() {
        int[] xPoints = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            xPoints[i] = vertices.get(i).getShadow()[0];
        }
        return xPoints;
    }

    private int[] getYPoints() {
        int[] yPoints = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            yPoints[i] = vertices.get(i).getShadow()[1];
        }
        return yPoints;
    }

    public Vertex getRearmostVertex() {
        Vertex rearmostVertex = vertices.get(0);
        for (int i = 1; i < vertices.size(); i++) {
            if (vertices.get(i).getXyz()[2] > rearmostVertex.getXyz()[2]) {
                rearmostVertex = vertices.get(i);
            }
        }
        return rearmostVertex;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillPolygon(getXPoints(), getYPoints(), getXPoints().length);
    }

    @Override
    public int compareTo(Facet other) {
        if (this.getRearmostVertex().getXyz()[2] > other.getRearmostVertex().getXyz()[2]) {
            return 1;
        } else if (this.getRearmostVertex().getXyz()[2] < other.getRearmostVertex().getXyz()[2]) {
            return -1;
        } else return 0;
    }
}
