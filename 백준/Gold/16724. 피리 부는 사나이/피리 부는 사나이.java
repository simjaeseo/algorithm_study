import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static char map[][];
    static int isVisited[][];
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int minimumSafeZone = 0;
    static int index = 1;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        isVisited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isVisited[i][j] == 0){
                    dfs(i, j);
                }
            }
        }

        System.out.println(minimumSafeZone);
    }

    private static void dfs(int r, int c) {
        isVisited[r][c] = index;

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

        // 문제 특성상 무조건 사이클이 있을 수 밖에 없으니 필요가 없는거였다..!
        // if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) return;

        // 미방문 상태라면?
        if(isVisited[nextR][nextC] == 0){
            dfs(nextR, nextC);
        }else{
            if(isVisited[nextR][nextC] == index) minimumSafeZone++;
            index++;
        }

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

    }
}
