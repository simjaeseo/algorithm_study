import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][], resultMap[][];
    static boolean[][] isVisited;
    static Queue<int[]> wallQ = new ArrayDeque<>();
    static Map<Integer, Integer> spaceMap = new HashMap<>();

    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    process(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(resultMap[i][j] % 10);
            }
            sb.append('\n');
        }

        sb.delete(sb.length() - 1, sb.length());
        System.out.print(sb);
    }

    private static void process(int r, int c) {
        Set<Integer> set = new HashSet<>();
        int sum = 1;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;
            if (map[nextR][nextC] == 1) continue;
            if(set.contains(map[nextR][nextC])) continue;

            sum += spaceMap.get(map[nextR][nextC]);
            set.add(map[nextR][nextC]);
        }

        resultMap[r][c] = sum;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        resultMap = new int[N][M];
        isVisited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = inputs[j] - '0';

                if(map[i][j] == 1){
                }
            }
        }

        int number = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j, number++);
                }
            }
        }


//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
    }

    private static void bfs(int r, int c, int number) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 1;

        q.add(new int[]{r, c});
        isVisited[r][c] = true;
        map[r][c] = number;

        while (!q.isEmpty()) {
            int[] currentPosition = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = currentPosition[0] + dr[i];
                int nextC = currentPosition[1] + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || isVisited[nextR][nextC]) continue;
                if (map[nextR][nextC] == 1) continue;

                q.add(new int[]{nextR, nextC});
                isVisited[nextR][nextC] = true;
                map[nextR][nextC] = number;
                count++;
            }
        }

        spaceMap.put(number, count);
    }
}