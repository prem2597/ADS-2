// import edu.princeton.cs.algs4.SuffixArray;
// import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
/**
 * Circular Suffix Array used to rotate the suffixes.
 * @author Prem.
 */
public class CircularSuffixArray {
    private String x;
    private int[]  sortSuffixes;
    private static SuffixArray sa;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        this.x = s;
        sa = new SuffixArray(s);
        sortSuffixes = new int[length()];
        for (int i = 0; i < length(); i++) {
            sortSuffixes[i] = (length() - 1) - i;
        }
        Arrays.sort(sortSuffixes);

    }

    // length of s
    public int length() {
        return x.length();
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > length() - 1) {
            throw new IllegalArgumentException();
        }
        System.out.println("Index : "+sortSuffixes[i]);
        return sortSuffixes[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        String s = "BAABAAABAA";
        CircularSuffixArray h = new CircularSuffixArray(s);
        for (int i = 0; i < h.length(); i++) {
            StdOut.println(sa.index(i));
    	}
    }

}
