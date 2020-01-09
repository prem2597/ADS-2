/**
 * SAP class is used to find the shortest path.
 * @author PREM
 */
public class SAP {
    /**
     * Creating an object to Digraph class.
     */
    Digraph G;
    /**
     * Creating an object to BreadthFirstDirectedPaths class.
     */
    BreadthFirstDirectedPaths bdp;
    /**
     * Creating an object to BreadthFirstDirectedPaths class.
     */
    BreadthFirstDirectedPaths bdp2;
    /**
     * Constructor to initialize the values.
     * @param G Object parameter to describe the class.
     */
    public SAP(final Digraph G) {
        this.G = new Digraph(G.V());
    }
    /**
     * The method finds the length of the shortest path.
     * @param v  Vertex.
     * @param w  Vertex.
     * @return   length of the path.
     */
    public int length(final int v, final int w) {
        bdp = new BreadthFirstDirectedPaths(G, v);
        bdp2 = new BreadthFirstDirectedPaths(G, w);
        int V = G.V();
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex "
            + v + " is not between 0 and " + (V-1));
        }
        if (w < 0 || w >= V) {
            throw new IllegalArgumentException("vertex "
            + w + " is not between 0 and " + (V-1));
        }
        int baselength = -1;
        for (int s = 0; s < G.V(); s++) {
            if (bdp.hasPathTo(s) && bdp2.hasPathTo(s)) {
                int shortestDistance = bdp.distTo(s) + bdp2.distTo(s);
                if (baselength == -1) {
                    baselength = shortestDistance;
                }
                if (baselength > shortestDistance) {
                    baselength = shortestDistance;
                }
            }
        }
        return baselength;
    }
    /**
     * The ancestor method will represent the vertex.
     * @param v  vertex.
     * @param w  vertex.
     * @return  ancestor.
     */
    public int ancestor(final int v, final int w) {
        bdp = new BreadthFirstDirectedPaths(G, v);
        bdp2 = new BreadthFirstDirectedPaths(G, w);
        int V = G.V();
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex "
            + v + " is not between 0 and " + (V - 1));
        }
        if (w < 0 || w >= V) {
            throw new IllegalArgumentException("vertex "
            + w + " is not between 0 and " + (V - 1));
        }
        int baselength = -1;
        int ancestor = -1;
        for (int s = 0; s < G.V(); s++) {
            if (bdp.hasPathTo(s) && bdp2.hasPathTo(s)) {
                int shortestDistance = bdp.distTo(s) + bdp2.distTo(s);
                if (baselength == -1) {
                    baselength = shortestDistance;
                }
                if (baselength > shortestDistance) {
                    baselength = shortestDistance;
                    ancestor = s;
                }
            }
        }
        return ancestor;
    }
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        bdp = new BreadthFirstDirectedPaths(G, v);
        bdp2 = new BreadthFirstDirectedPaths(G, w);
        int V = G.V();
        // if (v < 0 || v >= V) {
        //     throw new IllegalArgumentException("vertex "
        //     + v + " is not between 0 and " + (V-1));
        // }
        // if (w < 0 || w >= V) {
        //     throw new IllegalArgumentException("vertex "
        //     + w + " is not between 0 and " + (V-1));
        // }
        int baselength = -1;
        for (int s = 0; s < G.V(); s++) {
            if (bdp.hasPathTo(s) && bdp2.hasPathTo(s)) {
                int shortestDistance = bdp.distTo(s) + bdp2.distTo(s);
                if (baselength == -1) {
                    baselength = shortestDistance;
                }
                if (baselength > shortestDistance) {
                    baselength = shortestDistance;
                }
            }
        }
        return baselength;
    }
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        bdp = new BreadthFirstDirectedPaths(G, v);
        bdp2 = new BreadthFirstDirectedPaths(G, w);
        int V = G.V();
        // if (v < 0 || v >= V) {
        //     throw new IllegalArgumentException("vertex "
        //     + v + " is not between 0 and " + (V - 1));
        // }
        // if (w < 0 || w >= V) {
        //     throw new IllegalArgumentException("vertex "
        //     + w + " is not between 0 and " + (V - 1));
        // }
        int baselength = -1;
        int ancestor = -1;
        for (int s = 0; s < G.V(); s++) {
            if (bdp.hasPathTo(s) && bdp2.hasPathTo(s)) {
                int shortestDistance = bdp.distTo(s) + bdp2.distTo(s);
                if (baselength == -1) {
                    baselength = shortestDistance;
                }
                if (baselength > shortestDistance) {
                    baselength = shortestDistance;
                    ancestor = s;
                }
            }
        }
        return ancestor;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digrapgh G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v,w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}
