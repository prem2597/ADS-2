import java.util.Arrays;
import java.util.Scanner;
public class Sol {
    private static class SuffixArray {
        private Suffix[] suffixes;
    
        /**
         * Initializes a suffix array for the given {@code text} string.
         * @param text the input string
         */
        public SuffixArray(String text) {
            int n = text.length();
            this.suffixes = new Suffix[n];
            for (int i = 0; i < n; i++)
                suffixes[i] = new Suffix(text, i);
            Arrays.sort(suffixes);
        }
    
        private static class Suffix implements Comparable<Suffix> {
            private final String text;
            private final int index;
    
            private Suffix(String text, int index) {
                this.text = text;
                this.index = index;
            }
            private int length() {
                return text.length() - index;
            }
            private char charAt(int i) {
                return text.charAt(index + i);
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
    
        /**
         * Returns the length of the input string.
         * @return the length of the input string
         */
        public int length() {
            return suffixes.length;
        }
    
    
        /**
         * Returns the index into the original string of the <em>i</em>th smallest suffix.
         * That is, {@code text.substring(sa.index(i))} is the <em>i</em>th smallest suffix.
         * @param i an integer between 0 and <em>n</em>-1
         * @return the index into the original string of the <em>i</em>th smallest suffix
         * @throws java.lang.IllegalArgumentException unless {@code 0 <= i < n}
         */
        public int index(int i) {
            if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
            return suffixes[i].index;
        }
    
    
        /**
         * Returns the length of the longest common prefix of the <em>i</em>th
         * smallest suffix and the <em>i</em>-1st smallest suffix.
         * @param i an integer between 1 and <em>n</em>-1
         * @return the length of the longest common prefix of the <em>i</em>th
         * smallest suffix and the <em>i</em>-1st smallest suffix.
         * @throws java.lang.IllegalArgumentException unless {@code 1 <= i < n}
         */
        public int lcp(int i) {
            if (i < 1 || i >= suffixes.length) throw new IllegalArgumentException();
            return lcpSuffix(suffixes[i], suffixes[i-1]);
        }
    
        // longest common prefix of s and t
        private static int lcpSuffix(Suffix s, Suffix t) {
            int n = Math.min(s.length(), t.length());
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) return i;
            }
            return n;
        }
    
        /**
         * Returns the <em>i</em>th smallest suffix as a string.
         * @param i the index
         * @return the <em>i</em> smallest suffix as a string
         * @throws java.lang.IllegalArgumentException unless {@code 0 <= i < n}
         */
        public String select(int i) {
            if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
            return suffixes[i].toString();
        }
    
        /**
         * Returns the number of suffixes strictly less than the {@code query} string.
         * We note that {@code rank(select(i))} equals {@code i} for each {@code i}
         * between 0 and <em>n</em>-1.
         * @param query the query string
         * @return the number of suffixes strictly less than {@code query}
         */
        public int rank(String query) {
            int lo = 0, hi = suffixes.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int cmp = compare(query, suffixes[mid]);
                if (cmp < 0) hi = mid - 1;
                else if (cmp > 0) lo = mid + 1;
                else return mid;
            }
            return lo;
        }
    
        // compare query string to suffix
        private static int compare(String query, Suffix suffix) {
            int n = Math.min(query.length(), suffix.length());
            for (int i = 0; i < n; i++) {
                if (query.charAt(i) < suffix.charAt(i)) return -1;
                if (query.charAt(i) > suffix.charAt(i)) return +1;
            }
            return query.length() - suffix.length();
        }
    
    }

    private static class LongestRepeatedSubstring {

        // Do not instantiate.
        private LongestRepeatedSubstring() { }
    
        /**
         * Returns the longest common string of the two specified strings.
         *
         * @param  s one string
         * @param  t the other string
         * @return the longest common string that appears as a substring
         */
    
        /**
         * Returns the longest repeated substring of the specified string.
         *
         * @param  text the string
         * @return the longest repeated substring that appears in {@code text};
         *         the empty string if no such string
         */
        public static String lrs(String text) {
            int n = text.length();
            SuffixArray sa = new SuffixArray(text);
            String lrs = "";
            for (int i = 1; i < n; i++) {
                int length = sa.lcp(i);
                if (length > lrs.length()) {
                    // lrs = sa.select(i).substring(0, length);
                    lrs = text.substring(sa.index(i), sa.index(i) + length);
                }
            }
            return lrs;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < x; i++) {
            String data = sc.nextLine().replaceAll("\\s+", " ").trim();
            // SuffixArray s = new SuffixArray(data);
            // System.out.println(s);
            LongestRepeatedSubstring s = new LongestRepeatedSubstring();
            int count = 0;
            String m = s.lrs(data);
            for(int j = 0; j < data.length(); j++) {
                // int index = s.index(j);
                // System.out.println(index);
                // String ith = "\"" + data.substring(index, Math.min(index + 50, data.length())) + "\"";
                // System.out.println(ith);
                // if (data.substring(index).equals(s.select(j))) {
                //     int rank = s.rank(data.substring(index));
                //     System.out.println("Rank : " + rank);
                //     System.out.println("String :"+ data.substring(index));
                // }
                if (m.length() + j <= data.length()) {
                    if (m.equals(data.substring(j, m.length()+j))) {
                        count = count + 1;
                    }
                }
                
            }
            if (count == 0 || count == data.length()) {
                // if (count == data.length()) {
                //     System.out.println("No repetitions found!");
                // }
                System.out.println("No repetitions found!");
            } else {
                System.out.println(m+" "+count);
            }

        }
    }
}