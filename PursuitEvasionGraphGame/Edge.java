

public class Edge {
    private Vertex vertex1;
    private Vertex vertex2;
    private double distance;

    public Edge(Vertex u, Vertex v, double distance) {
        this.vertex1 = u;
        this.vertex2 = v;
        this.distance = distance;
    }

    public double distance() {
        return this.distance;
    }

    public Vertex other(Vertex vertex) {
        if (vertex.equals(vertex1)) {
            return vertex2;
        } else if (vertex.equals(vertex2)) {
            return vertex1;
        } else {
            return null; // The provided vertex is not part of this edge
        }
    }

    public Vertex[] vertices() {
        return new Vertex[]{vertex1, vertex2};
    }

    // Getters for vertex1 and vertex2, if needed
    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }
}
