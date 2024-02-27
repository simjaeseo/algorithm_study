import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R, map[][], tempMap[][];
    static boolean[][] isVisited;
    static int[] dr = new int[]{0, 0, -1, 1};
    static int[] dc = new int[]{-1, 1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
        int count = 0;

        while(true){
            boolean notCompleteFlag = false;
            boolean isMoreProcess = false;

            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        notCompleteFlag = bfs(i, j);
                        if(notCompleteFlag) isMoreProcess = true;
                    }
                }
            }
            if(!isMoreProcess)    break;

            count++;
        }
        System.out.println(count);


    }

    private static boolean bfs(int r, int c) {
        boolean existUnion = false;
        
        for (int i = 0; i < 4; i++) {
            int mr = r + dr[i];
            int mc = c + dc[i];

            if (mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc]) continue;

            int humanGap = Math.abs(map[r][c] - map[mr][mc]);
            if (humanGap < L || humanGap > R) continue;
            
            existUnion = true;
            break;
        }
        
        
        if(existUnion){

            Queue<int[]> q = new LinkedList<>();
            Queue<int[]> nationsPosition = new LinkedList<>();
            int sum = 0;
            int countryCount = 0;

            isVisited[r][c] = true;

            q.add(new int[]{r, c});
            nationsPosition.add(new int[]{r, c});

            while (!q.isEmpty()) {
                int[] position = q.poll();
                sum += map[position[0]][position[1]];
                countryCount++;

                for (int i = 0; i < 4; i++) {
                    int mr = position[0] + dr[i];
                    int mc = position[1] + dc[i];

                    if (mr < 0 || mc < 0 || mr >= N || mc >= N || isVisited[mr][mc]) continue;

                    int humanGap = Math.abs(map[position[0]][position[1]] - map[mr][mc]);
                    if (humanGap < L || humanGap > R) continue;

                    q.add(new int[]{mr, mc});
                    nationsPosition.add(new int[]{mr, mc});
                    isVisited[mr][mc] = true;
                }
            }

            int newHuman = sum/countryCount;

            while(!nationsPosition.isEmpty()){
                int[] p = nationsPosition.poll();
                map[p[0]][p[1]] = newHuman;
            }

            if(countryCount>= 2)    return true;
            return false;
        }
        
        
        return false;
    }


    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}

