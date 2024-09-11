import java.util.*;

public class MoveAwayPlayerAlgorithm extends AbstractPlayerAlgorithm {
    private Random random;

    public MoveAwayPlayerAlgorithm(Graph graph) {
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
        // This method is not used, but if required, it can also pick a random Vertex.
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
