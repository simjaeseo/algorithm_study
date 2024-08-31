import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int redCount, blackCount;
    static String balls;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        if (N <= 2) {
            System.out.println(0);
            return;
        }

        // 빨간색, 검은색 공 개수 구하기
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') redCount++;
            else blackCount++;
        }

        int left = 1;
        int right = 1;

        // 왼쪽 시작이 얼마나 연속적인지
        for (int i = 1; i < N; i++) {
            if (balls.charAt(0) == balls.charAt(i)) left++;
            else break;
        }

        // 오른쪽 시작이 얼마나 연속적인지
        for (int i = N - 2; i >= 0; i--) {
            if (balls.charAt(N - 1) == balls.charAt(i)) right++;
            else break;
        }

        int result = 0;

        // ex. RRBRBBRR
        if(balls.charAt(0) == balls.charAt(N-1)){

            if(balls.charAt(0) == 'R'){
                result = Math.min(Math.min(redCount - left, blackCount), redCount - right );
            }else{
                result = Math.min(Math.min(blackCount - left, redCount), blackCount - right );
            }

        }else{

            if(balls.charAt(0) == 'R'){
                result = Math.min(redCount- left , blackCount - right);
            }else{
                result = Math.min(blackCount - left, redCount - right);
            }
        }
        System.out.println(result);

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        balls = br.readLine();
    }

}