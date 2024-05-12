import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        System.out.println(dp(N));

    }

    private static int dp(int n) {

        if(dp[n] == null){
            dp[n] = (dp(n-2) + dp(n-1))  % 15746;
        }
        return dp[n];
    }

    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];

        dp[0] = 0;
        dp[1] = 1;
        if(N >= 2) dp[2] = 2;
    }

}