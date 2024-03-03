import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        progress();
    }

    private static void progress() {
        dp = new Integer[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(recursion(n));
    }

    private static int recursion(int n) {

        if(dp[n] == null){
            dp[n] = (recursion(n-1) + recursion(n-2)) % 10007;
        }

        return dp[n];

    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

}