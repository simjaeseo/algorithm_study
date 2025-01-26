import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M, dp[][], answer;
    static char map[][];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(dp[i][j] == -1) dfs(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(dp[i][j] > 0) answer += dp[i][j];
            }
        }

        System.out.println(answer);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

    }

    private static int dfs(int r, int c) {
        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;

        int nextR = r;
        int nextC = c;

        if(map[r][c] == 'U'){
            nextR += dr[0];
            nextC += dc[0];
        }else if(map[r][c] == 'D'){
            nextR += dr[1];
            nextC += dc[1];
        }else if(map[r][c] == 'L'){
            nextR += dr[2];
            nextC += dc[2];
        }else if(map[r][c] == 'R'){
            nextR += dr[3];
            nextC += dc[3];
        }

        if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M ) {
            dp[r][c] = 1;
            return dp[r][c];
        }

        dp[r][c] = dfs(nextR, nextC);
        return dp[r][c];
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}