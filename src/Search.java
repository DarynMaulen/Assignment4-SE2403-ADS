import java.util.*;

public class Search<V> {
    protected Set<Vertex<V>> visited;
    protected Map<Vertex<V>,Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex<V> source){
        this.source = source;
        visited = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v){
        return visited.contains(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v){
        if(!hasPathTo(v)) {
            return null;
        }

        LinkedList<Vertex<V>> li = new LinkedList<>();
        while(!v.equals(source)){
            li.push(v);
            v = edgeTo.get(v);
        }
        li.push(source);
        return li;
    }
}
