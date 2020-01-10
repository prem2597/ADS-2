import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Implementing the edge and vertex for the hypernums.
 * @author PREM
 */
public class Digraph {
    private int v;
    private int[] indegree;
    int vertex;
    Digraph(final int V) {
        map = new HashMap<Integer, ArrayList<Integer>>(V);
        vertex = V;
    }
    // public Digraph(Scanner sc) {
    //     if (sc == null) {
    //         throw new IllegalArgumentException("argument is null");
    //     }
    //     try {
    //         String[] name = sc.nextLine().split(" ");
    //         this.v = Integer.parseInt(name[0]);
    //         if (this.v < 0) {
    //             throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
    //         }
    //         indegree = new int[this.v];

    //     } catch(NoSuchElementException e) {
    //         throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
    //     }
	// }
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
        if (v < 0) {
            throw new IllegalArgumentException("vertices"
             + " in a Digraph must be nonnegative");
        }
        if (map.containsKey(v)) {
            x = map.get(v);
            if (x.contains(w)) {
                return;
            }
            x.add(w);
            map.put(v, x);
            return;
        }
        x.add(w);
        map.put(v, x);
    }
    /**
     * To return the size.
     * @return size.
     */
    public int V() {
        return vertex;
    }
    /**
     * To iterate the loop.
     * @param v size
     * @return iterator.
     */
    public Iterable<Integer> adj(final int v) {
        if (v < 0) {
            throw new IllegalArgumentException(" Size should"
             + " be greater than zero");
        }
        if (map.containsKey(v)) {
            return map.get(v);
        }
        return null;
        // if (v < map.size()) {
        //     return map.get(v);
        // } else {
        //     return null;
        // }
    }
}
