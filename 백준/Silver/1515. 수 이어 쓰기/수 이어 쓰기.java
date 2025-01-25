import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int index, N;
    static String S;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }

    private static void solve() {
        while (index < S.length()) {
            N++;
            String current = String.valueOf(N);

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == S.charAt(index)) {
                    index++;
                    if (index == S.length()) {
                        break;
                    }
                }
            }
        }

        System.out.println(N);
    }

    private static void init() throws IOException {
        S = br.readLine();
        index = 0;          
        N = 0;
    }
}