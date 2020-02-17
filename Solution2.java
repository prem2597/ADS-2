import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {
    LinkedList<Integer> cache = new LinkedList<>();
    int miss = 0;
    public void check(int a, int b) {
        if(cache.contains(a)) {
            cache.remove(a);
            cache.add(a);
        } else {
            if(cache.size() < b) {
                cache.add(a);
            } else{
                cache.remove();
                cache.add(a);
            }
            miss++;
        }
    }
    public int stat() {
        return miss;
    }
    public void reset() {
        miss = 0;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());

        String[] y = sc.nextLine().split(" ");
        int[] size = new int[x];
        Solution2[] cache = new Solution2[x];
        for (int i = 0; i < x; i++) {
            size[i] = Integer.parseInt(y[i]);
        }
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(" ");
            if (data[0].equals("RANGE")) {
                int b = Integer.parseInt(data[1]);
                int c = Integer.parseInt(data[2]);
                int k = Integer.parseInt(data[3]);
                for(int i = 0; i < x; i++) {
                    for(int j = 0; j < k; j++) {
                        int result = b + c * j;
                        cache[i].check(result, size[i]);
                    }
                }
            } else if(data[0].equals("ADDR")) {
                for(int i = 0; i < x; i++) {
                    cache[i].check(Integer.parseInt(data[1]),size[i]);
                }

            } else if (data[0].equals("STAT"))  {
                // break;
                for ( int j = 0; j < x; j++) {
                    System.out.println(cache[i].stat() + " ");
                    cache[i].reset();
                }
            } else if (data[0].equals("END"))  {
                break;
            }
        }
    }
}