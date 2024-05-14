import java.util.*;
import java.io.*;

public class Main {
    static int N, houses[][];
    static Integer dp[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + houses[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + houses[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + houses[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N-1][0],dp[N-1][1]), dp[N-1][2]));

    }


    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        houses = new int[N][3];
        dp = new Integer[N][3];

        int index = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                houses[i][index++] = Integer.parseInt(st.nextToken());
            }
            index = 0;
        }

        dp[0][0] = houses[0][0];
        dp[0][1] = houses[0][1];
        dp[0][2] = houses[0][2];


    }
}