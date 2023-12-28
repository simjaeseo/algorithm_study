import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n;
    private static Queue<Integer> q = new LinkedList<>();



    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while(q.size() != 1){
            q.poll();
            q.add(q.poll());
        }
    }

    private static void print() {
        System.out.println(q.poll());
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}