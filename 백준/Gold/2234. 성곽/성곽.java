import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M, map[][], numberingMap[][], countRoom, maxRoom, maxRoomBrokenWall;
    static boolean[][] isVisited;
    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{-1,1,0,0};
    static Map<Integer, Integer> m = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
//        1-1 이중for문으로 map돌면서 넘버링
//        2-1 넘버링할때 Map에 카운트하면서 체크
        int number = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!isVisited[i][j]) {
                    numberingBFS(i, j, number);
                    number++;
                }
            }
        }

//        3-1 이중for문 한번 더 돌면서 현재위치 넘버랑 4방탐색 시 넘버랑 Map으로 밸류값 더했을때 최대값 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                findMaxRoomBrokenOneWall(i,j);
            }
        }

        countRoom = number;



        System.out.println(countRoom - 1);
        System.out.println(maxRoom);
        System.out.println(maxRoomBrokenWall);



    }

    private static void findMaxRoomBrokenOneWall(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
            if(numberingMap[r][c] == numberingMap[nextR][nextC]) continue;

            maxRoomBrokenWall = Math.max(maxRoomBrokenWall, m.get(numberingMap[r][c]) + m.get(numberingMap[nextR][nextC]));
        }
    }

    private static void numberingBFS(int r, int c, int number) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        isVisited[r][c] = true;
        numberingMap[r][c] = number;

        while(!q.isEmpty()){
            int[] position = q.poll();

            for (int i = 0; i < 4; i++) {
                if((map[position[0]][position[1]] & 1) == 1 && i == 0)  continue;
                if((map[position[0]][position[1]] & 2) == 2 && i == 2)  continue;
                if((map[position[0]][position[1]] & 4) == 4 && i == 1)  continue;
                if((map[position[0]][position[1]] & 8) == 8 && i == 3)  continue;

                int nextR = position[0] + dr[i];
                int nextC = position[1] + dc[i];

                if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || isVisited[nextR][nextC]) continue;

                isVisited[nextR][nextC] = true;
                q.add(new int[]{nextR, nextC});
                numberingMap[nextR][nextC] = number;
                count++;
            }
        }

        m.put(number, count);
        maxRoom = Math.max(maxRoom, count);
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        numberingMap = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

/*
- 문제 이해
서쪽 벽 1 - 1
북쪽벽 2 - 10
동쪽 벽 4- 100
남쪽 벽 8 - 1000

- 핵심 로직
1. 방 개수 세는 방법
2. 가장 넓은 방 크기 찾기
3. 벽 하나 제거해서 얻을 수 있는 가장 넓은 방 크기


- 세부 로직
1-1 이중for문으로 map돌면서 넘버링
2-1 넘버링할때 Map에 카운트하면서 체크
3-1 이중for문 한번 더 돌면서 현재위치 넘버랑 4방탐색 시 넘버랑 Map으로 밸류값 더했을때 최대값 갱신

- 조건 및 예외처리
1. 가장자리일때 인덱스벗어나는거
2. 벽 숫자 비트연산 고려

- 구현 순서



 */