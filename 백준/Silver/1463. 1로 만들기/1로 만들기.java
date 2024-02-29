import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        progress();
    }

    private static void progress() {
        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;

        System.out.println(recursion(n));
    }

    private static int recursion(int number) {

        // 아직 값이 안구해졌으면,
        if(dp[number] == null){
            if(number % 6 == 0){
                dp[number] = Math.min(recursion(number/3), Math.min(recursion(number/2), recursion(number-1))) + 1;
            }else if(number % 3 == 0){
                dp[number] = Math.min(recursion(number/3), recursion(number-1)) + 1;
            }else if(number % 2 == 0){
                dp[number] = Math.min(recursion(number/2), recursion(number-1)) + 1;
            }else{
                dp[number] = recursion(number-1) + 1;
            }
        }

        return dp[number];
    }


    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

}