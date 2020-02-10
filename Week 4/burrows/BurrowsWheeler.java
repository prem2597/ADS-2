import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.Arrays;
/**
 * @author Prem
 * @reference stack overflow and algs4 and geeks for geeks
 */
public class BurrowsWheeler {

    private static void encode(String x, String[] data, int search) {
        search = Arrays.binarySearch(data, x);
        BinaryStdOut.write(search);
        for (int j = 0; j < x.length(); j ++) {
            BinaryStdOut.write(data[j].charAt(x.length() - 1));
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output 
    public static void transform() {
        int search = 0;
        String x = BinaryStdIn.readString();
        String y = x.concat(x);
        String[] data = new String[x.length()];
        for (int i = 0; i < x.length(); i ++) {
            data[i] = y.substring(i, i + x.length());
        }
        Arrays.sort(data);
        encode(x, data, search);
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int x = BinaryStdIn.readInt();
        String data = BinaryStdIn.readString();
        char[] a = new char[data.length()];
        for ( int i = 0; i < data.length(); i ++) {
            a[i] = data.charAt(i);
        }
        int[] next = new int[data.length()];
        char[] cn = new char[data.length()];
        int[] count = new int[257];
        for (int i = 0; i < data.length(); i++) {
            count[a[i]+1]++;
        }
        for (int r = 0; r < 256; r++) {
            count[r+1] += count[r];
        }
        for (int i = 0; i < data.length(); i++) {
            next[count[a[i]]] = i;
            cn[count[a[i]]++] = a[i];
        }
        int current = x;
        for (int i = 0; i < data.length(); i++) {
            BinaryStdOut.write(cn[current]);
            current = next[current];
        }

        BinaryStdOut.close();

    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if ( args[0] == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (args[0].equals("-")) {
            transform();
        } else if (args[0].equals("+")) {
            inverseTransform();
        } else {
            throw new IllegalArgumentException();
        }
    }

}
