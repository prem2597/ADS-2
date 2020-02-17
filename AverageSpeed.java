import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AverageSpeed {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double speed = 0;
        double z = 0;
        int h = 0;
        int m = 0;
        int s = 0;
        double distance = 0.0;
        while(sc.hasNextLine()) {
            String x = sc.nextLine();
            String[] data = x.split(" ");
            // double speed = 0;
            String[] sample = data[0].split(":");
            System.out.println(sample[0]);
            int hour = Integer.parseInt(sample[0]);
            int p = hour;
            int min = Integer.parseInt(sample[1]);
            int sec = Integer.parseInt(sample[2]);
            if ((data.length) > 1) {
                z = Double.parseDouble(data[1]);
            }

            // if ( hour < h ) { 
            //     else if (hour == h && min < m) {
            //         else if (hour == h && min == m && sec < s) {
            //             p += 24;
            //         }
            //         p += 24;
            //     }
            //     p += 24;
            // }
            if (hour < h || hour == h && min < m || hour == h && min == m && sec < s) {
                p = p + 24;
            }

			distance = distance + speed*((p-h)*3600+(min-m)*60+(sec-s));

			if (st.hasMoreTokens()) {
                // x = sc.nextLine();
                // data = x.split(" ");
                // double speed = 0;
                // sample = data[0].split(":");
                
                // int hour = Integer.parseInt(sample[0]);
                // int p = hour;
                // int min = Integer.parseInt(sample[1]);
                // int sec = Integer.parseInt(sample[2]);
				speed = z / 3600.0;
			} else {
				System.out.printf(data[0] + " " + distance + " km");
			}
			h = hour;
			m = min;
			s = sec;

        }
    }
}