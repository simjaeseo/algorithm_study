import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, originButtons[], buttons[], answer;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 0; i < N; i++) {

            if(originButtons[i] != buttons[i]) {

                for (int j = i; j <= i+2; j++) {
                    if(j >= N) continue;

                    buttons[j] = (buttons[j] + 1) % 2;
                }
                answer++;
            }
        }

        System.out.println(answer);
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        originButtons = new int[N];
        buttons = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            originButtons[i] = Integer.parseInt(st.nextToken());
        }

    }
}