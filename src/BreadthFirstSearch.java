import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph,Vertex<V> source){
        super(source);
        bfs(graph,source);
    }

    private void bfs(WeightedGraph<V> graph,Vertex<V> current){
        visited.add(current);
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()){
            Vertex<V> removed = queue.poll();
            for(Vertex<V> vertex : removed.getAdjacentVertices().keySet()){
                if(!visited.contains(vertex)){
                    visited.add(vertex);
                    edgeTo.put(vertex,removed);
                    queue.add(vertex);
                }
            }
        }
    }
}
