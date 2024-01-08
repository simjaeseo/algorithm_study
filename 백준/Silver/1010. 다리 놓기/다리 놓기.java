import java.io.*;
import java.math.BigInteger;
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
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if(n < k){
                int temp = n;
                n = k;
                k  = temp;
            }

            BigInteger bunja = new BigInteger("1");

            for (int j = 1; j <= n; j++) {
                bunja = bunja.multiply(BigInteger.valueOf(j));
            }

            BigInteger bunmo = new BigInteger("1");

            for (int j = 1; j <= n - k; j++) {
                bunmo = bunmo.multiply(BigInteger.valueOf(j));

            }
            for (int j = 1; j <= k; j++) {
                bunmo = bunmo.multiply(BigInteger.valueOf(j));
            }

            System.out.println(bunja.divide(bunmo));

        }



    }
}