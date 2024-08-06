import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, minCount = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        /* dp[i] i를 최소 개수의 제곱 합으로 표현하는 컴퓨터 프로그램
           dp[1] = 1
           dp[2] =

           일단 dp는 아닌거같음. 이전에 메모리한 값들이 의미가 없음
           그럼 그리디인데, 아 아니면 백트래킹? 재귀 완탐?
       */

        int Nsqrt = (int) Math.sqrt(N);
        for (int i = Nsqrt; i >= 1; i--) {
            recursion(N - (int) Math.pow(i, 2), 1);
        }

        System.out.println(minCount);


    }

    private static void recursion(int number, int count) {
        if(count >= minCount) return;
        if(number == 0){
            minCount = Math.min(minCount, count);
            return;
        }
        int numberSqrt = (int) Math.sqrt(number);
        for (int i = numberSqrt; i >= 1; i--) {
            recursion(number - (int) Math.pow(i, 2), count+1);
        }
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

}