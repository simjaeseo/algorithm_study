import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K, heights[], distance[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        for (int i = 0; i < N-1; i++) {
            distance[i] = heights[i+1] - heights[i];
        }

        Arrays.sort(distance);

        int total = 0;
        for (int i = 0; i < N-K; i++) {
            total += distance[i];
        }

        System.out.println(total);
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        heights = new int[N];
        distance = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

    }
}