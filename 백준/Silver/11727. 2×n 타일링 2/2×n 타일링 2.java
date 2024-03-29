import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Integer[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        init();

        process();

        System.out.print(dp[N] % 10007);
    }

    private static void process() {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        if(N <= 2) return;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2)% 10007;
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        if(N <= 1) dp = new Integer[3];
        else dp = new Integer[N+1];
    }

}