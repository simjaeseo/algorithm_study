import java.util.*;
import java.io.*;

public class Main {
    static int N, maxSecond;
    static int[][] map;
    static boolean[][] isVisited;
    static Shark shark;
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();

        System.out.println(maxSecond);
    }

    private static void process() {
        bfsAndEatFish();
    }

    private static void bfsAndEatFish() {

        Queue<int[]> q = new LinkedList<>();
        isVisited = new boolean[N][N];

        q.add(new int[]{shark.r, shark.c});
        isVisited[shark.r][shark.c] = true;

        PriorityQueue<Fish> pq = new PriorityQueue<>();
        int distance = 0;

        while(!q.isEmpty()){
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int[] sharkPosition = q.poll();

                for (int j = 0; j < 4; j++) {
                    int mr = sharkPosition[0] + dr[j];
                    int mc = sharkPosition[1] + dc[j];

                    if(mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc]) continue;

                    if(map[mr][mc] != 0 && map[mr][mc] < shark.size){
                        pq.add(new Fish(mr,mc,map[mr][mc]));
                    }
                    if(map[mr][mc] <= shark.size){
                        q.add(new int[]{mr,mc});
                        isVisited[mr][mc] = true;
                    }
                }
            }

            distance++;

            if(!pq.isEmpty()){
                Fish fish = pq.poll();
                shark.countEattingFish++;
                map[fish.r][fish.c] = 0; //물고기 먹었으니 그 자리는 0으로 만들기

                if(shark.countEattingFish == shark.size){
                    shark.size++;
                    shark.countEattingFish = 0;
                }

                maxSecond += distance; // 물고기 위치까지 간 시간 더해주기
                distance = 0;
                pq.clear();
                q.clear();
                isVisited = new boolean[N][N];
                q.add(new int []{fish.r, fish.c});
                isVisited[fish.r][fish.c] = true;
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

                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static class Fish implements Comparable<Fish> {
        int r;
        int c;
        int size;

        public Fish(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }


        @Override
        public int compareTo(Fish o) {
            int res = 0;

            if (this.r == o.r) {
                res = this.c - o.c;
            } else {
                res = this.r - o.r;
            }
            return res;
        }

    }

    public static class Shark {
        int r;
        int c;
        int size;
        int countEattingFish;

        public Shark(int r, int c, int size, int countEattingFish) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.countEattingFish = countEattingFish;
        }
    }

}