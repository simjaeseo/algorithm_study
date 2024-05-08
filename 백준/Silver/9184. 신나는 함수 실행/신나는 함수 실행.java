import java.util.*;
import java.io.*;

public class Main {
    static int A,B,C;
    static int dp[][][];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
//        process();
    }

    private static void process() {


    }

    private static int w(int a, int b, int c) {

        if(inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if(a <= 0 || b<= 0 || c<= 0)    return 1;

        if(a> 20 || b>20 || c>20)   return dp[20][20][20] = w(20,20,20);

        if(a<b && b<c)  return dp[a][b][c] =  w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);

        return dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);

    }
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
//    private static int fiboDP(int n) {
//    }


    private static void init() throws IOException {
        dp = new int[21][21][21];

        while(true){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(A == -1 && B == -1 && C == -1)   break;


            System.out.println("w(" + A+", " + B+", " + C +") = " + w(A,B,C));
        }
    }

}