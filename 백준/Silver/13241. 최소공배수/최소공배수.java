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


        st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        long minNumber = Math.min(A, B);
        long maxNumber = Math.max(A, B);

        long multiplyNumber = 1;
        long multiplyResult = 0;

        while (true) {
            multiplyResult = minNumber * multiplyNumber++;

            if (multiplyResult % maxNumber == 0) break;
        }

        System.out.println(multiplyResult);
    }


}