import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, arr[], max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        int left = 0;
        int right = max - min;
        int result = 0;

        while(left <= right){
            int mid = (right + left) / 2;

            if(canDivideInterval(mid)){
                result = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDivideInterval(int mid) {
        int maxInInterval = arr[0];
        int minInInterval = arr[0];
        int countInterval = 1;

        for (int i = 1; i < N; i++) {
            maxInInterval = Math.max(maxInInterval, arr[i]);
            minInInterval = Math.min(minInInterval, arr[i]);

            if(maxInInterval - minInInterval > mid){
                maxInInterval = arr[i];
                minInInterval = arr[i];
                countInterval++;
            }
        }


        return countInterval <= M;

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
    }

}