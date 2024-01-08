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
        n = Integer.parseInt(br.readLine());

        System.out.println(n * (n - 1));
    }
}