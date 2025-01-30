import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static long number[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        Arrays.sort(number);
        long max = 0;

        if(number.length % 2 == 0){
            // 짝수이면

            int left = 0;
            int right = number.length - 1;
            max = 0;
            for (int i = 0; i < number.length / 2; i++) {
                max = Math.max(max, number[left++] + number[right--]);
            }

        }else{
            // 홀수이면
            int left = 0;
            int right = number.length - 2;
            max = 0;

            for (int i = 0; i < number.length / 2; i++) {
                max = Math.max(max, number[left++] + number[right--]);
            }
            max = Math.max(max, number[number.length - 1]);
        }

        System.out.println(max);

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        number = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            number[i] = Long.parseLong(st.nextToken());
        }
    }
}