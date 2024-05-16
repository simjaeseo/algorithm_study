import java.util.*;
import java.io.*;

public class Main {
    static int N, wine[];
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }


    private static void process() {

        dp[0] = 0;
        dp[1] = wine[1];
        
        if(N>=2){
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+ wine[i]), dp[i-3] + wine[i-1] + wine[i]);
        }

        System.out.println(dp[N]);

    }


    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

        // dp[n] = n번째까지 먹을 수 있는 최대 와인의 양
        // dp는 하위 문제들의 결과를 어떻게 결합하여 상위 문제의 결과를 만들 수 있을지 생각
        // n == 3 : 1,5,3
        // n == 4 : 1,5,3,7
        // n == 5 : 1,5,3,7,2
        dp = new Integer[N + 1];
        wine = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
    }
}