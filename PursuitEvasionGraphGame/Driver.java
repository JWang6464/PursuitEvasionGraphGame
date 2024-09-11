public class Driver {

    public Driver(int n, double p) throws InterruptedException{
        // Create a random graph on which to play
        Graph graph = new Graph(n, p);

        // Create the pursuer and evader
        // AbstractPlayerAlgorithm pursuer = new MoveTowardsPlayerAlgorithm(graph);
        // AbstractPlayerAlgorithm evader = new MoveAwayPlayerAlgorithm(graph);

        // **EXTENSION** Uncomment below to use the advanced algorithms and then comment the above original player algorithms
        AbstractPlayerAlgorithm pursuer = new AdvancedPursuerAlgorithm(graph);
        AbstractPlayerAlgorithm evader = new AdvancedEvaderAlgorithm(graph);

        // Have each player choose a starting location
        pursuer.chooseStart();
        // Since the evader has a harder objective, they get to play second
        // and see where the pursuer chose
        evader.chooseStart(pursuer.getCurrentVertex());

        // Make the display
        GraphDisplay display = new GraphDisplay(graph, pursuer, evader, 40);
        display.repaint();

        // Play the game until the pursuer captures the evader
        while (pursuer.getCurrentVertex() != evader.getCurrentVertex()){
            Thread.sleep(500);
            pursuer.chooseNext(evader.getCurrentVertex());
            display.repaint();
            if (pursuer.getCurrentVertex() != evader.getCurrentVertex()){
                Thread.sleep(500);
                evader.chooseNext(pursuer.getCurrentVertex());
                display.repaint();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int n = 10;
        double p = 0.3;
        new Driver(n, p);
    }
}