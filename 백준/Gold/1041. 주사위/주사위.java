import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static long N, dice[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        // 출처 :  https://velog.io/@somyeong0623/%EB%B0%B1%EC%A4%80java-1041.-%EC%A3%BC%EC%82%AC%EC%9C%84
        long one = Long.MAX_VALUE; // 한면의 합의 최솟값
        long two = Long.MAX_VALUE; // 이웃한 두 면의 합의 최솟값
        long three = 0; // 이웃한 세 면의 합의 최솟값

        long max = 0;
        long sum = 0;

        //one구하기: 주사위 6면중 가장 작은 값이 된다.
        for (int i = 0; i < 6; i++) {
            one = Math.min(one, dice[i]);
            max = Math.max(max, dice[i]);
            sum += dice[i];
        }

        /*
           3
         4 0 1 5
           2
           이웃한 두 면이 되려면, 마주보지만 않으면 된다.

           마주보는 경우?
           05 14 23
         */
        //two 구하기: 이웃한 두 면이 되기 위해서는 마주보는 두면을 고르는 경우만 제외하면 된다.
        //주사위 전개의 A~E를 0~5라고 보면, 두 면의 인덱스 합이 5인 경우가 마주보는 경우이다.
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(i != j && i + j != 5){
                    two = Math.min(two, dice[i] + dice[j]);
                }
            }
        }

        //three 구하기: 전개도를 보면 마주보는면은 3쌍이 있는데, 각각의 쌍 중에 작은값들을 더하면 이웃한 세 면의 합의 최솟값이 된다.
        //마주보는 두쌍의 인덱스 합은 5이므로 하나가 i인덱스 일때, 나머지 하나는 5-i번째 인덱스 이다.
        for (int i = 0; i < 3; i++) {
            three += Math.min(dice[i], dice[5 - i]);
        }

        long answer = 0;
        if( N == 1){
            answer = sum - max;
        }else{
            // 마지막 항은 (n-2)x(n-2)이므로 n의 자료형에 의존하고 있는데, int x int 계산을 한 값이 인트범위를 넘어가면 오버플로우가 나서 답이 들어오지 않게 된다.
            answer = three * 4 + two * (4 * (N - 1) + 4 * (N - 2)) + one * ((N - 2) * (N - 1) * 4 + (N - 2) * (N - 2));
        }

        System.out.println(answer);
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        dice = new long[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
    }

}