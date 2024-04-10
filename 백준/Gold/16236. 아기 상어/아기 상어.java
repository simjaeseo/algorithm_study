import java.util.*;
import java.io.*;

public class Main {
    static int N, maxSecond;
    static int[][] map;
    static int[][] distanceMap;
    static boolean[][] isVisited;
    static Shark shark;
    static LinkedList<Fish> fish = new LinkedList<>();

    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {


        while(fish.size() != 0){
            calculateDistance();

            int index = -1;
            for (int i = 0; i < fish.size(); i++) {
                if(fish.get(i).size < shark.size && fish.get(i).distanceToShark != Integer.MAX_VALUE) {
                    index = i;
                    break;
                }
            }

            if(index == -1 ) break;
            Fish f = fish.remove(index);


            map[shark.r][shark.c] = 0;
            shark.r = f.r;
            shark.c = f.c;
            map[f.r][f.c] = 9;
            shark.countEattingFish++;
            maxSecond += f.distanceToShark;

            if(shark.countEattingFish == shark.size){
                shark.size++;
                shark.countEattingFish = 0;
            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println(shark.size + " " + maxSecond);
////            System.out.println(index);
//            System.out.println();

        }
        System.out.println(maxSecond);

    }

    private static void calculateDistance() {

        Queue<int[]> q = new LinkedList<>();
        isVisited = new boolean[N][N];
        distanceMap = new int[N][N];

        q.add(new int[]{shark.r, shark.c});
        isVisited[shark.r][shark.c] = true;
        distanceMap[shark.r][shark.c] = 0;

        while(!q.isEmpty()){
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int mr = position[0] + dr[i];
                int mc = position[1] + dc[i];

                if(mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc]) continue;
                if(map[mr][mc] > shark.size)    continue;

                distanceMap[mr][mc] = distanceMap[position[0]][position[1]] + 1;
                q.add(new int[]{mr,mc});
                isVisited[mr][mc] = true;
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(distanceMap[i]));
//        }


        for(Fish f : fish){
            if(distanceMap[f.r][f.c] == 0){
                f.distanceToShark = Integer.MAX_VALUE;
            }else{
                f.distanceToShark = distanceMap[f.r][f.c];
            }
        }

        Collections.sort(fish);
//
//        for(Fish f : fish) {
//            System.out.println(f.size + " " + f.distanceToShark + " " + f.r + " " + f.c + " " );
//        }
//        System.out.println();
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
                } else if (map[i][j] != 0) {
                    Fish f = new Fish(i, j, map[i][j]);
                    fish.add(f);
                }

            }

        }
    }

    public static class Fish implements Comparable<Fish> {
        int r;
        int c;
        int size;
        int distanceToShark;

        public Fish(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }


        @Override
        public int compareTo(Fish o1) {
            int res = 0;

            if (this.distanceToShark != o1.distanceToShark) {
                res = this.distanceToShark - o1.distanceToShark;
            }else if (this.r != o1.r) {
                res = this.r - o1.r;
            } else {
                res = this.c - o1.c;
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