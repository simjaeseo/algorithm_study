import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, L, leakPoint[];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        int remainingTape = L-1;
        int countNeededTape = 0;

        for (int i = 0; i < N-1; i++) {
            if(leakPoint[i+1] - leakPoint[i] > remainingTape){
                countNeededTape++;
                remainingTape = L-1;
                continue;
            }

            remainingTape -= leakPoint[i+1] - leakPoint[i];
//            leakPoint[i+1] = -1;
        }

        countNeededTape++;

        System.out.println(countNeededTape);

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        leakPoint = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            leakPoint[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leakPoint);

    }

}