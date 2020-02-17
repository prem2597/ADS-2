import edu.princeton.cs.algs4.SuffixArray;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
/**
 * Circular Suffix Array used to rotate the suffixes.
 * @author Prem.
 * @refernce stack overflow algs4.
 */
public class CircularSuffixArray {
   
     private int sortSuffixes[];
    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
   	
	int n = s.length();
        Suffix[] suffixes = new Suffix[n];
        for (int i = 0; i < n; i++)
            suffixes[i] = new Suffix(s.substring(i)+s.substring(0,i), i);
        Arrays.sort(suffixes);

        sortSuffixes = new int[n ];
        for (int i = 0; i < n  ; i++) {
            sortSuffixes[i] = suffixes[i].index;
        }
 

    }

 private static class Suffix implements Comparable<Suffix> {
        private final String text;
        private final int index;

        private Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }
        private int length() {
            return text.length();
        }
        private char charAt(int i) {
            return text.charAt(i);
        }

        public int compareTo(Suffix that) {
            if (this == that) return 0;  // optimization
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }

        public String toString() {
            return text.substring(index);
        }
    }

    public int length() {
        return sortSuffixes.length;
    }

    public int index(int i) {
        if (i < 0 || i >= sortSuffixes.length) throw new IllegalArgumentException();
        return sortSuffixes[i];
    }

}
