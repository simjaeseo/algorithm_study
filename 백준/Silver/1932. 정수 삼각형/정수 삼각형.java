import java.util.*;
import java.io.*;

public class Main {
    static int N, triangle[][], maxNumber= 0;
    static Integer dp[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        System.out.println(dp(0,0));
    }

    private static int dp(int r, int c) {
        if(r == N-1)    return dp[r][c];

        if(dp[r][c] == null){
            dp[r][c] = Math.max(dp(r+1, c), dp(r+1, c+1)) + triangle[r][c];
        }
        return dp[r][c];
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        dp = new Integer[N][N];

        int index = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            index = 0;
            while(st.hasMoreTokens()){
                triangle[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N-1][i] = triangle[N-1][i];
        }


//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

}