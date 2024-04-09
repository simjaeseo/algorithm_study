import java.util.*;
import java.io.*;

public class Main {
    static int N, M, result;
    static int[][] map;
    static int[][][] isVisited;

    static int[] dr = new int[]{0,0,1,-1};
    static int[] dc = new int[]{1,-1,0,0};
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Position> q = new LinkedList<>();
        isVisited[0][0][0] = 1;
        q.add(new Position(0,0,0));

        while(!q.isEmpty()){
            Position position = q.poll();

            if(position.r == N-1 && position.c == M-1) return isVisited[position.r][position.c][position.breakingFlag];

            for (int i = 0; i < 4; i++) {
                int mr = position.r + dr[i];
                int mc = position.c + dc[i];
                int nextBreakingFlag = position.breakingFlag;

                if(mr < 0 || mc < 0 || mr>= N || mc >= M)   continue;
                if(isVisited[mr][mc][position.breakingFlag] > 0) continue;

                if(map[mr][mc] == 0){
                    isVisited[mr][mc][nextBreakingFlag] = isVisited[position.r][position.c][position.breakingFlag] + 1;
                    q.add(new Position(mr,mc, position.breakingFlag));
                }
                if(map[mr][mc] == 1 && nextBreakingFlag == 0){
                    isVisited[mr][mc][1] = isVisited[position.r][position.c][position.breakingFlag] + 1;
                    nextBreakingFlag = 1;
                    q.add(new Position(mr,mc, nextBreakingFlag));
                }
            }
        }

        return -1;

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = inputs[j] - '0';
            }
        }
    }

    static class Position{
        int r;
        int c;
        int breakingFlag;

        Position(int r, int c, int breakingFlag){
            this.r = r;
            this.c = c;
            this.breakingFlag = breakingFlag;
        }
    }
}