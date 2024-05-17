import java.util.*;
import java.io.*;

public class Main {
    static int N, numbers[],maxLength=1;
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }


    private static void process() {


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {

                if(numbers[j] < numbers[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
                if(dp[i] > maxLength){
                    maxLength = dp[i];
                }
            }
        }


        System.out.println(maxLength);
    }


    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N];
        numbers = new int[N];

        int index = 0;
        st= new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            numbers[index++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

//        dp[i] = 수열의 i번째 요소로 끝나는 가장 긴 증가하는 부분 수열의 길이

    }
}