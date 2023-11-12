import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N, A, B, K, sum;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            aMap.put(A, aMap.getOrDefault(A, 0)+1);
            bMap.put(B, bMap.getOrDefault(B, 0)+1);
        }

        for(Map.Entry<Integer, Integer> elem : aMap.entrySet()){
            if(elem.getValue() == 1)    sb.append(elem.getKey()).append(" ");
        }

        for(Map.Entry<Integer, Integer> elem : bMap.entrySet()){
            if(elem.getValue() == 1)    sb.append(elem.getKey());
        }

        System.out.println(sb);
    }


}