import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, map[][], point;
    static boolean isVisited[][];
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static PriorityQueue<BlockGroup> pq = new PriorityQueue<>();
    static final int EMPTY = -9;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

//        오토플레이 반복 (블록 그룹 없을때까지)
//        1. 크기 가장 큰 블록 그룹 찾기 (크기 같은게 여러개면 무지개 블록 개수 가장큰거 -> 기준 블록 행이 가장 큰거 -> 열이 가장 큰거
//                - 1. 블록 그룹 찾을때 같은색만!



        while (true) {
            isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && map[i][j] >= 1) {
                        findBlcokGroup(i, j, map[i][j]);
                    }
                }
            }

            if(pq.isEmpty())    break;

//            for(BlockGroup bg : pq){
//                System.out.println(bg.baseBlockR + " " + bg.baseBlockC + " " + bg.numberOfRainbowBlock);
//            }

//        2. 블록 그룹 모드 제거 후 B^2점 획득
            BlockGroup blockGroup = pq.poll();
            pq.clear();
            removeBlockGroup(blockGroup);
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
//        3. 중력 작용 (검은색 블록은 중력X)
            gravity();
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
//        4. 90도 반시계 방향 회전
            rotate();
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
//        5. 중력
            gravity();
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
//            return;
        }

        System.out.println(point);


    }

    private static void rotate() {
        int[][] newMap = new int[N][N];


        for (int c = N-1; c >= 0; c--) {
            int[] array = new int[N];
            for (int r = 0; r < N; r++) {
                array[r] = map[r][c];
            }
            newMap[N-1-c] = array;
        }

        map = newMap;



    }

    private static void gravity() {

        for (int c = 0; c < N; c++) {
            for (int r = N-1; r >= 0; r--) {
                if(map[r][c] >= 0){
                    int bottomR = 0;
                    boolean flag = false;

                    for (int i = r+1; i < N; i++) {
                        if(map[i][c] == EMPTY) {
                            bottomR = i;
                            flag = true;
                        }
                        else break;
                    }

                    if(flag){
                        map[bottomR][c] = map[r][c];
                        map[r][c] = EMPTY;
                    }
                }
            }
        }
    }

    private static void removeBlockGroup(BlockGroup blockGroup) {
        Queue<int[]> q = new LinkedList<>();
        isVisited = new boolean[N][N];
        q.add(new int[]{blockGroup.baseBlockR, blockGroup.baseBlockC});
        isVisited[blockGroup.baseBlockR][blockGroup.baseBlockC] = true;
        map[blockGroup.baseBlockR][blockGroup.baseBlockC] = EMPTY;

        int baseBlock = blockGroup.baseBlock;
        int count = 1;

        while (!q.isEmpty()) {
            int[] RC = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = RC[0] + dr[i];
                int nextC = RC[1] + dc[i];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || isVisited[nextR][nextC]) continue;
                //같은 블록이거나 무지개 블록이라면?
                if (map[nextR][nextC] == baseBlock || map[nextR][nextC] == 0) {
                    q.add(new int[]{nextR, nextC});
                    isVisited[nextR][nextC] = true;
                    map[nextR][nextC] = EMPTY;
                    count++;
                }
            }
        }

        point += (int) Math.pow(count, 2);
    }

    private static void findBlcokGroup(int r, int c, int baseBlock) {
        BlockGroup blockGroup = new BlockGroup(0,baseBlock, r, c,0);
        int count = 1;

        Set<int[]> rainbowBlockPositions = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        isVisited[r][c] = true;

        while (!q.isEmpty()) {
            int[] RC = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = RC[0] + dr[i];
                int nextC = RC[1] + dc[i];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || isVisited[nextR][nextC]) continue;
                //같은 블록이거나 무지개 블록이라면?
                if (map[nextR][nextC] == baseBlock || map[nextR][nextC] == 0) {
                    q.add(new int[]{nextR, nextC});
                    isVisited[nextR][nextC] = true;
                    count++;

                    if (map[nextR][nextC] == 0) {
                        rainbowBlockPositions.add(new int[]{nextR, nextC});
                        blockGroup.numberOfRainbowBlock++;
                    }
                    if (map[nextR][nextC] == baseBlock){
                        if(blockGroup.baseBlockR != nextR){
                            if(blockGroup.baseBlockR > nextR){
                                blockGroup.baseBlockR = nextR;
                                blockGroup.baseBlockC = nextC;
                            }
                        }else{
                            if(blockGroup.baseBlockC > nextC){
                                blockGroup.baseBlockR = nextR;
                                blockGroup.baseBlockC = nextC;
                            }
                        }
                    }
                }
            }
        }
        blockGroup.size = count;

        if(count >= 2) pq.add(blockGroup);

        if(!rainbowBlockPositions.isEmpty()){
            for(int[] rainbowBlockPosition : rainbowBlockPositions){
                isVisited[rainbowBlockPosition[0]][rainbowBlockPosition[1]] = false;
            }
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class BlockGroup implements Comparable<BlockGroup>{
        int numberOfRainbowBlock;
        int baseBlock;
        int baseBlockR, baseBlockC;
        int size;

        BlockGroup(int numberOfRainbowBlock, int baseBlock, int baseBlockR, int baseBlockC, int size) {
            this.numberOfRainbowBlock = numberOfRainbowBlock;
            this.baseBlock = baseBlock;
            this.baseBlockR = baseBlockR;
            this.baseBlockC = baseBlockC;
            this.size = size;
        }

        @Override
        public int compareTo(BlockGroup o){
            if(this.size != o.size) return o.size - this.size;
            else if(this.numberOfRainbowBlock != o.numberOfRainbowBlock) return o.numberOfRainbowBlock - this.numberOfRainbowBlock;
            else if(this.baseBlockR != o.baseBlockR) return o.baseBlockR - this.baseBlockR;
            return o.baseBlockC - this.baseBlockC;
        }
    }
}
/*
- 문제 이해
1. NXN 격자
2. 일반볼록 M가지 (M이하 자연수로 표현)
검은색블록 -1
무지개블록 0
인접한칸 = 맨헤튼거리 1
3. 블록그룹 = 인접한 블록의 집합 (일반 블록 적어도 1개 이상, 블록 색 같아야함, 검은색 포함X 무지개 블록은 상관x, 블록 개수 2이상)
블록그룹의 기준 블록 = 무지개 블록이 아닌 블록 중 행 번호가 가장 작은 -> 여러개면 열의 번호 가장 작은 블록
4. 오토플레이 반복 후 획득한 점수의 합 구하기

- 핵심 로직

오토플레이 반복 (블록 그룹 없을때까지)
1. 크기 가장 큰 블록 그룹 찾기 (크기 같은게 여러개면 무지개 블록 개수 가장큰거 -> 기준 블록 행이 가장 큰거 -> 열이 가장 큰거
2. 블록 그룹 모드 제거 후 B^2점 획득
3. 중력 작용 (검은색 블록은 중력X)
4. 90도 반시계 방향 회전
5. 중력

- 세부 로직
1-1 블록 그룹 클래스 생성 후 무지개블록 개수, 기준 블록 행, 열 저장해서 PQ만들기
1-2 while(true)하고 PQ.isEmpty했을때 없으면 break
2-1 pq.poll한 블록그룹의 기준블록 bfs 다시 하면서 제거 후 B^2
3-1 for 0 -> M for N-1 -> 0 이중 포문 탐색하면서 while문 넣어서 중력
4-1 newMap 만들어서 회전
5-1 3-1 반복

- 조건 및 예외 처리
1. 블록 그룹 찾을때 같은색만!
2. 중력시 검은색 블록 처리!!

- 구현 순서
1. 크기 가장 큰 블록 그룹 찾기 (크기 같은게 여러개면 무지개 블록 개수 가장큰거 -> 기준 블록 행이 가장 큰거 -> 열이 가장 큰거
    - 1. 블록 그룹 찾을때 같은색만!
2. 블록 그룹 모드 제거 후 B^2점 획득
3. 중력 작용 (검은색 블록은 중력X)
4. 90도 반시계 방향 회전
5. 중력

 */