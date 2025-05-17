import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private V data;

    private Map<Vertex<V>, Double> adjacentVertices;

    public void addAdjacentVertex(Vertex<V> destination,double weight){
        adjacentVertices.put(destination,weight);
    }

    public Vertex(V data){
        setData(data);
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>,Double> getAdjacentVertices(){
        return adjacentVertices;
    }

    public void setData(V data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Vertex{" + "data=" + data + '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(data);
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        Vertex<V> other = (Vertex<V>) o;
        return Objects.equals(data,other.data);
    }
}
