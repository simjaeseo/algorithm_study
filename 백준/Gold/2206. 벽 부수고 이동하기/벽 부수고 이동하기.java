import java.util.*;
import java.io.*;

//if else 테스트
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

        System.out.println(bfs2());
    }

    private static int bfs() {
        Queue<Position> q = new LinkedList<>();
        isVisited[0][0][0] = 1;
        q.add(new Position(0,0,0));

        while(!q.isEmpty()){
            Position position = q.poll();

            if(position.r == N-1 && position.c == M-1) return isVisited[position.breakingFlag][position.r][position.c];

            for (int i = 0; i < 4; i++) {
                int mr = position.r + dr[i];
                int mc = position.c + dc[i];
                int nextBreakingFlag = position.breakingFlag;

                if(mr < 0 || mc < 0 || mr>= N || mc >= M)   continue;
                if(isVisited[position.breakingFlag][mr][mc] > 0) continue;

                if(map[mr][mc] == 0){
                    isVisited[nextBreakingFlag][mr][mc] = isVisited[position.breakingFlag][position.r][position.c] + 1;
                    q.add(new Position(mr,mc, position.breakingFlag));
                }
                if(map[mr][mc] == 1 && nextBreakingFlag == 0){
                    isVisited[1][mr][mc] = isVisited[position.breakingFlag][position.r][position.c] + 1;
                    nextBreakingFlag = 1;
                    q.add(new Position(mr,mc, nextBreakingFlag));
                }
            }
        }

        return -1;

    }


    private static int bfs2(){
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,0));
        isVisited[0][0][0] = 1;

        while(!q.isEmpty()){
            Position position = q.poll();

            if(position.r == N-1 && position.c == M-1)  return isVisited[position.breakingFlag][position.r][position.c];

            for (int i = 0; i < 4; i++) {
                int mr = position.r + dr[i];
                int mc = position.c + dc[i];
                int nextBreakingFlag = position.breakingFlag;

                if(mr<0||mc<0||mr>=N||mc>=M)    continue;
                if(isVisited[position.breakingFlag][mr][mc] > 0)    continue;

                if(map[mr][mc] == 0){
                    isVisited[nextBreakingFlag][mr][mc] = isVisited[position.breakingFlag][position.r][position.c] + 1;
                    q.add(new Position(mr,mc,nextBreakingFlag));
                }else if(map[mr][mc] == 1 && position.breakingFlag == 0){
                    nextBreakingFlag = 1;
                    isVisited[nextBreakingFlag][mr][mc] = isVisited[position.breakingFlag][position.r][position.c] + 1;
                    q.add(new Position(mr,mc,nextBreakingFlag));
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
        isVisited = new int[2][N][M];

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