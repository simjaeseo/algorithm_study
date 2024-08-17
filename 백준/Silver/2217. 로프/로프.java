import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
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
        int n = Integer.parseInt(br.readLine());

        Integer[] number = new Integer[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number, Comparator.reverseOrder());

        for (int k = 1; k <= n; k++) {
            if(number[k-1] * k > max)  max = number[k-1] * k;
        }
        System.out.println(max);

    }

}