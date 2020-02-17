import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TicTaxToe {
    // private static string[][] boardFormation(String[] data) {

    // }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < x; i++) {
            String[] data = new String[3];
            int xcount = 0;
            int ycount = 0;
            for ( int j = 0; j < 3; j++) {
                data[j] = sc.nextLine();
                for ( int k = 0; k < 3; k++) {
                    if (data[j].charAt(k) == 'X') {
                        xcount ++;
                    } else if (data[j].charAt(k) == 'O') {
                        ycount ++;
                    } else {
                        continue;
                    }
                }
            }
            if (ycount > xcount) {
                System.out.println("no");
                // continue;
            } else if (xcount - ycount == 1) {
                System.out.println("yes");
                // continue;
            } else if (xcount - ycount > 1) {
                System.out.println("no");
                // continue;
            } else {
                System.out.println("yes");
            }

            if (sc.hasNextLine()) {
                String dum = sc.nextLine();
            } else {
                return;
            }
        }
    }
}
