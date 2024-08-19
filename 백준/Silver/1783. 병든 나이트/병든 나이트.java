import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int R, C, r, c;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {


        int result = 0;

        if (R == 1) {
            result = 1;  // 세로 길이가 1일 경우
        } else if (R == 2) {
            result = Math.min(4, (C + 1) / 2);  // 세로 길이가 2일 경우
        } else {
            if (C < 7) {
                result = Math.min(4, C);  // 세로 길이가 3 이상이고 가로 길이가 7보다 작을 경우
            } else {
                result = C - 2;  // 세로 길이가 3 이상이고 가로 길이가 7 이상일 경우
            }
        }

        System.out.println(result);

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        r = 1;
        c = 1;
    }

}