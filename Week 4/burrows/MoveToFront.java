import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * This class is used to move all the characters to the front.
 * @author Prem.
 */
public class MoveToFront {

    private static void toEncode(char[] data, char[] x, int z) {
        for (int k = 0; k < data.length; k++) {
            z = 0;
            while (x[(char) z] != data[k]) {
                z++;
            }
            BinaryStdOut.write((char) z);
            while ((char) z > 0) {
                x[(char) z] = x[(char) z - 1];
                z--;
            }
            x[0] = data[k];

        }
        BinaryStdOut.close();
    }

    private static void toDecode(char[] data, char[] x, int z) {
        for (int k = 0; k < data.length; k++) {
            z = data[k];
            char m = x[(char) z];
            BinaryStdOut.write(x[(char) z]);

            while ((char) z > 0) {
                x[(char) z] = x[(char) z - 1];
                z--;
            }
            x[0] = m;

        }
        BinaryStdOut.close();
    }

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        int z = 0;
        char[] x = new char[256];
        for (int i = 0; i < 256; i++) {
            x[i] = (char) i;
        }

        String s = BinaryStdIn.readString();
        char[] data = new char[s.length()];
        for (char j = 0; j < s.length(); j++) {
            data[j] = s.charAt(j);

        }
        
        toEncode(data, x, z);
        

    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        int z = 0;
        char[] x = new char[256];
        for (int i = 0; i < 256; i++) {
            x[i] = (char) i;
        }

        String s = BinaryStdIn.readString();
        char[] data = new char[s.length()];
        for (int j = 0; j < s.length(); j++) {
            data[j] = s.charAt(j);

        }
        
        toDecode(data, x, z);
        

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
