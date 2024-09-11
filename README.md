## Pursuit-Evasion Graph Game
# Project Overview
This project explores the application of graph theory through the simulation of a pursuit-evasion game on an undirected graph. In this interactive simulation, two players are designated as the pursuer and the evader, who navigate through a network of vertices (nodes) and edges. The pursuer's objective is to capture the evader by occupying the same vertex, while the evader tries to evade capture by moving strategically across the graph.

# Key components include:

- Vertex and Edge classes for constructing the graph's basic structure.
- A Graph class for managing the graph structure.
- Player behaviors modeled through:
- RandomPlayer
- MoveTowardsPlayerAlgorithm
- MoveAwayPlayerAlgorithm
The game’s dynamics are visualized using the GraphDisplay class, offering an interface to observe and analyze the game in action.

# Features
Graph Representation: The graph is constructed using nodes (vertices) and edges. The structure supports undirected connections, enabling flexible movements for both the pursuer and the evader.
Player Algorithms:
- RandomPlayer: Moves randomly across the graph.
- MoveTowardsPlayerAlgorithm: The pursuer moves towards the evader’s current position.
- MoveAwayPlayerAlgorithm: The evader moves away from the pursuer.
- Advanced Algorithms: The game includes advanced pursuer and evader algorithms for complex strategies.
- GraphDisplay: A visual interface showing the game state, including node positions and player movements.
