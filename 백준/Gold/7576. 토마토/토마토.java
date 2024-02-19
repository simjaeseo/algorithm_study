import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, notRoastedTomato;
    static Tomato[][] map;
    static boolean[][] isVisited;
    static int dr[] = new int[]{0, 0, -1, 1};
    static int dc[] = new int[]{-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
        while (!q.isEmpty()) {
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int mr = position[0] + dr[i];
                int mc = position[1] + dc[i];

                if (mr < 0 || mc < 0 || mr >= N || mc >= M || map[mr][mc].condition == -1 || map[mr][mc].condition == 1)
                    continue;

                q.add(new int[]{mr,mc});
                map[mr][mc].condition = 1;
                map[mr][mc].day = map[position[0]][position[1]].day + 1;
            }
        }

        int max = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j].condition==0)    flag = true;
                max = Math.max(map[i][j].day, max);
            }
        }

        System.out.println(flag ? -1 : max);
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new Tomato[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int index = 0;
            while (st.hasMoreTokens()) {
                int tomato = Integer.parseInt(st.nextToken());

                if (tomato == 0) notRoastedTomato++;
                else if (tomato == 1) {
                    isVisited[i][index] = true;
                    q.add(new int[]{i, index});
                }
                map[i][index++] = new Tomato(tomato, 0);
            }
        }
    }

    static class Tomato {
        int condition;
        int day;

        public Tomato(int condition, int day) {
            this.condition = condition;
            this.day = day;
        }
    }
}