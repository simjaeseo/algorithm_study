import java.util.*;
import java.io.*;

public class Main {
    static int N, triangle[][], maxNumber= 0;
    static int dp[][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        if( N == 1){
            System.out.println(triangle[0][0]);
            return;
        }
        dp();

    }

    private static void dp() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {


                if(i != N - 1){
                    dp[i+1][j] = Math.max(dp[i][j] + triangle[i+1][j], dp[i+1][j]);
                    dp[i+1][j+1] = Math.max(dp[i][j] + triangle[i+1][j+1], dp[i+1][j+1]);
                }else{
                    maxNumber = Math.max(dp[i][j], maxNumber);
                }
            }
        }

        System.out.println(maxNumber);


    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        dp = new int[N][N];

        int index = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            index = 0;
            while(st.hasMoreTokens()){
                triangle[i][index++] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1){
            return;
        }

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

}