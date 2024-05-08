import java.util.*;
import java.io.*;

public class Main {
    static int N, countRecursion, countDP = 1;
    static int dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        fiboRecursion(N);
        fiboDP(N);

        System.out.println(countRecursion + " " + countDP);
    }

    private static int fiboDP(int n) {
        dp[1] = dp[2] = 1;
        for (int i = 3; i < N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
            countDP++;
        }
        return dp[N];

    }

    private static int fiboRecursion(int n) {
        if(n == 1 || n == 2)    {
            countRecursion++;
            return 1;
        }
        return fiboRecursion(n-2) + fiboRecursion(n-1);
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
    }

}