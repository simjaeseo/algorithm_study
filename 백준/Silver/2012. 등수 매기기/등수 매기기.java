import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, ranks[];


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        long sum = 0;

        Arrays.sort(ranks);

        for (int i = 1; i <= N; i++) {
            sum += Math.abs( ranks[i-1] - i);
        }

        System.out.println(sum);

    }


    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        ranks = new int[N];

        for (int i = 0; i < N; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }
    }
}

