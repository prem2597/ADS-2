import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// import com.sun.javafx.geom.Edge;

import java.util.Scanner;
public class NonStopTravel {
    private static Edge e;
    // Topological t = new Topological(e);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfIntersection = Integer.parseInt(sc.nextLine());
        for( int  i = 1; i <= numberOfIntersection; i++) {
            String x = sc.nextLine();
            String[] arr = x.split(" ");
            int count = Integer.parseInt(arr[0]);
            int m = 0;
            for (int j = arr.length - 1; j >= 1 ; j--) {
                if (count == 0) {
                    return;
                }
                if ( m == count ) {
                    return;
                }
                e = new Edge(i, Integer.parseInt(arr[j - 1]), Integer.parseInt(arr[j]));
                m ++;
                j--;
                System.out.println(e.toString());
            }
        }
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(e);
        Topological t = new Topological(ewg);
        // System.out.println(e.toString());
        // e.edges();
    }
}

