import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Requestforproposal {
    // private static class company {
    //     String name;
    //     double price;
    //     int r;
    //     company(String name, Double price, int r) {
    //         this.name = name;
    //         this.price = price;
    //         this.r = r;
    //     }
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()) {
            // HashMap<Double,String> p = new HashMap<>();
            String x = sc.nextLine();
            String[] size = x.split(" ");
            int requirements = Integer.parseInt(size[0]);
            int proposals = Integer.parseInt(size[1]);
            if (requirements == 0 && proposals == 0) {
                return;
            }
            for (int i = 0; i < requirements; i++) {
                String y = sc.nextLine();
            }
            String finalname = "";
            Double finalprice = 0.0;
            int finalr = 0;
            count ++;
            for (int i = 0; i < proposals; i++) {
                String name = sc.nextLine();
                String[] z = sc.nextLine().split(" ");
                Double price = Double.parseDouble(z[0]);
                int r = Integer.parseInt(z[1]);
                for ( int j = 0; j < r; j++) {
                    String u = sc.nextLine();
                }
                // p.put(price, name);
                if (r > finalr || r == finalr &&  finalprice > price) {
                    finalr = r;
                    finalprice = price;
                    finalname = name;
                }

            }
            System.out.println("RFP #" + count);
            System.out.println(finalname);
            System.out.println();
        }
    }

}