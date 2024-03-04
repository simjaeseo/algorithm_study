import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, t, z , o;
    static int sequence[];
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        progress();
    }

    private static void progress() {

        for (int i = 0; i < n; i++) {
            recursion(i);
        }


        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }

    private static int recursion(int number) {

        if(dp[number] == null){
            dp[number] = 1;

            for (int i = number - 1; i >= 0; i--) {
                if(sequence[i] < sequence[number]){
                    dp[number] = Math.max(dp[number], recursion(i) + 1);
                }
            }
        }

        return dp[number];
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        sequence = new int[n];
        dp = new Integer[n];

        st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()){
            sequence[i++] = Integer.parseInt(st.nextToken());
        }
    }

}