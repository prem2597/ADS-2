import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LightAndTransperancy {

    private class LineSegment {
        double x1;
        double y1;
        double x2;
        double y2;
        double r;
        private void setData(double x1, double y1, double x2, double y2, double r) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(sc.nextLine());
        for (int  i = 0; i < numberOfTestCases; i ++) {
            String dummy = sc.nextLine();
            int numberOfLineSegments = Integer.parseInt(sc.nextLine());
            LineSegment obj[] = new LineSegment[numberOfLineSegments];
            for (int j = 0; j < numberOfLineSegments; j++ ) {
                
            }
        }
    }
}