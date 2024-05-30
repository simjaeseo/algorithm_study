import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M, map[][], max;
    static boolean isVisited[][];
    static int dr[] = new int[]{-1,1,0,0};
    static int dc[] = new int[]{0,0,-1,1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(i,j, 1,map[i][j]);
                isVisited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void dfs(int r, int c, int count, int sum) {

        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int mr = r + dr[i];
            int mc = c + dc[i];

            if(mr >= N || mc >= M || mr<0 || mc<0 || isVisited[mr][mc]) continue;

            if(count==2){
                isVisited[mr][mc] = true;
                dfs(r,c, count+1,sum + map[mr][mc]);
                isVisited[mr][mc] = false;
            }

            isVisited[mr][mc] = true;
            dfs(mr,mc, count+1,sum + map[mr][mc]);
            isVisited[mr][mc] = false;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        int index = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                map[i][index++] = Integer.parseInt(st.nextToken());
            }
            index = 0;
        }
    }
}