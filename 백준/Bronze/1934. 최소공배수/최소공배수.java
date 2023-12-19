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

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int minNumber = Math.min(A,B);
            int maxNumber = Math.max(A,B);

            int multiplyNumber = 1;
            int multiplyResult = 0;

            while(true){
                multiplyResult = minNumber * multiplyNumber++;

                if(multiplyResult%maxNumber == 0) break;
            }

            sb.append(multiplyResult).append('\n');
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }


}