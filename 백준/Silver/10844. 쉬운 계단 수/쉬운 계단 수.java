import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Long dp[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    dp[i][0] = dp[i - 1][1]% 1000000000;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8]% 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])% 1000000000;
                }
            }
        }

        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 1000000000);


    }


    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];

        dp[1][0] = 0L;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }
    }
}