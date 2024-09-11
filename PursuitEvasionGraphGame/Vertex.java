import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private List<Edge> edges; // Collection of edges incident to this vertex

    // Constructor
    public Vertex() {
        this.edges = new ArrayList<>();
    }

    // Returns the Edge that connects this Vertex with the given Vertex, if it exists
    public Edge getEdgeTo(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.getVertex1().equals(this) && edge.getVertex2().equals(vertex) ||
                edge.getVertex1().equals(vertex) && edge.getVertex2().equals(this)) {
                return edge;
            }
        }
        return null;
    }

    // Adds an Edge to the collection of Edges incident to this Vertex
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    // Removes the specified Edge from the collection of Edges incident to this Vertex
    public boolean removeEdge(Edge edge) {
        return edges.remove(edge);
    }

    // Returns a collection of all the Vertices adjacent to this Vertex
    public Iterable<Vertex> adjacentVertices() {
        List<Vertex> adjacentVertices = new ArrayList<>();
        for (Edge edge : edges) {
            Vertex adjacent = edge.getVertex1().equals(this) ? edge.getVertex2() : edge.getVertex1();
            adjacentVertices.add(adjacent);
        }
        return adjacentVertices;
    }

    // Returns a collection of all the Edges incident to this Vertex
    public Iterable<Edge> incidentEdges() {
        return edges;
    }
}
