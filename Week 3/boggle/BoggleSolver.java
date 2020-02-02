// import edu.princeton.cs.algs4.TrieSET;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is used to implement the Boggle solver and the score
 * for the boggle solver game.
 * @author PREM
 */
public class BoggleSolver {
    private TrieSET triedata;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        triedata = new TrieSET();
        for (int i = 0; i < dictionary.length; i++) {
            triedata.add(dictionary[i]);
        }

    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        Set<String> arr = new HashSet<String>();
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                String flag = "";
                boolean[][] entered = new boolean[board.rows()][board.cols()];
                solver(board, i, j, entered, flag, arr);
            }
        }
        return arr;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if(triedata.contains(word)) {
            if (word.length() == 3 || word.length() == 4) {
                return 1;
            } else if (word.length() == 5) {
                return 2;
            } else if (word.length() == 6) {
                return 3;
            } else if (word.length() == 7) {
                return 5;
            } else if (word.length() >= 8) {
                return 11;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
        // return 0;
    }

    private void solver(BoggleBoard board, int x, int y, boolean[][] entered, String mx, Set<String> arr) {
        char z = board.getLetter(x,y);
        String t = mx;
        if (entered[x][y]) {
            return;
        }
        if (z == 'Q') {
            t = t + "QU";
        } else {
            t = t + z;
        }
        if (!triedata.hasWord(t)) {
            return;
        }
        // if (triedata.contains(t)) {
        //     return;
        // }
        if (t.length() > 2 && triedata.contains(t)) {
            arr.add(t);
        }
        entered[x][y] = true;
        check(board, x, y, entered, t, arr);
        entered[x][y] = false;
    }

    private void check(BoggleBoard board, int x, int y, boolean[][] entered, String t, Set<String> arr) {
        for (int i = -1 ; i <= 1; i ++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0 ) {
                    continue;
                }
                if (x + i >= 0 && x + i < board.rows() && y + j >= 0 && y + j < board.cols()) {
                    solver(board, x + i, y + j, entered, t, arr);
                }
            }
        }
    }
    // public static void main(String[] args) {
    //     In in = new In(args[0]);
    //     String[] dictionary = in.readAllStrings();
    //     BoggleSolver solver = new BoggleSolver(dictionary);
    //     BoggleBoard board = new BoggleBoard(args[1]);
    //     int score = 0;
    //     for (String word : solver.getAllValidWords(board)) {
    //         StdOut.println(word);
    //         score += solver.scoreOf(word);
    //     }
    //     StdOut.println("Score = " + score);
    // }
}