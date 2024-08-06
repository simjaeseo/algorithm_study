import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static String[] pair;
    static Map<String, String> map = new HashMap<>();
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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            pair = br.readLine().split(" ");

            map.put(pair[0], pair[1]);
        }

        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.print(sb);

    }

}