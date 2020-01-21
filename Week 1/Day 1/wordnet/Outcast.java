// import edu.princeton.cs.algs4;
public class Outcast {
    /**
     * constructor takes a WordNet object.
     * @param wordnet wordnet file.
     * @author PREM
     */
    private WordNet myWordNet;
    public Outcast(WordNet wordnet) {
        this.myWordNet = wordnet;
    }
    /**
     * given an array of WordNet nouns, return an outcast.
     * @param nouns returns the nouns.
     * @return returns the value.
     */
    public String outcast(String[] nouns) {
        int minCount = 0;
        int maxCount = 0;
        for (int i = 0; i <= nouns.length; i++) {
            int distance = 0;
            for (int j = 0; j <= nouns.length; j++) {
                int l = myWordNet.distance(nouns[i], nouns[j]);
                if (l == -1) {
                    distance = Integer.MIN_VALUE;
                } else {
                    distance += l;
                }
            }
            if (distance > minCount) {
                minCount = distance;
                maxCount = i;
            }
            // if(l > minCount) {
            //     minCount = l;
            //     maxCount = i;
            // }
        }
        return nouns[maxCount];
    }
    /**
     * see test client below.
     * @param args Arguments.
     */
    // public static void main(String[] args) {
    //     WordNet wordnet = new WordNet(args[0], args[1]);
    //     Outcast outcast = new Outcast(wordnet);
    //     for (int t = 2; t < args.length; t++) {
    //         In in = new In(args[t]);
    //         String[] nouns = in.readAllStrings();
    //         StdOut.println(args[t] + ": " + outcast.outcast(nouns));
    //     }
    // }
 }
