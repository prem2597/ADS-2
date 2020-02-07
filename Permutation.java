import java.util.Scanner;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

import java.util.HashMap;
public class Permutation {
    private static int k = 1;
    public static int fact(String str) {
        int fact = 1;
        
        int number = str.length();
        for (int j = 1; j <= number; j++) {
            fact = fact * j;
        }
        return fact;
    }

    public static void storeData(char[] result, int len, HashMap z, String data) {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            x.append(result[i]);
        }
        // System.out.println(x);
        if (x.length() == data.length() && k <= fact(data)) {
            // System.out.println(x);
            z.put(k,x);
            k ++;
        }
    }

    private static void StringBuild(char[] result, char[] str, int[] count, int level, int size, int length, HashMap z, String data) {
        if (level == size) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (count[i] == 0) {
                continue;
            }
            count[i]--;
            result[level] = str[i];
            storeData(result, level, z, data);
            StringBuild(result, str, count, level + 1, size, length, z, data);
            count[i]++;
        }
    }
    private static void permutaion(String str, HashMap z, String data) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for ( int i = 0; i< str.length(); i++) {
            mp.put(str.charAt(i), mp.get(str.charAt(i)) == null ? 1 :  
                                  mp.get(str.charAt(i)) + 1); 
            char[] charcaters = new char[mp.size()];
            int[] count = new int[mp.size()];
            char[] result = new char[str.length()];
            int j = 0;
            for (HashMap.Entry<Character, Integer> entry : mp.entrySet()) {
                charcaters[j] = entry.getKey();
                count[j] = entry.getValue();
                j ++;

            }
            int length = mp.size();
            int size = str.length();
            StringBuild(result, charcaters, count, 0, size, length, z, data);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < x; i++) {
            String data = sc.nextLine();
            int retrieve = Integer.parseInt(sc.nextLine());
            HashMap<Integer,StringBuilder> z = new HashMap<>();
            
            permutaion(data, z, data);
            System.out.println(z.get(retrieve + 1));
        }
    }
}