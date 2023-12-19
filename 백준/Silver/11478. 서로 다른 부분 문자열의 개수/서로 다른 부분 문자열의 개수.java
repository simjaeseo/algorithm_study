import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    static Set<String> set2 = new TreeSet<>(Collections.reverseOrder());
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> map2 = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

//        st = new StringTokenizer(br.readLine());

        String S = br.readLine();

        for (int subLength = 1; subLength <= S.length(); subLength++) {

            for (int startIndex = 0; startIndex < S.length(); startIndex++) {

                if(startIndex +  subLength > S.length()) break;

                set.add(S.substring(startIndex, startIndex+subLength));

            }


        }
//        for(String s : set){
//            System.out.println(s);
//        }

        System.out.println(set.size());
    }


}