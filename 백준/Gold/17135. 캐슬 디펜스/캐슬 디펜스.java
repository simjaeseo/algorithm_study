import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M,D,originMap[][], maxKillCount;
    static List<int[]> archerPositions = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        //조합 생성하기
        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                for (int k = j+1; k < M; k++) {
                    archerPositions.add(new int[]{i,j,k});
                }
            }
        }

        for(int[] archerPosition : archerPositions){
            int[][] map = copyMap();
            int killCount = simulation(map, archerPosition);
            maxKillCount = Math.max(maxKillCount, killCount);
        }

        System.out.println(maxKillCount);

    }

    private static int simulation(int[][] map, int[] archerPosition) {
        int killCount = 0;

        while(isExistEnemy(map)){
            List<int[]> enemies = new ArrayList<>();

            // 궁수 별로 죽일 적 위치 찾기
            for(int archerC : archerPosition){
                int[] enemy = findEnemy(map, archerC);

                if(enemy != null){
                    enemies.add(enemy);
                }
            }

            // 적들 죽이기
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

        for (int i = N-1; i > 0 ; i--) {
            map[i] = map[i-1];
        }

        map[0] = new int[M];
    }

    private static int[] findEnemy(int[][] map, int archerC) {
        int[] enemy = null;
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1){
                    int distance = Math.abs(N-i) + Math.abs(j - archerC);

                    if(distance <= D){
                        if(distance < minimumDistance || (distance == minimumDistance && j < enemy[1])){
                            minimumDistance = distance;
                            enemy = new int[]{i, j};
                        }
                    }
                }
            }
        }

        return enemy;
    }

    private static boolean isExistEnemy(int[][] map) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1)  return true;
            }
        }

        return false;
    }

    private static int[][] copyMap() {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = originMap[i][j];
            }
        }

        return newMap;
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

/*
1. 문제 이해하기
NXM 격자판
칸에 적은 하나만
격자판 맨아래의 바로 아래엔 성이 있음

궁수3명 배치(성에 있는칸에만 배치 가능 N+1)
각 턴마다 적 하나 공격 가능, 모든 궁수는 동시에 공격
공격 가능 거리는 D이하 중 가장 가까운 적 + 여럿인 경우 가장 왼쪽 적 공격
같은 적이 여러 궁수에게 공격 당할 수 있음.
적 공격당하면 게임 제외
궁수 공격 끝나면 남은 적들 아래로 이동, 성으로 이동하면 게임 제외
모든 적이 제외되면 게임끝

궁수의 위치 중요. 죽일 수 있는 적의 최대 수 찾자.

2. 요구사항 분해
궁수 3명 배치 방법
적 공격 방법
적 이동 방법

3. 조건 및 예외처리
- 적 중복으로 선정 가능
- 적을 맨 아래로 내려가면 제외


4. 핵심 로직 설계
- 조합을 통해 궁수 배치
- 공격할 적 선정 방법 - 적 탐색하면서 거리 계산 + 왼쪽인지 체크
                   - 적들을 다 선정 한 후 죽이기
- 적 r로 내리기
- 위의 두개를 적이 없을때까지 반복

- 구현 순서
1. 궁수 3명 조합 생성
2. 조합별로 시뮬 진행
3. 적 0명될때까지 반복
    4. 궁수 별로 죽일 적 선정
    5. 적 죽이기
    6. 적 아래로 내리기


 */