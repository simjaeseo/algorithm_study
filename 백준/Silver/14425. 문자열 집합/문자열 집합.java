import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N;
    static ArrayList<Integer> originList = new ArrayList<>();
    static ArrayList<Integer> sortedList = new ArrayList<>();
    static Set<Integer> numberSet = new HashSet<>();
    static Map<String, Boolean> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


//        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if(map.containsKey(br.readLine())){
                count++;
            }
        }

        System.out.println(count);
    }


}