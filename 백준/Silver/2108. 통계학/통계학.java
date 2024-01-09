import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static int n, k;
    private static ArrayList<Integer> l = new ArrayList<>();
    private static ArrayList<Integer> l2 = new ArrayList<>();
    private static Map<Integer, Integer> m = new HashMap<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(br.readLine());

            sum+= k;
            l.add(k);
            m.put(k, m.getOrDefault(k, 0) + 1);
        }

        Collections.sort(l);

        sb.append((int) Math.round((double) sum/ (double) n)).append('\n').append(l.get(n/2)).append('\n');

        int max = 0;
        int number = 0;
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            if(entry.getValue() == max){
                l2.add(entry.getKey());
            }

        }

        Collections.sort(l2);


        sb.append(l2.size() == 1 ? l2.get(0) : l2.get(1)).append('\n').append(l.get(l.size()-1 ) - l.get(0));
        System.out.println(sb);
    }
}