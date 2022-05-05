package spinthefox;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polyhedron {

    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();
    private List<Facet> facets = new ArrayList<>();

    public Polyhedron(String vertexFile, String facetsFile) {
        fillVertices(vertexFile);
        fillEdges(vertexFile);
        fillFacets(facetsFile);
    }

    private void fillVertices(String vertexFile){
        List<String> verticeList = Reader.read(vertexFile);
        for (String string : verticeList) {
            String[] stringArray =  string.split(",");
            vertices.add(new Vertex(Double.parseDouble(stringArray[0]),Double.parseDouble(stringArray[1]),Double.parseDouble(stringArray[2])));
        }
    }

    private void fillEdges(String vertexFile){
        List<String> verticeList = Reader.read(vertexFile);
        for (int i = 0; i < verticeList.size(); i++) {
            String[] stringArray =  verticeList.get(i).split(",");
            for (int j = 3; j < stringArray.length; j++) {
                edges.add(new Edge(vertices.get(i),vertices.get(Integer.parseInt(stringArray[j]))));
            }
        }
    }

    private void fillFacets(String facetsFile) {
        List<String> facetList = Reader.read(facetsFile);
        List<Vertex> temporaryVertices = new ArrayList<>();
        for (int i = 0; i < facetList.size(); i++) {
            String[] stringArray =  facetList.get(i).split(",");
            for (int j = 0; j < stringArray.length-3; j++) {
                temporaryVertices.add(vertices.get(Integer.parseInt(stringArray[j])));
            }
            facets.add(new Facet(temporaryVertices,new Color(Integer.parseInt(stringArray[stringArray.length-3]),Integer.parseInt(stringArray[stringArray.length-2]),Integer.parseInt(stringArray[stringArray.length-1]))));
            temporaryVertices.clear();
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Facet> getFacets() {
        return facets;
    }
}
