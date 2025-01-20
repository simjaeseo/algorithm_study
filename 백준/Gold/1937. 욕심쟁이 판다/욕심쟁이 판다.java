import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n,map[][], max, dp[][];
    static boolean[][] isVisisted;
    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{-1,1,0,0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i,j));
            }
        }

        System.out.println(max);


    }

    private static int dfs(int r, int c) {

        // 이미 계산된 적이 있으면 바로 반환 (여기서 출발할 때 나오는 경우의 수를 다 체크해봤다는 뜻임)
        if(dp[r][c] != 0) return dp[r][c];

        // 처음 방문 시 자기 자신만 포함하므로 경로 길이 1
        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
            if(map[r][c] >= map[nextR][nextC]) continue;

            // dfs(nr, nc)를 통해 구한 경로 길이 + 1과 비교하여 갱신
            dp[r][c] =  Math.max(dp[r][c], dfs(nextR, nextC) + 1);
        }

        return dp[r][c];
    }


    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}

