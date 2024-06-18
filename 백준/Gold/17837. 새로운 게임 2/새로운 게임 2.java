import java.util.*;
import java.io.*;

public class Main {
    static int N, K, map[][];
    static ArrayList<Horse> horses = new ArrayList<>();
    static List<Integer> horseMap[][];
    //우좌상하
    static int[] dr = new int[]{0, 0, -1, 1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        int turn = solve();
        System.out.println(turn);
    }

    private static int solve() {

        for (int turn = 1; turn <= 1000; turn++) {
            for (int i = 0; i < K; i++) {
                if(move(i)) return turn;
            }
        }

        return -1;
    }

    private static boolean move(int horseIndex) {

        Horse horse = horses.get(horseIndex);
        int r = horse.r;
        int c = horse.c;
        int direction = horse.direction;

        int mr = r + dr[direction];
        int mc = c + dc[direction];
        
        //이동하려는 곳이 맵밖 or 파랑
        if(mr < 0 || mc < 0 || mr>= N || mc >= N || map[mr][mc] == 2){
            direction = direction % 2 != 0 ? direction - 1 : direction + 1;
            
            horse.direction = direction;
            mr = horse.r + dr[direction];
            mc = horse.c + dc[direction];

            if(mr < 0 || mc < 0 || mr>= N || mc >= N || map[mr][mc] == 2) {
                return false;
            }
        }
        
        // 말 꺼내기
        List<Integer> horseList = new LinkedList<>();
        int horseStartIndex = horseMap[r][c].indexOf(horseIndex);

        for (int i = horseStartIndex; i < horseMap[r][c].size(); i++) {
            horseList.add(horseMap[r][c].get(i));
        }
        horseMap[r][c].subList(horseStartIndex, horseMap[r][c].size()).clear();

        if(map[mr][mc] == 1){
            Collections.reverse(horseList);
        }

        for (int i : horseList) {
            horseMap[mr][mc].add(i);

            horses.get(i).r = mr;
            horses.get(i).c = mc;
        }

        if(horseMap[mr][mc].size() >= 4)    return true;

        return false;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        horseMap = new LinkedList[N][N];

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

            horses.add(horse);
            horseMap[r][c].add(i);
        }
    }

    static class Horse {
        int r;
        int c;
        int direction;

        Horse(int r, int c, int direction) {
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
}