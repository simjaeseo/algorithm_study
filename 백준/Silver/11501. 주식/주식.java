import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int T, N;
    static long price[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        long maxPrice = 0;
        long maxProfit = 0;

        for (int i = N-1; i >= 0; i--) {

            if(price[i] > maxPrice){
                maxPrice = price[i];
            }else{
                maxProfit += maxPrice - price[i];
            }

        }
        sb.append(maxProfit).append('\n');
    }


    private static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            price = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            solve();
        }
        System.out.print(sb);
    }

}