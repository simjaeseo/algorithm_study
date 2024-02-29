import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, t, z , o;
    static Count dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void progress() {


        Count fibonacci = fibonacci(n);

        System.out.println(fibonacci.zero + " " + fibonacci.one);
    }

    private static Count fibonacci(int number) {
        if(number == 0){
//            o += dp[0].one;
//            z += dp[0].zero;
            return dp[0];
        }else if(number == 1){
//            o += dp[1].one;
//            z += dp[1].zero;
            return dp[1];
        }else if(number == 2){
            return dp[2];
        }

        if(dp[number] == null){
            Count fibo1 = fibonacci(number - 1);
            Count fibo2 = fibonacci(number - 2);

            dp[number] = new Count(fibo1.zero + fibo2.zero, fibo1.one+ fibo2.one);
        }

        return dp[number];

    }

    private static void init() throws IOException {
        t = Integer.parseInt(br.readLine());
        dp = new Count[41];
        dp[0] = new Count(1,0);
        dp[1] = new Count(0,1);
        dp[2] = new Count(1,1);

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