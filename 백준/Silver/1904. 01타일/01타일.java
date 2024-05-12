import java.util.*;
import java.io.*;

public class Main {
    static int A, B, C;
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        System.out.println(dp(A));

    }

    private static int dp(int n) {

        if(n == 1 ) return 1;
        if(n == 2) return 2;


        if(dp[n] == null){
            dp[n] = (dp(n-2) + dp(n-1))  % 15746;
        }
        return dp[n];
    }

    private static void init() throws IOException {

        A = Integer.parseInt(br.readLine());

        dp = new Integer[A+1];

        dp[0] = 0;
        dp[1] = 1;
        if(A >= 2) dp[2] = 2;
    }

}