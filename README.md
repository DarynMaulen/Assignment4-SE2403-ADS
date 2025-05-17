# Java Graph Search

Weighted graph + BFS & Dijkstra in Java

## Classes

- **Vertex<V>.java**  
  Holds a value data and a map of neighbors with weights

- **WeightedGraph<V>.java**  
  Manages vertices and directed/undirected edges with weights

- **Search<V>.java**  
  Base class: stores visited set and edgeTo map, provides pathTo()

- **BreadthFirstSearch<V>.java**  
  Extends Search: finds shortest path by number of edges (BFS)

- **DijkstraSearch<V>.java**  
  Extends Search: finds shortest path by total weight (Dijkstra)

- **Main.java**  
  Demo: builds a sample graph, runs both searches, prints paths
