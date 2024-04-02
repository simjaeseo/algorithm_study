import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dp;
    static LinkedList<int[]> meetings = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        process();

    }

    private static void process() {


        for (int i = 0; i < N; i++) {

            int[] meeting = meetings.get(i);

            int t = meeting[0];
            int p = meeting[1];

            if(i + t <= N){
                dp[i + t] = Math.max(dp[i] + p, dp[i + t]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);

        }


        System.out.println(dp[N]);


    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            meetings.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
    }
}