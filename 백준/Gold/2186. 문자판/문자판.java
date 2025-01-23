import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, K, answer, dp[][][];
    static char[][] map;
    static String targetWord;
    static List<int[]> startPosition = new ArrayList<>();
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

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
                if(map[i][j] == targetWord.charAt(0)) answer += dfs(i, j, 0);
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int r, int c, int index) {
        if(dp[r][c][index] != -1 ) return dp[r][c][index];

        if(index == targetWord.length() - 1)    {
            dp[r][c][index] = 1;
            return dp[r][c][index];
        }

        dp[r][c][index] = 0; // 뒤에 올 경로의 경우가 0이더라도 초기화를 -1로 했기 때문에 0을 넣어줘야 한다.

        for (int i = 0; i < 4; i++) {

            for (int j = 1; j <= K; j++) {
                int nextR = r + dr[i] * j;
                int nextC = c + dc[i] * j;

                if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;
                if(map[nextR][nextC] != targetWord.charAt(index + 1)) continue;

                dp[r][c][index] += dfs(nextR, nextC, index+1);
            }
        }

        return dp[r][c][index];
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        targetWord = br.readLine();

        dp = new int[N][M][targetWord.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}
