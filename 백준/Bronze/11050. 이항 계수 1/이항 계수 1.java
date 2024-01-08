import java.io.*;
import java.util.*;


public class Main {
    private static int n, k;
    private static Deque<Integer> qs = new ArrayDeque<>();
    private static boolean[] isQueue;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {

    }

    private static void print() throws IOException {
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int bunja = 1;

        for (int i = 1; i <= n; i++) {
            bunja *= i;
        }

        int bunmo = 1;

        for (int i = 1; i <= n - k; i++) {
            bunmo *= i;
        }
        for (int i = 1; i <= k; i++) {
            bunmo *= i;
        }

        System.out.println(bunja/bunmo);


    }
}