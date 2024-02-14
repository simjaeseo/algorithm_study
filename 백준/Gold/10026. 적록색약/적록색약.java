import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, normal, notNormal;
    static char map[][];
    static boolean isVisited[][];
    static int dr[] = new int[]{0, 0, -1, 1};
    static int dc[] = new int[]{1, -1, 0, 0};
//    static ArrayList<Integer> l = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        progress();
        print();
    }

    private static void print() {
        System.out.println(normal +" " + notNormal);
    }


    private static void progress() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isVisited[i][j]){
                    bfs(i, j, map[i][j]);
                    normal++;
                }
            }
        }

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isVisited[i][j]){
                    bfs(i, j, map[i][j]);
                    notNormal++;
                }
            }
        }
    }

    private static void bfs(int r, int c, char color) {
        Queue<int[]> q = new LinkedList<>();

        isVisited[r][c] = true;
        if(map[r][c] == 'R')    map[r][c] = 'G';
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int mr = position[0] + dr[i];
                int mc = position[1] + dc[i];

                if (mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc] || map[mr][mc] != color) continue;

                if(map[mr][mc] == 'R')    map[mr][mc] = 'G';
                isVisited[mr][mc] = true;
                q.add(new int[]{mr, mc});
            }
        }


    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = inputs[j];
            }
        }
    }


}