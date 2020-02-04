import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BlowingFuses {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()) {
            String data = sc.nextLine();
            String[] m = data.split(" ");
            int x = Integer.parseInt(m[0]);
            int y = Integer.parseInt(m[1]);
            int z = Integer.parseInt(m[2]);
            int max = Integer.MIN_VALUE;
            if ( x == 0 && y == 0 && z == 0) {
                break;
            }
            count = count + 1;
            int[] consumption = new int[x+1];
            for ( int i = 0; i <= x; i++) {
                consumption[i] = sc.nextInt();
            }
            
            int[] status = new int[x + 1];
            int recent = 0;
            int flag = 0;
            for (int i = 0; i < y; i++) {
                int finalstatus = sc.nextInt();
                            
                if (status[finalstatus] == 0) {
                    recent = recent + consumption[finalstatus];
                    status[finalstatus] = 1;
                } else {
                    recent = recent - consumption[finalstatus];
                    status[finalstatus] = 0;
                }
                if (recent > z && flag == 0) {
                    System.out.println("Sequence " + count);
                    System.out.println("Fuse was blown.\n");
                    flag = 1;
                }
                if (max < recent) {
                    max = recent;
                }
            }
            if ( flag == 0) {
                System.out.println("Sequence " + count);
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was "+max+" amperes.\n");
            }
        }
    }
}
