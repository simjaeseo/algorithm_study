import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N,T, dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        init();

    }

    private static void process() {

        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        dp = new long[101];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        process();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            sb.append(dp[(int)N]).append('\n');
        }
        System.out.print(sb);
    }
}