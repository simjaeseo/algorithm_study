import java.util.*;
import java.io.*;

public class Main {
    static int N, K, map[][];
    static Horse[] horses;
    static List<Horse> horseMap[][];
//    우좌상하
    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{1,-1,0,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(solve());
    }

    private static int solve() {


        for (int turn = 1; turn <= 1000; turn++) {
            for (int i = 0; i < K; i++) {
                Horse horse = horses[i];
                int r = horse.r;
                int c = horse.c;
                int direction = horse.direction;

                // 맨 밑에 있는 말이 아니라면,
                if(horseMap[r][c].indexOf(horse) != 0)  continue;

                int mr = r + dr[direction];
                int mc = c + dc[direction];

                if(mr<0 || mc < 0 || mr>=N || mc >= N || map[mr][mc] == 2){
                    direction = direction % 2 == 0 ? direction+1 : direction-1;

                    mr = r + dr[direction];
                    mc = c + dc[direction];
                    horse.direction = direction;

                    if(mr<0 || mc < 0 || mr>=N || mc >= N || map[mr][mc] == 2) {
                        continue;
                    }
                }

                List<Horse> horseList = new ArrayList<>();

                for (int j = 0; j < horseMap[r][c].size(); j++) {
                    horseList.add(horseMap[r][c].get(j));
                }
                horseMap[r][c].clear();

                if(map[mr][mc] == 1){
                    Collections.reverse(horseList);
                }

                for(Horse horse1 : horseList){
                    horse1.r = mr;
                    horse1.c = mc;

                    horseMap[mr][mc].add(horse1);
                }

                if(horseMap[mr][mc].size() >= 4)    return turn;
            }
        }

        return -1;


    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        horseMap = new LinkedList[N][N];
        horses = new Horse[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                horseMap[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken()) - 1;

            Horse horse = new Horse(r,c,direction);

            horses[i] = horse;
            horseMap[r][c].add(horse);
        }
    }

    static class Horse{
        int r,c,direction;

        Horse(int r, int c, int direction){
            this.r = r ;
            this.c = c;
            this.direction = direction;
        }
    }

}