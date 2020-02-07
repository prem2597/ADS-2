import java.util.Scanner;
import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Iterator;
public class Contest {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for ( int i = 0; i < x; i++ ) {
            String data = sc.nextLine().toLowerCase();
            // System.out.println(data);
            int count = 0;
            ArrayList<Character> unique = new ArrayList<>();
            for(char c : data.toCharArray()) {
                unique.add(c);
            }
            // if (unique.contains('h')) {
            //     count ++;
            // } else if (unique.contains('e')) {
            //     count ++;
            // } else if (unique.contains('l')) {
            //     count ++;
            // } else if (value.next() == 'l' ) {
            //     count ++;
            // } else if (value.next() == 'o' ) {
            //     count ++;
            // } else if (value.next() == 'w' ) {
            //     count ++;
            // } else if (value.next() == 'o' ) {
            //     count ++;
            // } else if (value.next() == 'r' ) {
            //     count ++;
            // } else if (value.next() == 'l' ) {
            //     count ++;
            // } else if (value.next() == 'd' ) {
            //     count ++;
            // } else {

            // }
            // Iterator<Character> value = unique.iterator<>(); 
            // while (value.hasNext()) {
            //     // System.out.println(data.charAt(j));
                
            // }
            if (count == 7) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}