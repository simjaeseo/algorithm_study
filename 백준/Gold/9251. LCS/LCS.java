import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String A, B;
    static int dp[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[A.length()][B.length()]);
    }

    private static void init() throws IOException {
        A = br.readLine();
        B = br.readLine();

        dp = new int[A.length() + 1][B.length() + 1];

        // 첫 번째 행과 첫 번째 열을 0으로 초기화
        for (int i = 0; i <= A.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= B.length(); j++) {
            dp[0][j] = 0;
        }
    }
}