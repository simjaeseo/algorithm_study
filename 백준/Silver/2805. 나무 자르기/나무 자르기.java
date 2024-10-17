import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, trees[], max;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        int left = 0;
        int right = max;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(getTotalTreesLength(mid) >= M){
                answer = Math.max(answer,mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static long getTotalTreesLength(int H) {

        long totalTreesLength = 0;

        for (int i = 0; i < N; i++) {
            if(trees[i] - H > 0)    totalTreesLength += trees[i] - H;
        }

        return totalTreesLength;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
    }
}

