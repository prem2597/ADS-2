import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println("Hello");
        for (int i = 0; i < x; i ++) {
            StringBuilder str = new StringBuilder();
            String data = br.readLine().toLowerCase();
            int size = data.length();
            // int s = size % 26;
            System.out.println("hi");
            for (int j = 0; j < data.length(); j++) {
                int d = (int) data.charAt(j);
                
                System.out.println(d);
                int unicode = (int) data.charAt(j) + size;
                if (unicode > 122) {
                    unicode = unicode%26 + 96;
                }
                char character = (char) unicode;
                str.append(character);
            }
            System.out.println(str);
        }
    }
}