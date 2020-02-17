import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Prem
 */

public class CacheSimulation {

    // static Queue<Integer> q;

    // CacheSimulation() {
    //     q = new LinkedList<>();
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        ArrayList[] al = new ArrayList[x];
        // int[] miss = new int[size];

        String[] y = sc.nextLine().split(" ");
        int sizeOfQueue1 = Integer.parseInt(y[0]);
        int sizeOfQueue2 = Integer.parseInt(y[1]);
        long[] size = new long[sizeOfQueue1];
        int[] miss = new int[sizeOfQueue2];
        // int[] hit = new int[sizeOfQueue2];
        // for (int i = 0; i < x ; i ++) {
        //     Arrays.fill(size[i],0);

            
        // }

        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(" ");
            if (data[0].equals("RANGE")) {
                int b = Integer.parseInt(data[1]);
                int c = Integer.parseInt(data[2]);
                int k = Integer.parseInt(data[3]);
                for (int i = 0; i < k; i++ ) {
                    int result = b + c * k;
                    for (int j= 0 ; j < x ; j ++) {
                        if (al[j].contains(result)) {
                            al[j].remove(result);
                            al[j].add(result);
                        }
                        else if (!al[j].contains(result)) {
                            // miss[j] += 1;
                            if (al[i].size() == sizeOfQueue1) {
                                miss[j] += 1;


                            } else {
                                al[j].add(result);
                                miss[j] += 1;
                            }

                        }
                    }
                }
            } else if (data[0].equals("ADDR"))  {
                // break;
                int p = Integer.parseInt(data[1]);
                for (int i = 0; i < x; i++) {
                    if(al[i].contains(p)) {
                        al[i].remove(p);
                        al[i].add(p);
                    } else if (al[i].size() == sizeOfQueue1 || al[i].size() == sizeOfQueue1) {

                    }
                }

            } else if (data[0].equals("STAT"))  {
                // break;
                for ( int j = 0; j < miss.length; j++) {
                    System.out.println(miss[j] + " ");
                }
            } else if (data[0].equals("END"))  {
                break;
            }
        }
    }
}
