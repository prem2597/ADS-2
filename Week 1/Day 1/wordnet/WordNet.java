// import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
// import edu.princeton.cs.algs4.Map;
import edu.princeton.cs.algs4.Digraph;
// import edu.princeton.cs.algs4.HashMap;
// import edu.princeton.cs.algs4.Iterator;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * Implementing the parsing logic to check the data in CSV file so that to form
 * a wordNet. For the Parsing the csv file in java I had refered to Geeks for
 * Geeks.
 *
 * @author PREM
 * reference GeeksforGeeks for parsing.
 */
public final class WordNet {
    /**
     * Creating an object for digraph class.
     */
    private edu.princeton.cs.algs4.Digraph obj;
    private SAP sap;
    // Constructor.
    /**
     * Wordnet file to represents the relation between the synset and hypernyms.
     * @param filename1   synsets file.
     * @param filename2   Hypernyms files.
     */
    public WordNet(final String filename1,
    final String filename2) {
        synsetdata = parseSynsets(filename1);
        map = parseHypernyms(filename2);
        obj = new edu.princeton.cs.algs4.Digraph(synsetdata.size());
        sap = new SAP(obj);
    }
    /**
     * Here we are writing the code to store the data in hash map.
     */
    private static HashMap<String, String> synsetdata = new HashMap<>();
    /**
     * Here we are writing the code to store the data in such a way
     * that one key will have multiple values in it.
     */
    private Map<String, List<String>> map = new HashMap<String, List<String>>();

    /**
     * This method will take the Synsets file as
     * the input and will parse the data.
     * This method will also store all the synsets.
     *
     * @param filename Synsets file location.
     * @return return string array.
     * @throws IOException Exception handling.
     */
    private HashMap<String, String> parseSynsets(final String filename) {
        // String[] synsetsArray = {};
        // int k = synsetsArray.length;
        try {
            In data = new In(filename);
            // In bufRead = new In();
            String myLine = null;
            while ((myLine = data.readLine()) != null) {
                String[] array1 = myLine.split(",");
                // String[] array2 = array1[1].split(" ");
                // for (int i = 0; i < array1.length; i++) {
                // System.out.println(array1[i]);
                // System.out.println(array1[i+1]);
                // }
                System.out.println(array1[0]);
                System.out.println(array1[1]);
                synsetdata.put(array1[0], array1[1]);
            }
            data.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return synsetdata;
    }

    /**
     * This method will parse the data of the hypernyms and stores its values.
     *
     * @param filename hypernyms file location.
     * @return returns String array.
     * @throws IOException Exception handling cases.
     */
    private Map<String, List<String>> parseHypernyms(final String filename) {
        try {
            In data = new In(filename);
            // BufferedReader bufRead = new BufferedReader(data);
            String myLine = null;
            while ((myLine = data.readLine()) != null) {
                String[] array1 = myLine.split(",");
                // String[] array2 = array1[1].split(" ");
                for (int i = 0; i < array1.length; i++) {
                    System.out.println(array1[i]);
                }
                List<String> listdata = new ArrayList<String>();
                for (int i = 1; i < array1.length; i++) {
                    // System.out.println(array1[i]);
                    listdata.add(array1[i]);
                }
                // valSetOne.add("Apple");
                // valSetOne.add("Aeroplane");
                map.put(array1[0], listdata);
            }
            data.close();
            // System.out.println(map(25));
            // for (int j = 0; j <= 253; j++) {
            // System.out.println(map.get("166"));
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Iterable<String> nouns() {
        return synsetdata.keySet();
    }

    public boolean isNoun(String word) {
        return synsetdata.containsKey(word);
    }

    public int distance(String nounA, String nounB) {
        if (nounA == null) {
            throw new java.lang.NullPointerException();
        }
        if (nounB == null) {
            throw new java.lang.NullPointerException();
        }
        if (!isNoun(nounA)) {
            throw new java.lang.IllegalArgumentException();
        }
        if (!isNoun(nounB)) {
            throw new java.lang.IllegalArgumentException();
        }
        int indexA = -1;
        int indexB = -1;
        // for (String s : synsetdata.keySet()) {
        //     if (s.equals(nounA)){
        //         indexA = synsetdata.getKey(s);
        //     }
        // }
        Iterator data = synsetdata.entrySet().iterator();
        while (data.hasNext()) {
            Map.Entry x = (Map.Entry) data.next();
            if(x.getValue().equals(nounA)) {
                indexA = (int) x.getKey();
                break;
            }
            // if(x.getValue().equals(nounA)) {
            //     indexB = (int) x.getKey();
            // }
        }
        while (data.hasNext()) {
            Map.Entry x = (Map.Entry) data.next();
            if(x.getValue().equals(nounA)) {
                indexB = (int) x.getKey();
                break;
            }
            // if(x.getValue().equals(nounA)) {
            //     indexB = (int) x.getKey();
            // }
        }
        return sap.length(indexA, indexB);
        // return 0;
    }

    public String sap(String nounA, String nounB) {
        int indexA = -1;
        int indexB = -1;
        Iterator data = synsetdata.entrySet().iterator();
        while (data.hasNext()) {
            Map.Entry x = (Map.Entry) data.next();
            if(x.getValue().equals(nounA)) {
                indexA = (int) x.getKey();
                break;
            }
            // if(x.getValue().equals(nounA)) {
            //     indexB = (int) x.getKey();
            // }
        }
        while (data.hasNext()) {
            Map.Entry x = (Map.Entry) data.next();
            if(x.getValue().equals(nounA)) {
                indexB = (int) x.getKey();
                break;
            }
            // if(x.getValue().equals(nounA)) {
            //     indexB = (int) x.getKey();
            // }
        }
        int ancestor = sap.ancestor(indexA, indexB);
        return synsetdata.get(ancestor);
    }
    /**
     * The main method is used to call the
     * synsets and hypernyms and parse the data.
     *
     * @param args String arguments
     * @throws IOException Exception handling
     */
    // public static void main(final String[] args) throws IOException {
    //     // System.out.print("a1");
    //     String parseSynsets =
    //     "/home/prem/Documents/ADS-2_2019501109/Week 1/Day 1/synsets.txt";
    //     // System.out.print("a2");
    //     String parseHypernyms =
    //     "/home/prem/Documents/ADS-2_2019501109/Week 1/Day 1/hypernyms.txt";
    //     // parseSynsets(parseSynsets);
    //     // parseHypernyms(parseHypernyms);
    //     WordNet a = new WordNet(parseSynsets, parseHypernyms);
    //     // System.out.print("a");
    //     for (Map.Entry<String, List<String>> entry : a.map.entrySet()) {
    //         for (int i = 0; i < entry.getValue().size(); i++) {
    //             a.obj.addEdge(Integer.parseInt(entry.getKey()),
    //             Integer.parseInt(entry.getValue().get(i)));
    //         }
    //     }
    // }
}
