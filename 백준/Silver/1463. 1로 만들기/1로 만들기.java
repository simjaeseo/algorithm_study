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
        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;

        System.out.println(recursion(n));


    }

    private static int recursion(int n) {

        if (dp[n] == null) {
            // 6으로 나눠지는 경우
            if (n % 6 == 0) {
                dp[n] = Math.min(recursion(n - 1), Math.min(recursion(n / 3), recursion(n / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (n % 3 == 0) {
                dp[n] = Math.min(recursion(n / 3), recursion(n - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (n % 2 == 0) {
                dp[n] = Math.min(recursion(n / 2), recursion(n - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[n] = recursion(n - 1) + 1;
            }
        }
        return dp[n];
    }


    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

}