import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][],countCheeze;
    static boolean isVisited[][];
    static Queue<int[]> meltingCheezePosition = new ArrayDeque<>();
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();

    }

    private static void process() {
        int second = 0;

        numberingOutsideBFS(0, 0);

        while (countCheeze != 0) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && isContactedTwoOutside(i, j)) {
                        map[i][j] = 0;
                        meltingCheezePosition.add(new int[]{i,j});
                        countCheeze--;
                    }
                }
            }

//            for(int[] p : meltingCheezePosition){
//                map[p[0]][p[1]] = -1;
//            }

            int size = meltingCheezePosition.size();
            for (int i = 0; i < size; i++) {
                int[] p = meltingCheezePosition.poll();
                if(map[p[0]][p[1]] == 0){
                    numberingOutsideBFS(p[0], p[1]);
                }
            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();


            second++;
        }

        System.out.println(second);
    }

    private static boolean isContactedTwoOutside(int r, int c) {
        int countOutside = 0;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;

            if(map[nextR][nextC] == -1){
                countOutside++;
            }
        }

        if(countOutside >= 2) return true;
        else return false;
    }

    private static void numberingOutsideBFS(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        isVisited = new boolean[N][M];
        isVisited[r][c] = true;
        q.add(new int[]{r, c});
        map[r][c] = -1;

        while (!q.isEmpty()) {
            int[] currentRC = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = currentRC[0] + dr[i];
                int nextC = currentRC[1] + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || isVisited[nextR][nextC]) continue;

                if(map[nextR][nextC] == 0){
                    map[nextR][nextC] = -1;
                    q.add(new int[]{nextR,nextC});
                    isVisited[nextR][nextC] = true;
                }
            }
        }

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1)  countCheeze++;
            }
        }
    }
}