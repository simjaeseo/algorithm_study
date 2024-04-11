import java.util.*;
import java.io.*;

public class Main {
    static int N, map[][], resultSecond;
    static Shark shark;
    static boolean isVisited[][];
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();

        System.out.println(resultSecond);
    }

    private static void process() {
        bfs();
    }

    private static void bfs() {

        Queue<int[]> q = new ArrayDeque<>();
        isVisited = new boolean[N][N];
        int distance = 0;
        PriorityQueue<Fish> eatableFishPQ = new PriorityQueue<>();

        q.add(new int[]{shark.r, shark.c});
        isVisited[shark.r][shark.c] = true;

        while(!q.isEmpty()){
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int[] sharkPosition = q.poll();

                for (int j = 0; j < 4; j++) {
                    int mr = sharkPosition[0] + dr[j];
                    int mc = sharkPosition[1] + dc[j];

                    if(mr<0 || mc < 0 || mr>= N || mc>= N || isVisited[mr][mc]) continue;

                    if(map[mr][mc] != 0 && map[mr][mc] < shark.size){
                        eatableFishPQ.add(new Fish(mr,mc,map[mr][mc]));
                    }
                    if(map[mr][mc] <= shark.size){
                        q.add(new int[]{mr,mc});
                        isVisited[mr][mc] = true;
                    }
                }

            }
            distance++;

            if(!eatableFishPQ.isEmpty()){
                Fish eatableFish = eatableFishPQ.poll();

                map[eatableFish.r][eatableFish.c] = 0;
                resultSecond += distance;
                distance = 0;
                shark.countEattingFish++;
                q.clear();
                eatableFishPQ.clear();
                isVisited = new boolean[N][N];

                if(shark.size == shark.countEattingFish){
                    shark.size++;
                    shark.countEattingFish = 0;
                }

                q.add(new int[]{eatableFish.r, eatableFish.c, eatableFish.size});
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

                if(map[i][j] == 9){
                    shark = new Shark(i,j,2,0);
                    map[i][j] = 0;
                }
            }
        }
    }


    public static class Shark{
        int r;
        int c;
        int size;
        int countEattingFish;

        public Shark(int r, int c, int size, int countEattingFish){
            this.r = r;
            this.c = c;
            this.size = size;
            this.countEattingFish = countEattingFish;
        }
    }

    private static class Fish implements Comparable<Fish>{
        int r;
        int c;
        int size;

        public Fish(int r, int c, int size){
            this.r = r;
            this.c = c;
            this.size = size;
        }

        @Override
        public int compareTo(Fish o){
            if(this.r == o.r){
                return this.c - o.c;
            }else{
                return this.r - o.r;
            }
        }
    }
}