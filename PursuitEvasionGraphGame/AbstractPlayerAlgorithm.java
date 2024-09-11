public abstract class AbstractPlayerAlgorithm {
    protected Graph graph;
    protected Vertex currentVertex;

    // Constructor
    public AbstractPlayerAlgorithm(Graph graph) {
        this.graph = graph;
    }

    // Returns the underlying graph
    public Graph getGraph() {
        return this.graph;
    }

    // Returns the current vertex of the player
    public Vertex getCurrentVertex() {
        return this.currentVertex;
    }

    // Updates the current vertex of the player
    public void setCurrentVertex(Vertex vertex) {
        this.currentVertex = vertex;
    }

    // Abstract method to choose the starting vertex
    public abstract Vertex chooseStart();

    // Abstract method to choose the starting vertex based on the other player's position
    public abstract Vertex chooseStart(Vertex other);

    // Abstract method to choose the next vertex based on the other player's position
    public abstract Vertex chooseNext(Vertex otherPlayer);
}
