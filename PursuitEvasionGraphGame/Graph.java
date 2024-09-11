import java.io.*;
import java.util.*;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    // Default constructor
    public Graph() {
        this(0, 0.0);
    }

    // Constructor with a specified number of vertices (no edges)
    public Graph(int n) {
        this(n, 0.0);
    }

    // Constructor with a specified number of vertices and edge probability
    public Graph(int n, double probability) {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            vertices.add(new Vertex());
        }

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (random.nextDouble() < probability) {
                    Vertex u = vertices.get(i);
                    Vertex v = vertices.get(j);
                    Edge edge = new Edge(u, v, 1.0);
                    edges.add(edge);
                    u.addEdge(edge);
                    v.addEdge(edge);
                }
            }
        }
    }

    // Constructor that reads from a file
    public Graph(String filename) {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            Integer numVertices = Integer.valueOf(br.readLine().split(": ")[1]);
            for (int i = 0; i < numVertices; i++) {
                vertices.add(new Vertex());
            }

            br.readLine(); // Skip the header
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Integer start = Integer.valueOf(arr[0]);
                Integer end = Integer.valueOf(arr[1]);
                Edge edge = new Edge(vertices.get(start), vertices.get(end), 1.0);
                vertices.get(start).addEdge(edge);
                vertices.get(end).addEdge(edge);
                edges.add(edge);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Graph constructor:: unable to open file " + filename + ": file not found");
        } catch (IOException ex) {
            System.out.println("Graph constructor:: error reading file " + filename);
        }
    }

        // Basic Graph Operations
    public int size() {
        return vertices.size();
    }

    public Iterable<Vertex> getVertices() {
        return vertices;
    }

    public Iterable<Edge> getEdges() {
        return edges;
    }

    public Vertex addVertex() {
        Vertex v = new Vertex();
        vertices.add(v);
        return v;
    }

    public Edge addEdge(Vertex u, Vertex v, double distance) {
        Edge e = new Edge(u, v, distance);
        edges.add(e);
        u.addEdge(e);
        v.addEdge(e);
        return e;
    }

    public Edge getEdge(Vertex u, Vertex v) {
        for (Edge e : edges) {
            if (e.getVertex1().equals(u) && e.getVertex2().equals(v) ||
                e.getVertex1().equals(v) && e.getVertex2().equals(u)) {
                return e;
            }
        }
        return null;
    }

    public boolean remove(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            return false;
        }
        // Remove edges associated with the vertex
        vertex.incidentEdges().forEach(this::remove);
        vertices.remove(vertex);
        return true;
    }

    public boolean remove(Edge edge) {
        if (!edges.contains(edge)) {
            return false;
        }
        edge.getVertex1().removeEdge(edge);
        edge.getVertex2().removeEdge(edge);
        edges.remove(edge);
        return true;
    }

    // Dijkstra's Algorithm
    public HashMap<Vertex, Double> distanceFrom(Vertex source) {
        HashMap<Vertex, Double> distances = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Vertex v : vertices) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Edge edge : current.incidentEdges()) {
                Vertex neighbor = edge.other(current);
                double distanceThroughU = distances.get(current) + edge.distance();
                if (distanceThroughU < distances.get(neighbor)) {
                    queue.remove(neighbor);
                    distances.put(neighbor, distanceThroughU);
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }
}