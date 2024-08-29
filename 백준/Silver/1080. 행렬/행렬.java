import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, A[][], B[][], count;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        boolean flag = false;

        if(equalCheck()){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if(A[i][j] != B[i][j]){
                    reverse(i, j);
                    if(equalCheck()){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) break;
        }

        if(flag) System.out.println(count);
        else System.out.println(-1);





    }

    private static boolean equalCheck() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) return false;
            }
        }

        return true;
    }

    private static void reverse(int r, int c) {

        if(r+3 > N || c+3 > M)    return;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if(A[i][j] == 1) A[i][j] = 0;
                else A[i][j] = 1;
            }
        }
        count++;

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                A[i][j] = inputs[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                B[i][j] = inputs[j] - '0';
            }
        }

    }

}