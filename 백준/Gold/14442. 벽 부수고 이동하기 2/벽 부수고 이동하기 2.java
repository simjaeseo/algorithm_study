import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, map[][], visitedMap[][][];
    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{-1,1,0,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();

    }

    private static void solve(){
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0,0,0,1});
        visitedMap[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] current = q.poll();

            if(current[0] == N-1 && current[1] == M - 1){
                return current[3];
            }

            for (int i = 0; i < 4; i++) {
                int mr = current[0] + dr[i];
                int mc = current[1] + dc[i];
                int currentK = current[2];
                int nextDistance = current[3] + 1;

                if(mr < 0 || mc < 0 || mr>= N || mc >= M || visitedMap[currentK][mr][mc] != 0)   continue;

                if(map[mr][mc] == 0){
                    visitedMap[currentK][mr][mc] = nextDistance;
                    q.add(new int[]{mr,mc,currentK, nextDistance});
                }
                if(map[mr][mc] == 1 && currentK < K){
                    visitedMap[currentK+1][mr][mc] = nextDistance;
                    q.add(new int[]{mr,mc,currentK+1, nextDistance});
                }
            }
        }
        return -1;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visitedMap = new int[K+1][N][M];

        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = inputs[j] - '0';
            }
        }
    }
}