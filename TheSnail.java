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
            double m = 0;
            String[] x = data.split(" ");
            double h = Double.parseDouble(x[0]);
            double u = Double.parseDouble(x[1]);
            double d = Double.parseDouble(x[2]);
            double f = Double.parseDouble(x[3]);
            double fat = (u * f)/100.00;
            if ( h == 0 ) {
                break;   
            }
            while ( m <= h  && m >= 0) {
                count = count + 1;
                if ( h == 0 ) {
                    break;   
                }
                m = m + u;
                if ( m > h ) {
                    break;   
                }
                m = m - d;
                u = Math.max(0, u-fat);
            }
            if ( m >= h ) {
                System.out.println("success on day " + count);
            } else {
                System.out.println("failure on day " + count);
            }
        }
        
    }
}