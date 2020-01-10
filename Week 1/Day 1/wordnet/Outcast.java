public class Outcast {
    /**
     * constructor takes a WordNet object.
     * @param wordnet wordnet file.
     * @author PREM
     */
    WordNet wordnet;
    public Outcast(WordNet wordnet) {
    }
    /**
     * given an array of WordNet nouns, return an outcast.
     * @param nouns returns the nouns.
     * @return returns the value.
     */
    public String outcast(String[] nouns) {
        return null;
    }
    /**
     * see test client below.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
 }
