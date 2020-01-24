import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Mapmarker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        // System.out.println(x);
        String[] dump = x.split(" ");
        int numberOfTestCases = Integer.parseInt(dump[0]);
        int numberOfArrays = Integer.parseInt(dump[1]);
        String[] arrayNameDataStore = new String[numberOfTestCases];
        for (int i = 0; i < numberOfTestCases; i++) {
            x = sc.nextLine();
            // System.out.println(x);
            String[] data = x.split(" ");
            arrayNameDataStore[i] = data[0];

        }
    }
}