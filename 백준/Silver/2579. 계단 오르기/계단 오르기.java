import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, stairs[];
    static Integer dp[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        dp = new Integer[N+1];

        dp[0] = 0;
        if(N >= 1) dp[1] = stairs[1];
        if(N >=2) dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }

        System.out.println(dp[N]);


        /*
        1. 문제 이해

        2. 요구 사항 분해

        3. 핵심 로직 설계

            "다른 관점에서 이 문제를 바라볼 수 있을까?"

        4. 조건 및 예외 처리 고려

        5. 코드 구조 잡기

        6. 구현 시작


         */


    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }
}
