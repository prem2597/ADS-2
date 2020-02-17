import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * This class is used to move all the characters to the front.
 * @author Prem.
 * @reference algs4
 */
public class MoveToFront {

     // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        char[] x = new char[256];
        for (int i = 0; i < 256; i++) {
            x[i] = (char) i;
        }

        String s = BinaryStdIn.readString();
        for (char j = 0; j < s.length(); j++) {
	    char data = s.charAt(j);
            int z = 0;
            while (x[z] != data) {
                z++;
            }
            BinaryStdOut.write((char) z);
            while (z > 0) {
                x[z] = x[z - 1];
                z--;
            }
            x[0] = data;
        }       
	BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] x = new char[256];
        for (int i = 0; i < 256; i++) {
            x[i] = (char) i;
        }

        String s = BinaryStdIn.readString();
        for (int j = 0; j < s.length(); j++) {
            int z = s.charAt(j);
            char m = x[z];
            BinaryStdOut.write(x[z]);
            while (z > 0) {
                x[z] = x[z - 1];
                z--;
            }
            x[0] = m;
         }    
	BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        // BinaryStdIn r = new BinaryStdIn();
        if (args[0].equals("-")) {
            encode();
        } else if (args[0].equals("+")) {
            decode();
        } else {
            throw new IllegalArgumentException();
        }

    }

}
