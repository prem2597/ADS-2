public class SAP {
    public SAP(Digraph G) {
    }
    public int length(int v, int w) {
        return w;
    }
    public int ancestor(int v, int w) {
        return w;
    }
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        return 0;
    }
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        return 0;
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