import java.util.ArrayList;
import java.util.HashMap;
/**
 * Implementing the edge and vertex for the hypernums.
 * @author PREM
 */
public class Digraph {
    Digraph(int V) {
        map = new HashMap<Integer, ArrayList<Integer>>(V);
    }
    /**
     * This map function is used to join the index
     * between the Integere and the arraylist.
     */
    private HashMap<Integer, ArrayList<Integer>> map;
    // new HashMap<Integer, ArrayList<Integer>>();
    /**
     * This method is implemented to add the elements
     * into the hash map to form a edge and a vertex.
     *
     * @param v Key or the edge.
     * @param w vertex.
     */
    public void addEdge(final int v, final int w) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        if (map.containsKey(v)) {
            x = map.get(v);
            x.add(w);
            map.put(v, x);
            return;
        }
        x.add(w);
        map.put(v, x);
    }

    public int V() {
        return map.size();
    }

    public Iterable<Integer> adj(int v) {
        return map.get(v);
    }
}
