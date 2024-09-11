import java.util.*;

public class AdvancedEvaderAlgorithm extends AbstractPlayerAlgorithm {
    
    public AdvancedEvaderAlgorithm(Graph graph) {
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
        // Optionally, implement a strategy for choosing a start position based on the pursuer's position
        return chooseStart();
    }

    @Override
    public Vertex chooseNext(Vertex otherPlayer) {
        // Move away from the other player
        Vertex currentVertex = getCurrentVertex();
        Vertex farthestVertex = currentVertex;
        double longestDistance = -1;

        for (Vertex adjacent : currentVertex.adjacentVertices()) {
            double distance = graph.distanceFrom(adjacent).getOrDefault(otherPlayer, -1.0);
            if (distance > longestDistance) {
                longestDistance = distance;
                farthestVertex = adjacent;
            }
        }

        setCurrentVertex(farthestVertex);
        return farthestVertex;
    }
}
