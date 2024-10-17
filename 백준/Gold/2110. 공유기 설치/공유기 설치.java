import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, C, machines[], min = Integer.MAX_VALUE;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        Arrays.sort(machines);

        for (int i = 1; i < N; i++) {
            min = Math.min(min, machines[i] - machines[i-1]);
        }

        int left = 1;
        int right = machines[N-1] - machines[0];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canDivideInterval(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }

    private static boolean canDivideInterval(int mid) {
        int minInInterval = machines[0];
        int maxInInterval = machines[0];
        int countInterval = 1;

        for (int i = 1; i < N; i++) {
            maxInInterval = Math.max(maxInInterval, machines[i]);


            if(maxInInterval - minInInterval >= mid){
                minInInterval = machines[i];
                maxInInterval = machines[i];
                countInterval++;
            }
        }

        return countInterval >= C;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        machines = new int[N];

        for (int i = 0; i < N; i++) {
            machines[i] = Integer.parseInt(br.readLine());
        }

    }
}
