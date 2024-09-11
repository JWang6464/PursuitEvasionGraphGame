import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPlayer extends AbstractPlayerAlgorithm {
    private Random random;

    // Constructor
    public RandomPlayer(Graph graph) {
        super(graph);
        this.random = new Random();
    }

    @Override
    public Vertex chooseStart() {
        List<Vertex> vertices = new ArrayList<>();
        graph.getVertices().forEach(vertices::add);
        Vertex startVertex = vertices.get(random.nextInt(vertices.size()));
        setCurrentVertex(startVertex);
        return startVertex;
    }

    @Override
    public Vertex chooseStart(Vertex other) {
        // This implementation does not use the position of the other player
        return chooseStart();
    }

    @Override
    public Vertex chooseNext(Vertex otherPlayer) {
        List<Vertex> adjacentVertices = new ArrayList<>();
        getCurrentVertex().adjacentVertices().forEach(adjacentVertices::add);
        adjacentVertices.add(getCurrentVertex()); // Include the current vertex for the possibility of staying still

        Vertex nextVertex = adjacentVertices.get(random.nextInt(adjacentVertices.size()));
        setCurrentVertex(nextVertex);
        return nextVertex;
    }
}
