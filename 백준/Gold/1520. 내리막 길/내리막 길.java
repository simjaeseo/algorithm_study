import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, map[][], answer, dp[][];
    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        if(N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,0));
    }

    private static int dfs(int r, int c) {
        if(r == N-1 && c == M-1) {
            return 1;
        }

        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;
            if(map[nextR][nextC] >= map[r][c])  continue;

            dp[r][c] += dfs(nextR, nextC);
        }

        return dp[r][c];
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
