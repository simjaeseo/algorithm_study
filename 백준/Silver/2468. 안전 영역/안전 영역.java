import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, map[][], max;
    static boolean isVisited[][];
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        int maxSafetyZone = 1;

        for (int i = 1; i < max; i++) {
            isVisited = new boolean[N][N];
            int count = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] > i && !isVisited[j][k]) {
                        bfs(j,k, i);
                        count++;
                    }
                }
            }

            maxSafetyZone = Math.max(maxSafetyZone, count);
        }
        System.out.println(maxSafetyZone);

    }

    private static void bfs(int r, int c, int rainHeight) {

        Queue<int[]> q = new LinkedList<>();
        isVisited[r][c] = true;
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = position[0] + dr[i];
                int nextC = position[1] + dc[i];

                if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || isVisited[nextR][nextC]) continue;
                if(map[nextR][nextC] <= rainHeight) continue;

                isVisited[nextR][nextC] = true;
                q.add(new int[]{nextR, nextC});
            }
        }
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }
    }

}