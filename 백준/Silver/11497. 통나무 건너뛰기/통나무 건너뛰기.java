import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int T, N, trees[], answer[];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

//        solve();
    }


    private static void solve() {

        Arrays.sort(trees);

        int left = 0;
        int right = N-1;

        for (int i = 0; i < N; i++) {
            if(i % 2 == 0){
                answer[left++] = trees[i];
            }else{
                answer[right--] = trees[i];
            }
        }

        int max = 0;
        for (int j = 0; j < N-1; j++) {
            max = Math.max(Math.abs(answer[j] - answer[j+1]), max);
        }

        max = Math.max(Math.abs(answer[0] - answer[N-1]), max);

        System.out.println(max);
    }


    private static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            answer = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                trees[j] = Integer.parseInt(st.nextToken());
            }

            solve();
        }

    }

}