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

        /*

        int[]의 각각의 차가 가장 작은 경우를 찾아야 한다.

        2 4 5 7 9

        2 9 7 4 5

        2 5 9 7 4

        13 10 12 11 10 11 12

        10 10 11 11 12 12 13

        10 11 12 13 12 11 10

        1 5 9 29 15 2

        1 2 5 9 15 29

        1 5 15 29 9 2

        4 10 14 20 7 1



         */

        Arrays.sort(trees);
        int index = 0;

        for (int i = 0; i < N; i+=2) {
            answer[index++] = trees[i];
        }

        int i = N - 1;
        if((N-1)%2 == 0) i--;

        for (; i >= 0; i-=2) {
            answer[index++] = trees[i];
        }

        int max = 0;

        for (int j = 0; j < N-1; j++) {
            max = Math.max(Math.abs(answer[j] - answer[j+1]), max);
        }

        max = Math.max(Math.abs(answer[0] - answer[N-1]), max);


//        System.out.println(Arrays.toString(trees));
//        System.out.println(Arrays.toString(answer));
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