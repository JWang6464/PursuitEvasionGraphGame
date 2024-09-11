import java.util.*;

public class MoveTowardsPlayerAlgorithm extends AbstractPlayerAlgorithm {
    private Random random;

    public MoveTowardsPlayerAlgorithm(Graph graph) {
        super(graph);
        this.random = new Random();
    }

    @Override
    public Vertex chooseStart() {
        // Pick a random Vertex to start
        List<Vertex> vertices = new ArrayList<>();
        graph.getVertices().forEach(vertices::add);
        Vertex startVertex = vertices.get(random.nextInt(vertices.size()));
        setCurrentVertex(startVertex);
        return startVertex;
    }

    @Override
    public Vertex chooseStart(Vertex other) {
        // Move directly to the other player's position (not used in game)
        setCurrentVertex(other);
        return other;
    }

    @Override
    public Vertex chooseNext(Vertex otherPlayer) {
        // Move towards the other player
        Vertex currentVertex = getCurrentVertex();
        Vertex closestVertex = currentVertex;
        double shortestDistance = Double.MAX_VALUE;

        for (Vertex adjacent : currentVertex.adjacentVertices()) {
            double distance = graph.distanceFrom(adjacent).getOrDefault(otherPlayer, Double.MAX_VALUE);
            if (distance < shortestDistance) {
                shortestDistance = distance;
                closestVertex = adjacent;
            }
        }

        setCurrentVertex(closestVertex);
        return closestVertex;
    }
}
