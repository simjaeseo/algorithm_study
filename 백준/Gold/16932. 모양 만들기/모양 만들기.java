import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M, map[][], areaSize[], answer;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        // 최대 연결 요소 개수는 N*M 개일 수도 있으나, 실제로는 더 적음.
        // 일단 배열 크기를 N*M+2 정도로 잡아서 충분히 커버 가능.
        areaSize = new int[N * M + 2];


        // map 요소가 1까지 있으니 2부터 시작.
        int number = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) bfs(i, j, number++);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) calculateSize(i, j);
            }
        }

        System.out.println(answer);

    }

    private static void calculateSize(int r, int c) {
        int sum = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M ) continue;
            if(map[nextR][nextC] == 0) continue;

            if(!set.contains(map[nextR][nextC])){
                sum += areaSize[map[nextR][nextC]];
                set.add(map[nextR][nextC]);
            }
        }

        answer = Math.max(answer, sum);
    }

    private static void bfs(int r, int c, int number) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});

        map[r][c] = number;
        int count = 1;

        while(!q.isEmpty()) {
            int[] currrent = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = currrent[0] + dr[i];
                int nextC = currrent[1] + dc[i];

                if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M ) continue;
                if(map[nextR][nextC] == 1){
                    map[nextR][nextC] = number;
                    q.add(new int[]{nextR,nextC});
                    count++;
                }

            }
        }

        areaSize[number] = count;
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
            }
        }
    }
}