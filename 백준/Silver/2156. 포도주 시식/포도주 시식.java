import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, wines[];
    static Integer dp[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        dp = new Integer[N+1];
        dp[0] = 0;
        dp[1] = wines[1];
        
        if(N >= 2) dp[2] = wines[1] + wines[2];

        System.out.println(dp(N));

    }

    private static int dp(int n) {

        if(dp[n] == null){
            dp[n] = Math.max(Math.max(dp(n-3) + wines[n-1]+ wines[n], dp(n-2)+ wines[n]), dp(n-1)) ;
        }

        return dp[n];
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        wines = new int[N+1];

        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
    }
}
