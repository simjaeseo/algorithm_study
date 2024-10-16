import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int map[], N, M;
    static boolean isVisited[];
    static Map<Integer, Integer> ladders = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        System.out.println(bfs(1));

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

    private static int bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        isVisited[start] = true;
        q.add(new int[]{start, 0});

        while(!q.isEmpty()){
            int[] position = q.poll();

            for (int i = 1; i <= 6; i++) {
                int nextPosition = position[0] + i;
                int nextCount = position[1] + 1;

                if(nextPosition > 100) continue;
                if(nextPosition == 100) return nextCount;
                if(isVisited[nextPosition]) continue;

                if(ladders.containsKey(nextPosition)){
                    if(isVisited[ladders.get(nextPosition)]) continue;

                    q.add(new int[] {ladders.get(nextPosition), nextCount});
                    isVisited[ladders.get(nextPosition)] = true;
                }else if(snakes.containsKey(nextPosition)){
                    if(isVisited[snakes.get(nextPosition)]) continue;

                    q.add(new int[] {snakes.get(nextPosition), nextCount});
                    isVisited[snakes.get(nextPosition)] = true;
                }else{
                    q.add(new int[] {nextPosition, nextCount});
                    isVisited[nextPosition] = true;
                }


            }


        }

        return 0;


    }


    private static void init() throws IOException {
        map = new int[101];
        isVisited = new boolean[101];

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ladders.put(start, end);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            snakes.put(start, end);
        }



    }

}
