import java.util.*;
import java.io.*;

public class Main {
    static int K, W, H, map[][], result;
    static boolean isVisited[][][];
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static int[] horseDr = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horseDc = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();

        if(result == 0) {

            if(W == 1 && H == 1) System.out.println(0);
            else System.out.println(-1);

        }
        else System.out.println(result);
    }

    private static void process() {

        bfs();

    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        isVisited = new boolean[K+1][H][W];

        q.add(new int[]{0, 0, 0, 0});
        isVisited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] currentPosition = q.poll();

            if (currentPosition[0] == H - 1 && currentPosition[1] == W - 1) {
                result = currentPosition[3];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = currentPosition[0] + dr[i];
                int nextC = currentPosition[1] + dc[i];
                int nextSpendK = currentPosition[2]; // 4방탐색일때는 K사용X
                int nextMoveCount = currentPosition[3] + 1;

                if (nextR < 0 || nextC < 0 || nextR >= H || nextC >= W || isVisited[nextSpendK][nextR][nextC]) continue;
                if(map[nextR][nextC] == 1) continue;

                q.add(new int[]{nextR, nextC, nextSpendK, nextMoveCount});
                isVisited[nextSpendK][nextR][nextC] = true;
            }

            for (int i = 0; i < 8; i++) {
                int nextR = currentPosition[0] + horseDr[i];
                int nextC = currentPosition[1] + horseDc[i];
                int nextSpendK = currentPosition[2] + 1;
                int nextMoveCount = currentPosition[3] + 1;

                if (nextSpendK >= K+1) continue;
                if (nextR < 0 || nextC < 0 || nextR >= H || nextC >= W || isVisited[nextSpendK][nextR][nextC]) continue;
                if(map[nextR][nextC] == 1) continue;

                q.add(new int[]{nextR, nextC, nextSpendK, nextMoveCount});
                isVisited[nextSpendK][nextR][nextC] = true;
            }
        }


    }

    private static void init() throws IOException {
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}