import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, a[][], b[][], operations;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        // 3x3 뒤집기를 수행할 수 있는 범위 내에서 탐색
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                // A와 B의 현재 위치가 다를 때 뒤집기 수행
                if (a[i][j] != b[i][j]) {
                    flip(a, i, j);
                    operations++;
                }
            }
        }

        // A와 B가 같은지 확인
        boolean isEqual = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }

        // 결과 출력
        if (isEqual) {
            System.out.println(operations);
        } else {
            System.out.println(-1);
        }
    }

    // 3x3 부분 행렬 뒤집기
    public static void flip(int[][] matrix, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matrix[i][j] = 1 - matrix[i][j];  // 0을 1로, 1을 0으로 뒤집기
            }
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                a[i][j] = inputs[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                b[i][j] = inputs[j] - '0';
            }
        }

    }

}