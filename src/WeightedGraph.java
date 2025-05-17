import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();
    private boolean directed;

    public WeightedGraph(){
        this(false);
    }

    public WeightedGraph(boolean directed){
        this.directed = directed;
    }

    public void addVertex(V data){
        if (!vertices.containsKey(data)){
            vertices.put(data,new Vertex<>(data));
        }
    }

    public void addEdge(V sourceData,V destinationData,double weight){
        if(!hasVertex(sourceData)){
            addVertex(sourceData);
        }
        if(!hasVertex(destinationData)){
            addVertex(destinationData);
        }

        Vertex<V> source = getVertex(sourceData);
        Vertex<V> destination = getVertex(destinationData);
        source.addAdjacentVertex(destination,weight);
        if(!directed){
            destination.addAdjacentVertex(source,weight);
        }
    }

    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices(){
        return vertices.values();
    }
}
