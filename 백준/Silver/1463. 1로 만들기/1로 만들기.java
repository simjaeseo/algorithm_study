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

        System.out.println(recursion(n,0));
    }

    private static int recursion(int number, int count) {
        if(number < 2){
            return count;
        }

        return Math.min(recursion(number / 3, count+1+(number%3)), recursion(number/2, count + 1+(number%2)));
    }


    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

}