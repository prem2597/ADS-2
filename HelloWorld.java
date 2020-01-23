// import java.util.Scanner;
public class HelloWorld{
    
    public static int range(int i, int j) {
        int count = 0;
        int z = 0;
        for (int v = i; v<= j; v++) {
            int m = v;
            count = 0;
            while ( m != 1) {
                if (m % 2 != 0) {
                    m = 3*m + 1;
                    // count = count + 1;
                } else if (m %2 == 0) {
                    m = m/2;
                    // count = count + 1;
                }
                count = count + 1;
            }
            if ( count > z) {
                z = count;
            }
            // System.out.print(z);
        }
        return z + 1;
    }

     public static void main(String []args){
        int i = 1, j = 10;
            // int count = 0;
            // int z = 0;
//             for (int m = i; m <= j; m++) {
                
//             }
        System.out.println(i+" "+j+" "+range(i, j));
     }
}