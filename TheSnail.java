import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheSnail {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String data = sc.nextLine();
            int count = 0;
            int m = 0;
            String[] x = data.split(" ");
            int h = Integer.parseInt(x[0]);
            int u = Integer.parseInt(x[1]);
            int d = Integer.parseInt(x[2]);
            int f = Integer.parseInt(x[3]);
            while ( m == h ) {
                double y = (double) m;
                if ( h == 0 ) {
                    return;   
                }
                y = y + u;
                y = y - d;
                
                
            }
        }
        
    }
}