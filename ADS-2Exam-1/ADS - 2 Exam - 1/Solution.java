import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
public class Solution {
    public Digraph obj;
    Solution(String filename, String filename2) {
        emailData = parseEmailData(filename);
        emaillogs = parseEmaillogs(filename2);
        obj = new Digraph(999999);
    }
    
    private static HashMap<Integer, String> emailData = new HashMap<>();
    private static HashMap<Integer, Integer> emaillogs = new HashMap<>();
    private HashMap<Integer, String> parseEmailData(final String filename) {
        try {
            In data = new In(filename);
            String myLine = null;
            while ((myLine = data.readLine()) != null) {
                String[] array1 = myLine.split(";");
                // System.out.println(array1[0]);
                // System.out.println(array1[1]);
                emailData.put(Integer.parseInt(array1[0]), array1[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailData;
    }
    private HashMap<Integer, Integer> parseEmaillogs(final String filename) {
        try {
            In data = new In(filename);
            String myLine = null;
            while ((myLine = data.readLine()) != null) {
                // String numbers = "";
                String[] array1 = myLine.split(",");
                // numbers = array1[0].replaceAll("[^0-9]", "");
                // System.out.println(array1[0]);
                // System.out.println(array1[1]);
                emaillogs.put(Integer.parseInt(array1[0].replaceAll("[^0-9]", "")), Integer.parseInt(array1[1].replaceAll("[^0-9]", "")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emaillogs;
    }
    public static void main(String[] args) {
        HashMap<String, Integer> store = new HashMap<>();
        String parseEmailData =
        "/home/prem/Documents/ADS-2_2019501109/ADS-2_2019501109-1/ADS-2Exam-1/ADS - 2 Exam - 1/emails.txt";
        String parseEmaillogs =
        "/home/prem/Documents/ADS-2_2019501109/ADS-2_2019501109-1/ADS-2Exam-1/ADS - 2 Exam - 1/email-logs.txt";
        Solution a = new Solution(parseEmailData, parseEmaillogs);
        for (HashMap.Entry<Integer, Integer> entry : a.emaillogs.entrySet()) {
            a.obj.addEdge(entry.getKey(), entry.getValue());
        }
        
        // String s;
        // int s1;
        // s = a.emailData.get(265213);
        // System.out.println(s);
        // s1 = a.emaillogs.get(1);
        // System.out.println(s1);
        // System.out.println(a.obj.indegree(714));
        for (HashMap.Entry<Integer, String> entry : a.emailData.entrySet()) {
            store.put(entry.getValue(), a.obj.indegree(entry.getKey()));
            // a.obj.addEdge(entry.getKey(), entry.getValue());
        }
        // Map.Entry<Integer, Bar> maxEntry = null;
        // for (Map.Entry<Foo, Bar> entry : map.entrySet())
        // {
        //     if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
        //     {
        //         maxEntry = entry;
        //     }
        // }

        In in = new In();
        // System.out.println("Enter the number :");
        int x = in.readInt();
        // System.out.println(x);
        // for(int i = 0; i <= x; i++) {

        // }
        // int s2 = store.get("6608@gmail.com");
        // System.out.println(s2);
        int i = 0;
        // Map.Entry<Integer, Bar> maxEntry = null;
        // Set keys = store.keySet();
        HashMap.Entry<String, Integer> maxEntry = null;
        for (HashMap.Entry<String, Integer> entry : store.entrySet())
        {
            if (maxEntry == null ||
            entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
                i++;
                String key = (String) maxEntry.getKey();
                int value = store.get(key);
                System.out.println(value+","+ key);
                if(i == x) {
                    return;
                }
            }
        }
    }
}
