import java.util.*;

public class AdvancedPursuerAlgorithm extends AbstractPlayerAlgorithm {
    
    public AdvancedPursuerAlgorithm(Graph graph) {
        super(graph);
    }

    @Override
    public Vertex chooseStart() {
        // Pick a random Vertex to start
        List<Vertex> vertices = new ArrayList<>();
        graph.getVertices().forEach(vertices::add);
        Vertex startVertex = vertices.get(new Random().nextInt(vertices.size()));
        setCurrentVertex(startVertex);
        return startVertex;
    }

    @Override
    public Vertex chooseStart(Vertex other) {
        // Optionally, implement a strategy for choosing a start position based on the evader's position
        return chooseStart();
    }

    @Override
    public Vertex chooseNext(Vertex otherPlayer) {
        // Move towards the other player using a simple heuristic
        Vertex currentVertex = getCurrentVertex();
        Vertex closestVertex = currentVertex;
        double shortestDistance = Double.POSITIVE_INFINITY;

        for (Vertex adjacent : currentVertex.adjacentVertices()) {
            double distance = graph.distanceFrom(adjacent).getOrDefault(otherPlayer, Double.POSITIVE_INFINITY);
            if (distance < shortestDistance) {
                shortestDistance = distance;
                closestVertex = adjacent;
            }
        }

        setCurrentVertex(closestVertex);
        return closestVertex;
    }
}
