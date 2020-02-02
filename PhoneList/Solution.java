import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Queue;

public class Solution {
    private static final class StdOut {

        // force Unicode UTF-8 encoding; otherwise it's system dependent
        private static final String CHARSET_NAME = "UTF-8";
    
        // assume language = English, country = US for consistency with StdIn
        private static final Locale LOCALE = Locale.US;
    
        // send output here
        private static PrintWriter out;
    
        // this is called before invoking any methods
        static {
            try {
                out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
            }
            catch (UnsupportedEncodingException e) {
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
        public static void println(Object x) {
            out.println(x);
        }
    
       /**
         * Prints a boolean to standard output and then terminates the line.
         *
         * @param x the boolean to print
         */
        public static void println(boolean x) {
            out.println(x);
        }
    
       /**
         * Prints a character to standard output and then terminates the line.
         *
         * @param x the character to print
         */
        public static void println(char x) {
            out.println(x);
        }
    
       /**
         * Prints a double to standard output and then terminates the line.
         *
         * @param x the double to print
         */
        public static void println(double x) {
            out.println(x);
        }
    
       /**
         * Prints an integer to standard output and then terminates the line.
         *
         * @param x the integer to print
         */
        public static void println(float x) {
            out.println(x);
        }
    
       /**
         * Prints an integer to standard output and then terminates the line.
         *
         * @param x the integer to print
         */
        public static void println(int x) {
            out.println(x);
        }
    
       /**
         * Prints a long to standard output and then terminates the line.
         *
         * @param x the long to print
         */
        public static void println(long x) {
            out.println(x);
        }
    
       /**
         * Prints a short integer to standard output and then terminates the line.
         *
         * @param x the short to print
         */
        public static void println(short x) {
            out.println(x);
        }
    
       /**
         * Prints a byte to standard output and then terminates the line.
         * <p>
         * To write binary data, see {@link BinaryStdOut}.
         *
         * @param x the byte to print
         */
        public static void println(byte x) {
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
        public static void print(Object x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a boolean to standard output and flushes standard output.
         * 
         * @param x the boolean to print
         */
        public static void print(boolean x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a character to standard output and flushes standard output.
         * 
         * @param x the character to print
         */
        public static void print(char x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a double to standard output and flushes standard output.
         * 
         * @param x the double to print
         */
        public static void print(double x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a float to standard output and flushes standard output.
         * 
         * @param x the float to print
         */
        public static void print(float x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints an integer to standard output and flushes standard output.
         * 
         * @param x the integer to print
         */
        public static void print(int x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a long integer to standard output and flushes standard output.
         * 
         * @param x the long integer to print
         */
        public static void print(long x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a short integer to standard output and flushes standard output.
         * 
         * @param x the short integer to print
         */
        public static void print(short x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a byte to standard output and flushes standard output.
         *
         * @param x the byte to print
         */
        public static void print(byte x) {
            out.print(x);
            out.flush();
        }
    
       /**
         * Prints a formatted string to standard output, using the specified format
         * string and arguments, and then flushes standard output.
         *
         *
         * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
         * @param args   the arguments accompanying the format string
         */
        public static void printf(String format, Object... args) {
            out.printf(LOCALE, format, args);
            out.flush();
        }
    
       /**
         * Prints a formatted string to standard output, using the locale and
         * the specified format string and arguments; then flushes standard output.
         *
         * @param locale the locale
         * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format string</a>
         * @param args   the arguments accompanying the format string
         */
        public static void printf(Locale locale, String format, Object... args) {
            out.printf(locale, format, args);
            out.flush();
        }
    
    }

    private static final class StdIn {

        /*** begin: section (1 of 2) of code duplicated from In to StdIn. */
        
        // assume Unicode UTF-8 encoding
        private static final String CHARSET_NAME = "UTF-8";
    
        // assume language = English, country = US for consistency with System.out.
        private static final Locale LOCALE = Locale.US;
    
        // the default token separator; we maintain the invariant that this value
        // is held by the scanner's delimiter between calls
        private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    
        // makes whitespace significant
        private static final Pattern EMPTY_PATTERN = Pattern.compile("");
    
        // used to read the entire input
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
         * @return {@code true} if standard input has more input (including whitespace);
         *         {@code false} otherwise
         */
        public static boolean hasNextLine() {
            return scanner.hasNextLine();
        }
    
        /**
         * Returns true if standard input has more input (including whitespace).
         * Use this method to know whether the next call to {@link #readChar()} will succeed.
         * This method is functionally equivalent to {@link #hasNextLine()}.
         *
         * @return {@code true} if standard input has more input (including whitespace);
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
            }
            catch (NoSuchElementException e) {
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
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'char' value from standard input, "
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
            if (!scanner.hasNextLine())
                return "";
    
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
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attempts to read a 'String' value from standard input, "
                                               + "but no more tokens are available");
            }
        }
    
       /**
         * Reads the next token from standard input, parses it as an integer, and returns the integer.
         *
         * @return the next integer on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as an {@code int}
         */
        public static int readInt() {
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read an 'int' value from standard input, "
                                               + "but the next token is \"" + token + "\"");
            }
            catch (NoSuchElementException e) {
                throw new NoSuchElementException("attemps to read an 'int' value from standard input, "
                                               + "but no more tokens are available");
            }
    
        }
    
       /**
         * Reads the next token from standard input, parses it as a double, and returns the double.
         *
         * @return the next double on standard input
         * @throws NoSuchElementException if standard input is empty
         * @throws InputMismatchException if the next token cannot be parsed as a {@code double}
         */
        public static double readDouble() {
            try {
                return scanner.nextDouble();
            }
            catch (InputMismatchException e) {
                String token = scanner.next();
                throw new InputMismatchException("attempts to read a 'double' value from standard input, "
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
         * @throws InputMismatchException if any token cannot be parsed as an {@code int}
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
         * @throws InputMismatchException if any token cannot be parsed as a {@code double}
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

    private static  class Queue<Item> implements Iterable<Item> {
        private Node<Item> first;    // beginning of queue
        private Node<Item> last;     // end of queue
        private int n;               // number of elements on queue
    
        // helper linked list class
        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }
    
        /**
         * Initializes an empty queue.
         */
        public Queue() {
            first = null;
            last  = null;
            n = 0;
        }
    
        /**
         * Returns true if this queue is empty.
         *
         * @return {@code true} if this queue is empty; {@code false} otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }
    
        /**
         * Returns the number of items in this queue.
         *
         * @return the number of items in this queue
         */
        public int size() {
            return n;
        }
    
        /**
         * Returns the item least recently added to this queue.
         *
         * @return the item least recently added to this queue
         * @throws NoSuchElementException if this queue is empty
         */
        public Item peek() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            return first.item;
        }
    
        /**
         * Adds the item to this queue.
         *
         * @param  item the item to add
         */
        public void enqueue(Item item) {
            Node<Item> oldlast = last;
            last = new Node<Item>();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else           oldlast.next = last;
            n++;
        }
    
        /**
         * Removes and returns the item on this queue that was least recently added.
         *
         * @return the item on this queue that was least recently added
         * @throws NoSuchElementException if this queue is empty
         */
        public Item dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = first.item;
            first = first.next;
            n--;
            if (isEmpty()) last = null;   // to avoid loitering
            return item;
        }
    
        /**
         * Returns a string representation of this queue.
         *
         * @return the sequence of items in FIFO order, separated by spaces
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this) {
                s.append(item);
                s.append(' ');
            }
            return s.toString();
        } 
    
        /**
         * Returns an iterator that iterates over the items in this queue in FIFO order.
         *
         * @return an iterator that iterates over the items in this queue in FIFO order
         */
        public Iterator<Item> iterator()  {
            return new ListIterator(first);  
        }
    
        // an iterator, doesn't implement remove() since it's optional
        private class ListIterator implements Iterator<Item> {
            private Node<Item> current;
    
            public ListIterator(Node<Item> first) {
                current = first;
            }
    
            public boolean hasNext()  { return current != null;                     }
            public void remove()      { throw new UnsupportedOperationException();  }
    
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next; 
                return item;
            }
        }
    
    
        /**
         * Unit tests the {@code Queue} data type.
         *
         * @param args the command-line arguments
         */
        // public static void main(String[] args) {
        //     Queue<String> queue = new Queue<String>();
        //     while (!StdIn.isEmpty()) {
        //         String item = StdIn.readString();
        //         if (!item.equals("-"))
        //             queue.enqueue(item);
        //         else if (!queue.isEmpty())
        //             StdOut.print(queue.dequeue() + " ");
        //     }
        //     StdOut.println("(" + queue.size() + " left on queue)");
        // }
    }
    private static class TST<Value> {
        private int n;              // size
        private Node<Value> root;   // root of TST
    
        private class Node<Value> {
            private char c;                        // character
            private Node<Value> left, mid, right;  // left, middle, and right subtries
            private Value val;                     // value associated with string
        }
    
        /**
         * Initializes an empty string symbol table.
         */
        public TST() {
        }
    
        /**
         * Returns the number of key-value pairs in this symbol table.
         * @return the number of key-value pairs in this symbol table
         */
        public int size() {
            return n;
        }
    
        /**
         * Does this symbol table contain the given key?
         * @param key the key
         * @return {@code true} if this symbol table contains {@code key} and
         *     {@code false} otherwise
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public boolean contains(String key) {
            if (key == null) {
                throw new IllegalArgumentException("argument to contains() is null");
            }
            return get(key) != null;
        }
    
        /**
         * Returns the value associated with the given key.
         * @param key the key
         * @return the value associated with the given key if the key is in the symbol table
         *     and {@code null} if the key is not in the symbol table
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public Value get(String key) {
            if (key == null) {
                throw new IllegalArgumentException("calls get() with null argument");
            }
            if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
            Node<Value> x = get(root, key, 0);
            if (x == null) return null;
            return x.val;
        }
    
        // return subtrie corresponding to given key
        private Node<Value> get(Node<Value> x, String key, int d) {
            if (x == null) return null;
            if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
            char c = key.charAt(d);
            if      (c < x.c)              return get(x.left,  key, d);
            else if (c > x.c)              return get(x.right, key, d);
            else if (d < key.length() - 1) return get(x.mid,   key, d+1);
            else                           return x;
        }
    
        /**
         * Inserts the key-value pair into the symbol table, overwriting the old value
         * with the new value if the key is already in the symbol table.
         * If the value is {@code null}, this effectively deletes the key from the symbol table.
         * @param key the key
         * @param val the value
         * @throws IllegalArgumentException if {@code key} is {@code null}
         */
        public void put(String key, Value val) {
            if (key == null) {
                throw new IllegalArgumentException("calls put() with null key");
            }
            if (!contains(key)) n++;
            else if(val == null) n--;       // delete existing key
            root = put(root, key, val, 0);
        }
    
        private Node<Value> put(Node<Value> x, String key, Value val, int d) {
            char c = key.charAt(d);
            if (x == null) {
                x = new Node<Value>();
                x.c = c;
            }
            if      (c < x.c)               x.left  = put(x.left,  key, val, d);
            else if (c > x.c)               x.right = put(x.right, key, val, d);
            else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
            else                            x.val   = val;
            return x;
        }
    
        /**
         * Returns the string in the symbol table that is the longest prefix of {@code query},
         * or {@code null}, if no such string.
         * @param query the query string
         * @return the string in the symbol table that is the longest prefix of {@code query},
         *     or {@code null} if no such string
         * @throws IllegalArgumentException if {@code query} is {@code null}
         */
        public String longestPrefixOf(String query) {
            if (query == null) {
                throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
            }
            if (query.length() == 0) return null;
            int length = 0;
            Node<Value> x = root;
            int i = 0;
            while (x != null && i < query.length()) {
                char c = query.charAt(i);
                if      (c < x.c) x = x.left;
                else if (c > x.c) x = x.right;
                else {
                    i++;
                    if (x.val != null) length = i;
                    x = x.mid;
                }
            }
            return query.substring(0, length);
        }
    
        /**
         * Returns all keys in the symbol table as an {@code Iterable}.
         * To iterate over all of the keys in the symbol table named {@code st},
         * use the foreach notation: {@code for (Key key : st.keys())}.
         * @return all keys in the symbol table as an {@code Iterable}
         */
        public Iterable<String> keys() {
            Queue<String> queue = new Queue<String>();
            collect(root, new StringBuilder(), queue);
            return queue;
        }
    
        /**
         * Returns all of the keys in the set that start with {@code prefix}.
         * @param prefix the prefix
         * @return all of the keys in the set that start with {@code prefix},
         *     as an iterable
         * @throws IllegalArgumentException if {@code prefix} is {@code null}
         */
        public Iterable<String> keysWithPrefix(String prefix) {
            if (prefix == null) {
                throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
            }
            Queue<String> queue = new Queue<String>();
            Node<Value> x = get(root, prefix, 0);
            if (x == null) return queue;
            if (x.val != null) queue.enqueue(prefix);
            collect(x.mid, new StringBuilder(prefix), queue);
            return queue;
        }
    
        // all keys in subtrie rooted at x with given prefix
        private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) {
            if (x == null) return;
            collect(x.left,  prefix, queue);
            if (x.val != null) queue.enqueue(prefix.toString() + x.c);
            collect(x.mid,   prefix.append(x.c), queue);
            prefix.deleteCharAt(prefix.length() - 1);
            collect(x.right, prefix, queue);
        }
    
    
        /**
         * Returns all of the keys in the symbol table that match {@code pattern},
         * where . symbol is treated as a wildcard character.
         * @param pattern the pattern
         * @return all of the keys in the symbol table that match {@code pattern},
         *     as an iterable, where . is treated as a wildcard character.
         */
        public Iterable<String> keysThatMatch(String pattern) {
            Queue<String> queue = new Queue<String>();
            collect(root, new StringBuilder(), 0, pattern, queue);
            return queue;
        }
     
        private void collect(Node<Value> x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
            if (x == null) return;
            char c = pattern.charAt(i);
            if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
            if (c == '.' || c == x.c) {
                if (i == pattern.length() - 1 && x.val != null) queue.enqueue(prefix.toString() + x.c);
                if (i < pattern.length() - 1) {
                    collect(x.mid, prefix.append(x.c), i+1, pattern, queue);
                    prefix.deleteCharAt(prefix.length() - 1);
                }
            }
            if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
        }
    
    
        // /**
        //  * Unit tests the {@code TST} data type.
        //  *
        //  * @param args the command-line arguments
        //  */
        // public static void main(String[] args) {
    
        //     // build symbol table from standard input
        //     TST<Integer> st = new TST<Integer>();
        //     for (int i = 0; !StdIn.isEmpty(); i++) {
        //         String key = StdIn.readString();
        //         st.put(key, i);
        //     }
    
        //     // print results
        //     if (st.size() < 100) {
        //         StdOut.println("keys(\"\"):");
        //         for (String key : st.keys()) {
        //             StdOut.println(key + " " + st.get(key));
        //         }
        //         StdOut.println();
        //     }
    
        //     StdOut.println("longestPrefixOf(\"shellsort\"):");
        //     StdOut.println(st.longestPrefixOf("shellsort"));
        //     StdOut.println();
    
        //     StdOut.println("longestPrefixOf(\"shell\"):");
        //     StdOut.println(st.longestPrefixOf("shell"));
        //     StdOut.println();
    
        //     StdOut.println("keysWithPrefix(\"shor\"):");
        //     for (String s : st.keysWithPrefix("shor"))
        //         StdOut.println(s);
        //     StdOut.println();
    
        //     StdOut.println("keysThatMatch(\".he.l.\"):");
        //     for (String s : st.keysThatMatch(".he.l."))
        //         StdOut.println(s);
        // }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        for (int i = 0; i < numberOfTestCases; i++) {
            TST<String> dataTrieset = new TST<>();
            // TrieST dataTrieset = new TrieST();
            ArrayList<String> list=new ArrayList<String>();
            boolean flag = true;
            int numberOfPhoneNumbers = sc.nextInt();
            
            for (int j = 0; j < numberOfPhoneNumbers; j++) {
                long y = Long.parseLong(sc.next());
                String number = Long.toString(y);
                // String x = dataTrieset.longestPrefixOf(number);
                list.add(number);
                dataTrieset.put(number, "a");
                
                // if (x == null) {
                //     continue;
                // }
                // if (dataTrieset.contains(x)) {
                //     flag = false;
                // }
                
            }
            for (int counter = 0; counter < list.size(); counter++) {
                int count = 0; 
                for (String z : dataTrieset.keysWithPrefix(list.get(counter))) {
                    count ++;
                }
                if (count > 1) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
