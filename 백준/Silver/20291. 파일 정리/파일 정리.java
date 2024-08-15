import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static Map<String, Integer> map = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("\\.");

            map.put(inputs[1], map.getOrDefault(inputs[1],0) + 1);
        }

        for(String str : map.keySet()){
            sb.append(str).append(" ").append(map.get(str)).append('\n');
        }
        System.out.print(sb);
    }

}