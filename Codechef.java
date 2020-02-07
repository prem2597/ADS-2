import java.util.Scanner;
import java.util.ArrayList;
class Codechef {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for ( int i = 0; i < x; i++ ) {
            String data = sc.nextLine().toLowerCase();
            // System.out.println(data);
            int count = 0;
            int count2 = 0;
            int count3 = 0;
            ArrayList<Character> unique = new ArrayList<>();
            for ( int j = 0; j < data.length(); j++) {
                unique.add(data.charAt(j));
            }

        // System.out.println(unique.size());
            // for (int k = 0; k < unique.size(); k++) {
            for (char name : unique) {
                
                // System.out.println(name);
                if (name == 'h') {
                    count ++;
                }
                if (name == 'e') {
                    count ++;
                }
                if (name == 'l') {
                    count2 ++;
                }
                if (name == 'o') {
                    count3 ++;
                }
                if (name == 'w') {
                    count ++;
                }
                if (name == 'r') {
                    count ++;
                }
                if (name == 'd') {
                    count ++;
                }
            }
            // System.out.println(count);
            // System.out.println(count2);
            // System.out.println(count3);
            if (count == 5 && count2 == 3 && count3 == 2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}