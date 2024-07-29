import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, D, originMap[][], maxKillCount;
    static ArrayList<int[]> archerPositions = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }

    private static void solve() {
        // 먼저, 궁수들의 조합을 싹다 구하자.

        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                for (int k = j+1; k < M; k++) {
                    archerPositions.add(new int[]{i,j,k});
                }
            }
        }

        for(int[] archerPosition : archerPositions){
            int[][] map = copyMap(originMap);
            int killCount = simulation(map, archerPosition);
            maxKillCount = Math.max(maxKillCount, killCount);
        }

        System.out.println(maxKillCount);
    }

    private static int[][] copyMap(int[][] originMap) {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = originMap[i][j];
            }
        }

        return newMap;
    }

    private static int simulation(int[][] map, int[] archerPosition) {
        int killCount = 0;

        while(isExistedEnemy(map)){
            Set<int[]> enemies = new HashSet<>();

            // 먼저, 각 궁수의 적을 찾는다. 그리고 중복제거를 위해 Set에 저장한다.
            for(int archer : archerPosition){
                int[] enemy = findEnemy(map, archer);

                if(enemy != null){
                    enemies.add(enemy);
                }
            }

            // 중복제거한 적들을 죽인다.
            for(int[] enemy : enemies){
                if(map[enemy[0]][enemy[1]] == 1){
                    map[enemy[0]][enemy[1]] = 0;
                    killCount++;
                }
            }

            moveEnemy(map);
        }

        return killCount;
    }

    private static void moveEnemy(int[][] map) {

        for (int i = N-1; i > 0; i--) {
            map[i] = map[i-1];
        }

        map[0] = new int[M];
    }

    private static int[] findEnemy(int[][] map, int archer) {
        int minimumDistance = Integer.MAX_VALUE;
        int[] enemy = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1){
                    int distance = Math.abs(N-i) + Math.abs(archer-j);

                    if(distance <= D){
                        if(distance < minimumDistance || (distance == minimumDistance && j < enemy[1]) ){
                            minimumDistance = distance;
                            enemy = new int[]{i,j};
                        }
                    }
                }
            }
        }

        return enemy;
    }

    private static boolean isExistedEnemy(int[][] map) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1)  return true;
            }
        }

        return false;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}