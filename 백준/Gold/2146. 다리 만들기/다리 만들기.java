import java.util.*;
import java.io.*;

public class Main {
    static int N, map[][], minDistance = Integer.MAX_VALUE;
    static boolean isVisited[][];
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();

        System.out.println(minDistance);
    }

    private static void process() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0){
                    bfs(i,j, map[i][j]);
                }
            }
        }

    }

    private static void bfs(int r, int c, int islandNumber) {
        Deque<int[]> q = new ArrayDeque<>();

        isVisited = new boolean[N][N];

        isVisited[r][c] = true;
        q.add(new int[]{r,c,0});

        while (!q.isEmpty()) {
            int[] position = q.poll();
            if(position[2] >= minDistance) continue;

            for (int i = 0; i < 4; i++) {
                int mr = position[0] + dr[i];
                int mc = position[1] + dc[i];
                int mDistance = position[2] + 1;

                if (mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc]) continue;

                if(map[mr][mc] == 0){
                    q.add(new int[]{mr, mc, mDistance});
                    isVisited[mr][mc] = true;
                }else if(map[mr][mc] != islandNumber){
                    minDistance = Math.min(minDistance, mDistance - 1);
                }
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
            }
        }

        int labelNumber = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    islandLabelingBFS(i,j, labelNumber);
                    labelNumber++;
                }
            }
        }
    }

    private static void islandLabelingBFS(int r, int c, int labelNumber) {
        Deque<int[]> q = new ArrayDeque<>();

        isVisited = new boolean[N][N];
        isVisited[r][c] = true;
        map[r][c] = labelNumber;

        q.add(new int[]{r,c});

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int mr = position[0] + dr[i];
                int mc = position[1] + dc[i];

                if (mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc] || map[mr][mc] == 0) continue;

                map[mr][mc] = labelNumber;
                q.add(new int[]{mr, mc});
                isVisited[mr][mc] = true;
            }
        }
    }
}