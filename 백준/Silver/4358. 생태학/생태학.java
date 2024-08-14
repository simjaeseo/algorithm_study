import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int total;
    static String input = "";
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        while(!pq.isEmpty()){
            String tree = pq.poll();
            double percentage = (double) map.get(tree) / total * 100;
            sb.append(tree).append(" ").append(String.format("%.4f", percentage)).append('\n');
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        while((input = br.readLine()) != null && !input.isEmpty()){
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;
        }
        pq.addAll(map.keySet());
    }
}