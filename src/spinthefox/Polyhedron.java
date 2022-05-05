package spinthefox;

import java.util.ArrayList;
import java.util.List;

public class Polyhedron {

    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public Polyhedron(String file) {
        List<String> verticeList = Reader.readFile(file);
        for (String string : verticeList) {
            String[] stringArray =  string.split(",");
            vertices.add(new Vertex(Double.parseDouble(stringArray[0]),Double.parseDouble(stringArray[1]),Double.parseDouble(stringArray[2])));
        }
        for (int i = 0; i < verticeList.size(); i++) {
            String[] stringArray =  verticeList.get(i).split(",");
            for (int j = 3; j < stringArray.length; j++) {
                edges.add(new Edge(vertices.get(i),vertices.get(Integer.parseInt(stringArray[j]))));
            }
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
}
