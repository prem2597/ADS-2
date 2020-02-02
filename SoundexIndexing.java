import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashMap; 
import java.util.Map; 

public class SoundexIndexing {
    
    private static String encode(HashMap map, StringBuilder str, String data) {
        StringBuilder str2 = new StringBuilder();
        str2.append(data.charAt(0));
        for (int k = 1; k < data.length(); k++) {
            System.out.println(k);
            System.out.println(map.get(data.charAt(k-1)));
            // str2.append(data[0]);
            if (str2.length() == 4) {
                str.append(data);
                str.append(';');
                str.append(str2);
                return str.toString();
            }
            if ((map.get(data.charAt(k-1)) == map.get(data.charAt(k))) || data.charAt(k) == 'A' ||
            data.charAt(k) == 'E' || data.charAt(k) == 'I' || data.charAt(k) == 'O' || data.charAt(k) == 'U' ||
            data.charAt(k) == 'Y' || data.charAt(k) == 'W' || data.charAt(k) == 'H') {
            
            } else {
                str2.append(map.get(data.charAt(k)));
            } 
        }
        while (str2.length() < 4) {
            str2.append('0');
        }
        str.append(data);
        str.append(';');
        str.append(str2);
        return str.toString();
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('B', 1);
        map.put('P', 1);
        map.put('F', 1);
        map.put('V', 1);
        map.put('C', 2);
        map.put('S', 2);
        map.put('K', 2);
        map.put('G', 2);
        map.put('J', 2);
        map.put('Q', 2);
        map.put('X', 2);
        map.put('Z', 2);
        map.put('D', 3);
        map.put('T', 3);
        map.put('L', 4);
        map.put('M', 5);
        map.put('N', 5);
        map.put('R', 6);
        // System.out.println("Size of map is:- "+ map.size());
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            String[] data = name.split(" ");
            for (int i = 0; i < data.length; i++) {
                StringBuilder str = new StringBuilder(); 
                String s = encode(map, str, data[i]);
                System.out.println(s);
            }
        }
    }
}
