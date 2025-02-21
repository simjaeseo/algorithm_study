import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char[] L, R;
    static int answer;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        if(!hadEight(L) || !hadEight(R) || L.length != R.length) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < L.length; i++) {
            if(L[i] == R[i]) {
                if (L[i] == '8') answer++;
            }else break;
        }

        System.out.println(answer);
    }

    private static boolean hadEight(char[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == '8') return true;
        }


        return false;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        L = st.nextToken().toCharArray();
        R = st.nextToken().toCharArray();
    }
}