import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
public class Tex {
    // static String newString = "";
    // public static String insertString(String string, String stringToBeInserted, int index) {
    //     newString = new String();
    //     for (int i = 0; i < string.length(); i++) {
    //         if (i == index) {
    //             // newString.replace
    //             // newString = newString.substring(i,);
    //             newString += stringToBeInserted;
    //         } else {
    //             newString += string.charAt(i);
    //         }
    //         // System.out.println(newString);  
    //     }
    //     // System.out.println(newString);
    //     return newString;
    // }

    // public static void main(String[] args) {
    //     // String newString = "";
    //     /*
    //      * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
    //      * class should be named Solution.
    //      */
    //     Scanner sc = new Scanner(System.in);
    //     // while(sc.hasNextLine()) {
    //     // String x = sc.nextLine();
    //     // for (int i = 0; i < x.length(); i++) {
    //     // if (x.charAt(i) == '\"') {

    //     // }
    //     // }
    //     // }
    //     while (sc.hasNextLine()) {
    //         String x = sc.nextLine();
    //         StringBuilder string = new StringBuilder(x);
    //         String m = x;
    //         // int count = 0;
    //         boolean h = true;
    //         for (int i = 0; i <= x.length(); i++) {
    //             // m = x;
    //             if (m.charAt(i) == '\"') {
    //                 // count = count + 1;
    //                 h = !h;
    //                 if (h == false) {
    //                     // string.setCharAt(i,'`');
                        
    //                     m = insertString(m, "``", i);
    
    //                 } else if (h == true) {
    //                     // string.setCharAt(i, '\"');
    //                     m = insertString(m, "''", i);
    //                 }
    //             }
    //         }
    //         System.out.println(m);
    //     }
    // }
    // public static void main(String[] args) {
    //     /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    //     Scanner sc = new Scanner(System.in);
    //     String out = "";
    //     boolean flag = false;
    //     while(sc.hasNextLine()) {
    //         StringBuffer string = new StringBuffer();
    //         String x = sc.nextLine();
    //         for (int i = 0; i < x.length(); i++) {
    //             if (x.charAt(i) == '"') {
    //                 if (flag) {
    //                     string.append("''");
    //                     flag = false;
    //                 } else {
    //                     string.append("``");
    //                     flag = true;
    //                 }
    //             }  else {
    //                 string.append(x.charAt(i));
    //             }
    //         }
    //     System.out.println(string);
    //     }
    // sc.close();
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String x = sc.nextLine();
            for (int i = 0; i < x.length(); i++) {
                System.out.println(x.charAt(i));
            }
        }
    }
}