import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, t, z , o;
    static Integer dp[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void progress() {
        fibonacci(n);

        System.out.println(dp[n][0] + " " + dp[n][1]);
    }

    private static Integer[] fibonacci(int number) {

        if(dp[number][0] == null || dp[number][1] == null){
            dp[number-1] = fibonacci(number - 1);
            dp[number-2] = fibonacci(number - 2);

            dp[number][0] = dp[number-1][0] + dp[number-2][0];
            dp[number][1] = dp[number-1][1] + dp[number-2][1];

//            dp[number][0] = fibonacci(number - 1)[0] + fibonacci(number - 2)[0];
//            dp[number][1] = fibonacci(number - 1)[1] + fibonacci(number - 2)[1];
        }

        return dp[number];

    }

    private static void init() throws IOException {
        t = Integer.parseInt(br.readLine());
        dp = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            progress();
        }
    }

    public static class Count{
        int zero;
        int one;

        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }

}