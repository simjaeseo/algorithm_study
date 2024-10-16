import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M,max,map[][], pictureNumber;
    static boolean isVisited[][];
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !isVisited[i][j])  {
                    int count = 0;
                    count = bfs(i,j);

                    max = Math.max(max,count);
                    pictureNumber++;
                }
            }
        }

        System.out.println(pictureNumber);
        System.out.println(max);

        /*
        1. 문제 이해

        2. 요구 사항 분해

        3. 핵심 로직 설계

            "다른 관점에서 이 문제를 바라볼 수 있을까?"

        4. 조건 및 예외 처리 고려

        5. 코드 구조 잡기

        6. 구현 시작


         */


    }

    public static int bfs(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        isVisited[r][c] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = position[0] + dr[i];
                int nextC = position[1] + dc[i];

                if(nextR < 0 || nextC < 0 || nextR >=N || nextC >= M)   continue;
                if(isVisited[nextR][nextC]) continue;

                if (map[nextR][nextC] == 1) {
                    q.add(new int[]{nextR, nextC});
                    isVisited[nextR][nextC] = true;
                    count++;
                }
            }
        }

        return count;
    }


    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
