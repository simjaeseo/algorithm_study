import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int sequence[];
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

//        progress();
        progress1();
    }

    private static void progress1() {

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + sequence[i-1]) + sequence[i];
        }

        System.out.println(dp[n]);

    }

    private static void progress() {

        System.out.println(recursion(n));
    }

    private static int recursion(int number) {

        if(dp[number] == null){
            dp[number] = Math.max(recursion(number-2), recursion(number-3) + sequence[number - 1]) + sequence[number];
        }

        return dp[number];
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        sequence = new int[n+1];
        dp = new Integer[n+1];

        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = sequence[1];

        if(n>=2){
            dp[2] = sequence[1] + sequence[2];
        }
    }

}