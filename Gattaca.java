import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
/**
 * @author Prem
 */
public class Gattaca {
    private static class StdOut {
        /**
         * force Unicode UTF-8 encoding; otherwise it's system dependent.
         */
        private static final String CHARSET_NAME = "UTF-8";
        /**
         * assume language = English, country = US for consistency with StdIn.
         */
        private static final Locale LOCALE = Locale.US;
        /**
         * send output here.
         */
        private static PrintWriter out;
        static {
            try {
                out = new PrintWriter(new
                OutputStreamWriter(System.out, CHARSET_NAME), true);
            } catch (UnsupportedEncodingException e) {
                System.out.println(e);
            }
        }
        // don't instantiate
        private StdOut() { }
       /**
         * Terminates the current line by printing the line-separator string.
         */
        public static void println() {
            out.println();
        }
       /**
         * Prints an object to this output stream and then terminates the line.
         *
         * @param x the object to print
         */
        public static void println(final Object x) {
            out.println(x);
        }
       /**
         * Prints a boolean to standard output and then terminates the line.
         *
         * @param x the boolean to print
         */
        public static void println(final boolean x) {
            out.println(x);
        }
       /**
         * Prints a character to standard output and then terminates the line.
         *
         * @param x the character to print
         */
        public static void println(final char x) {
            out.println(x);
        }
       /**
         * Prints a double to standard output and then terminates the line.
         *
         * @param x the double to print
         */
        public static void println(final double x) {
            out.println(x);
        }
       /**
         * Prints an integer to standard output and then terminates the line.
         *
         * @param x the integer to print
         */
        public static void println(final float x) {
            out.println(x);
        }
       /**
         * Prints an integer to standard output and then terminates the line.
         *
         * @param x the integer to print
         */
        public static void println(final int x) {
            out.println(x);
        }
       /**
         * Prints a long to standard output and then terminates the line.
         *
         * @param x the long to print
         */
        public static void println(final long x) {
            out.println(x);
        }
       /**
         * Prints a short integer to standard output and then terminates the line.
         *
         * @param x the short to print
         */
        public static void println(final short x) {
            out.println(x);
        }
       /**
         * Prints a byte to standard output and then terminates the line.
         * <p>
         * To write binary data, see {@link BinaryStdOut}.
         *
         * @param x the byte to print
         */
        public static void println(final byte x) {
            out.println(x);
        }
       /**
         * Flushes standard output.
         */
        public static void print() {
            out.flush();
        }
       /**
         * Prints an object to standard output and flushes standard output.
         *
         * @param x the object to print
         */
        public static void print(final Object x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a boolean to standard output and flushes standard output.
         *
         * @param x the boolean to print
         */
        public static void print(final boolean x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a character to standard output and flushes standard output.
         *
         * @param x the character to print
         */
        public static void print(final char x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a double to standard output and flushes standard output.
         *
         * @param x the double to print
         */
        public static void print(final double x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a float to standard output and flushes standard output.
         *
         * @param x the float to print
         */
        public static void print(final float x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints an integer to standard output and flushes standard output.
         *
         * @param x the integer to print
         */
        public static void print(final int x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a long integer to standard output and flushes standard output.
         *
         * @param x the long integer to print
         */
        public static void print(final long x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a short integer to standard output and flushes standard output.
         *
         * @param x the short integer to print
         */
        public static void print(final short x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a byte to standard output and flushes standard output.
         *
         * @param x the byte to print
         */
        public static void print(final byte x) {
            out.print(x);
            out.flush();
        }
       /**
         * Prints a formatted string to standard output, using the specified format
         * string and arguments, and then flushes standard output.
         *
         * @param format the <a href = "http://docs.oracle.com/javase/
         * 7/docs/api/java/util/Formatter.html#syntax">format string</a>
         * @param args   the arguments accompanying the format string
         */
        public static void printf(final String format, final Object... args) {
            out.printf(LOCALE, format, args);
            out.flush();
        }
       /**
         * Prints a formatted string to standard output, using the locale and
         * the specified format string and arguments; then flushes standard output.
         *
         * @param locale the locale
         * @param format the <a href = "http://docs.oracle.com/javase/
         * 7/docs/api/java/util/Formatter.html#syntax">format string</a>
         * @param args   the arguments accompanying the format string
         */
        public static void printf(final Locale locale, final String format,
        final Object... args) {
            out.printf(locale, format, args);
            out.flush();
        }
    }
    private static class StdIn {

        /*** begin: section (1 of 2) of code duplicated from In to StdIn. */
        // assume Unicode UTF-8 encoding
        private static final String CHARSET_NAME = "UTF-8";
    
        // assume language = English, country = US for consistency with System.out.
        /**
         * Local varaiable.
         */
        private static final Locale LOCALE = Locale.US;
    
        // the default token separator; we maintain the invariant that this value
        // is held by the scanner's delimiter between calls
        /**
         * The method intializes the values.
         */
        private static final Pattern WHITESPACE_PATTERN =
        Pattern.compile("\\p{javaWhitespace}+");
    
        // makes whitespace significant
        /**
         * The method intializes the values.
         */
        private static final Pattern EMPTY_PATTERN = Pattern.compile("");
    
        // used to read the entire input
        /**
         * The method intializes the values.
         */
        private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    
        /*** end: section (1 of 2) of code duplicated from In to StdIn. */
    
        private static Scanner scanner;
    
        // it doesn't make sense to instantiate this class
        private StdIn() { }
    
        //// begin: section (2 of 2) of code duplicated from In to StdIn,
        //// with all methods changed from "public" to "public static"
    
       /**
         * Returns true if standard input is empty (except possibly for whitespace).
         * Use this method to know whether the next call to {@link #readString()},
         * {@link #readDouble()}, etc will succeed.
         *
         * @return {@code true} if standard input is empty (except possibly
         *         for whitespace); {@code false} otherwise
         */
        public static boolean isEmpty() {
            return !scanner.hasNext();
        }
    
       /**
         * Returns true if standard input has a next line.
         * Use this method to know whether the
         * next call to {@link #readLine()} will succeed.
         * This method is functionally equivalent to {@link #hasNextChar()}.
         *
         * @return {@code true} if standard input
         *  has more input (including whitespace);
         *         {@code false} otherwise
         */
        public static boolean hasNextLine() {
            return scanner.hasNextLine();
        }
    
        /**
         * Returns true if standard input has more input (including whitespace).
         * Use this method to know whether the
         *  next call to {@link #readChar()} will succeed.
         * This method is functionally equivalent to {@link #hasNextLine()}.
         *
         * @return {@code true} if standard input has
         *  more input (including whitespace);
         *         {@code false} otherwise
         */
        public static boolean hasNextChar() {
            scanner.useDelimiter(EMPTY_PATTERN);
            boolean result = scanner.hasNext();
            scanner.useDelimiter(WHITESPACE_PATTERN);
            return result;
        }
    
    
       /**
         * Reads and returns the next line, excluding the line separator if present.
         *
         * @return the next line, excluding the line separator if present;
         *         {@code null} if no such line
         */
        public static String readLine() {
            String line;
            try {
                line = scanner.nextLine();
            } catch (NoSuchElementException e) {
                line = null;
            }
            return line;
        }
    
        /**
         * Reads and returns the next character.
         *
         * @return the next {@code char}
         * @throws NoSuchElementException if standard input is empty
         */
        public static char readChar() {
            try {
                scanner.useDelimiter(EMPTY_PATTERN);
                String ch = scanner.next();
                assert ch.length() == 1 : "Internal (Std)In.readChar() error!"
                    + " Please contact the authors.";
                scanner.useDelimiter(WHITESPACE_PATTERN);
                return ch.charAt(0);
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'char' "
                + "value from standard input, "
                + "but no more tokens are available");
            }
        }
    
    
       /**
         * Reads and returns the remainder of the input, as a string.
         *
         * @return the remainder of the input, as a string
         * @throws NoSuchElementException if standard input is empty
         */
        public static String readAll() {
            if (!scanner.hasNextLine()) {
                return "";
            }
            String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
            // not that important to reset delimeter, since now scanner is empty
            scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
            return result;
        }
    
    
       /**
         * Reads the next token  and returns the {@code String}.
         *
         * @return the next {@code String}
         * @throws NoSuchElementException if standard input is empty
         */
        public static String readString() {
            try {
                return scanner.next();
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'String' value"
                + "from standard input, but no more tokens are available");
            }
        }
    
       /**
         * Reads the next token from standard input,
         * parses it as an integer, and returns the integer.
         *
         * @return the next integer on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token
         * cannot be parsed as an {@code int}
         */
        public static int readInt() {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read an 'int' value "
                + "from standard input but the next token is \"" + token + "\"");
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("attemps to read an 'int' value "
                + "from standard input, but no more tokens are available");
            }
    
        }
    
       /**
         * Reads the next token from standard input,
         * parses it as a double, and returns the double.
         *
         * @return the next double on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot
         * be parsed as a {@code double}
         */
        public static double readDouble() {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read a 'double' "
                + "value from standard input, "
                + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'double' value from standard input, "
                                               + "but no more tokens are available");
            }
        }
    
       /**
         * Reads the next token from standard input, parses it as a float, and returns the float.
         *
         * @return the next float on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as a {@code float}
         */
        public static float readFloat() {
            try {
                return scanner.nextFloat();
            }
            catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read a 'float' value from standard input, "
                                               + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'float' value from standard input, "
                                               + "but there no more tokens are available");
            }
        }
    
       /**
         * Reads the next token from standard input, parses it as a long integer, and returns the long integer.
         *
         * @return the next long integer on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as a {@code long}
         */
        public static long readLong() {
            try {
                return scanner.nextLong();
            }
            catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read a 'long' value from standard input, "
                                               + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'long' value from standard input, "
                                               + "but no more tokens are available");
            }
        }
    
       /**
         * Reads the next token from standard input, parses it as a short integer, and returns the short integer.
         *
         * @return the next short integer on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as a {@code short}
         */
        public static short readShort() {
            try {
                return scanner.nextShort();
            }
            catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read a 'short' value from standard input, "
                                               + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'short' value from standard input, "
                                               + "but no more tokens are available");
            }
        }
    
       /**
         * Reads the next token from standard input, parses it as a byte, and returns the byte.
         *
         * @return the next byte on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as a {@code byte}
         */
        public static byte readByte() {
            try {
                return scanner.nextByte();
            }
            catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read a 'byte' value from standard input, "
                                               + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'byte' value from standard input, "
                                               + "but no more tokens are available");
            }
        }
    
        /**
         * Reads the next token from standard input, parses it as a boolean,
         * and returns the boolean.
         *
         * @return the next boolean on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as a {@code boolean}:
         *    {@code true} or {@code 1} for true, and {@code false} or {@code 0} for false,
         *    ignoring case
         */
        public static boolean readBoolean() {
            try {
                String token = readString();
                if ("true".equalsIgnoreCase(token))  return true;
                if ("false".equalsIgnoreCase(token)) return false;
                if ("1".equals(token))               return true;
                if ("0".equals(token))               return false;
                throw new InputMismatchException("attempts to read a 'boolean' value from standard input, "
                                               + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'boolean' value from standard input, "
                                               + "but no more tokens are available");
            }
    
        }
    
        /**
         * Reads all remaining tokens from standard input and returns them as an array of strings.
         *
         * @return all remaining tokens on standard input, as an array of strings
         */
        public static String[] readAllStrings() {
            // we could use readAll.trim().split(), but that's not consistent
            // because trim() uses characters 0x00..0x20 as whitespace
            String[] tokens = WHITESPACE_PATTERN.split(readAll());
            if (tokens.length == 0 || tokens[0].length() > 0)
                return tokens;
    
            // don't include first token if it is leading whitespace
            String[] decapitokens = new String[tokens.length-1];
            for (int i = 0; i < tokens.length - 1; i++)
                decapitokens[i] = tokens[i+1];
            return decapitokens;
        }
    
        /**
         * Reads all remaining lines from standard input and returns them as an array of strings.
         * @return all remaining lines on standard input, as an array of strings
         */
        public static String[] readAllLines() {
            ArrayList<String> lines = new ArrayList<String>();
            while (hasNextLine()) {
                lines.add(readLine());
            }
            return lines.toArray(new String[lines.size()]);
        }
    
        /**
         * Reads all remaining tokens from standard input, parses them as integers, and returns
         * them as an array of integers.
         * @return all remaining integers on standard input, as an array
         * @throws InputMismatchException if any token cannot be parsed as an {@code int}
         */
        public static int[] readAllInts() {
            String[] fields = readAllStrings();
            int[] vals = new int[fields.length];
            for (int i = 0; i < fields.length; i++)
                vals[i] = Integer.parseInt(fields[i]);
            return vals;
        }
    
        /**
         * Reads all remaining tokens from standard input, parses them as longs, and returns
         * them as an array of longs.
         * @return all remaining longs on standard input, as an array
         * @throws InputMismatchException if any token cannot be parsed as a {@code long}
         */
        public static long[] readAllLongs() {
            String[] fields = readAllStrings();
            long[] vals = new long[fields.length];
            for (int i = 0; i < fields.length; i++)
                vals[i] = Long.parseLong(fields[i]);
            return vals;
        }
    
        /**
         * Reads all remaining tokens from standard input, parses them as doubles, and returns
         * them as an array of doubles.
         * @return all remaining doubles on standard input, as an array
         * @throws InputMismatchException if any token cannot be parsed as a {@code double}
         */
        public static double[] readAllDoubles() {
            String[] fields = readAllStrings();
            double[] vals = new double[fields.length];
            for (int i = 0; i < fields.length; i++)
                vals[i] = Double.parseDouble(fields[i]);
            return vals;
        }
        
        //// end: section (2 of 2) of code duplicated from In to StdIn
        
        
        // do this once when StdIn is initialized
        static {
            resync();
        }
    
        /**
         * If StdIn changes, use this to reinitialize the scanner.
         */
        private static void resync() {
            setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
        }
        private static void setScanner(Scanner scanner) {
            StdIn.scanner = scanner;
            StdIn.scanner.useLocale(LOCALE);
        }
    
       /**
         * Reads all remaining tokens, parses them as integers, and returns
         * them as an array of integers.
         * @return all remaining integers, as an array
         * @throws InputMismatchException if any token cannot
         * be parsed as an {@code int}
         * @deprecated Replaced by {@link #readAllInts()}.
         */
        @Deprecated
        public static int[] readInts() {
            return readAllInts();
        }
    
       /**
         * Reads all remaining tokens, parses them as doubles, and returns
         * them as an array of doubles.
         * @return all remaining doubles, as an array
         * @throws InputMismatchException if any token cannot
         * be parsed as a {@code double}
         * @deprecated Replaced by {@link #readAllDoubles()}.
         */
        @Deprecated
        public static double[] readDoubles() {
            return readAllDoubles();
        }
    
       /**
         * Reads all remaining tokens and returns them as an array of strings.
         * @return all remaining tokens, as an array of strings
         * @deprecated Replaced by {@link #readAllStrings()}.
         */
        @Deprecated
        public static String[] readStrings() {
            return readAllStrings();
        }
    }
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

        /**
         * Unit tests the {@code SuffixArray} data type.
         *
         * @param args the command-line arguments
         */
        // public static void main(String[] args) {
        //     String s = StdIn.readAll().replaceAll("\\s+", " ").trim();
        //     SuffixArray suffix = new SuffixArray(s);

        //     // StdOut.println("rank(" + args[0] + ") = " + suffix.rank(args[0]));

        //     StdOut.println("  i ind lcp rnk select");
        //     StdOut.println("---------------------------");

        //     for (int i = 0; i < s.length(); i++) {
        //         int index = suffix.index(i);
        //         String ith = "\"" + s.substring(index, Math.min(index + 50, s.length())) + "\"";
        //         assert s.substring(index).equals(suffix.select(i));
        //         int rank = suffix.rank(s.substring(index));
        //         if (i == 0) {
        //             StdOut.printf("%3d %3d %3s %3d %s\n", i, index, "-", rank, ith);
        //         }
        //         else {
        //             int lcp = suffix.lcp(i);
        //             StdOut.printf("%3d %3d %3d %3d %s\n", i, index, lcp, rank, ith);
        //         }
        //     }
        // }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < x; i++) {
            String data = sc.nextLine().replaceAll("\\s+", " ").trim();
            SuffixArray s = new SuffixArray(data);
            // System.out.println(s);
            for(int j = 0; j < data.length(); j++) {
                int index = s.index(j);
                // System.out.println(index);
                String ith = "\"" + data.substring(index, Math.min(index + 50, data.length())) + "\"";
                System.out.println(ith);
                if (data.substring(index).equals(s.select(j))) {
                    int rank = s.rank(data.substring(index));
                    System.out.println("Rank : " + rank);
                    System.out.println("String :"+ data.substring(index));
                }
            }

        }
    }
}