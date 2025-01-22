import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, map[][];
    static boolean[][] visited;
    static int dr[] = {1,0};
    static int dc[] = {0,1};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        System.out.println(bfs(0,0));

    }

    private static String bfs(int r, int c) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            if(current[0] == N-1 && current[1] == N-1) return "HaruHaru";

            int count = map[current[0]][current[1]];

            for (int i = 0; i < 2; i++) {
                int nextR = current[0] + dr[i] * count;
                int nextC = current[1] + dc[i] * count;

                if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
                if(visited[nextR][nextC]) continue;

                if(map[nextR][nextC] > Math.abs(N-1 - nextR) + Math.abs(N-1 - nextC)) continue;

                q.add(new int[]{nextR,nextC});
                visited[nextR][nextC] = true;
            }

        }
        return "Hing";
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
