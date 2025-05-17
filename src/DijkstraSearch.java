import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph,Vertex<V> source){
        super(source);
        dijkstra(graph,source);
    }

    private void dijkstra(WeightedGraph<V> graph,Vertex<V> source){
        Map<Vertex<V>,Double> distTo = new HashMap<>();
        for (Vertex<V> v : graph.getAllVertices()){
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source,0.0);

        PriorityQueue<Vertex<V>> pQueue =
                new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        pQueue.add(source);

        while (!pQueue.isEmpty()){
            Vertex<V> current = pQueue.poll();
            if(visited.contains(current)){
                continue;
            }
            visited.add(current);

            for (Map.Entry<Vertex<V>,Double> entry : current.getAdjacentVertices().entrySet()){
                Vertex<V> neighborVertex = entry.getKey();
                double neighborWeight = entry.getValue();

                double neighborNewWeight = distTo.get(current) + neighborWeight;
                if(neighborNewWeight<distTo.get(neighborVertex)){
                    distTo.put(neighborVertex,neighborNewWeight);
                    edgeTo.put(neighborVertex,current);
                    pQueue.remove(neighborVertex);
                    pQueue.add(neighborVertex);
                }
            }
        }
    }
}
