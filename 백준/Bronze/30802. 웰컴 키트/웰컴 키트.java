import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, minTShirt, minPenPair, minPenOne, arr[];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 6; i++) {
            if(arr[i] % T == 0) minTShirt += arr[i] / T;
            else minTShirt += arr[i] / T + 1;
        }
        minPenPair = N / P;
        minPenOne = N % P;

        System.out.println(minTShirt);
        System.out.print(minPenPair + " " + minPenOne);
    }

}