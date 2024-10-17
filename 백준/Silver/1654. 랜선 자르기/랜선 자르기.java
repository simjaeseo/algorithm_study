import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K, lans[], max;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        long left = 1;
        long right = max;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(canDivideLans(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    private static boolean canDivideLans(long distance) {
        long countLans = 0;


        for (int i = 0; i < N; i++) {

            if(distance > lans[i])  continue;

            countLans += lans[i] / distance;
        }

        return countLans >= K;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        lans = new int[N];

        for (int i = 0; i < N; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lans[i]);
        }
    }
}
