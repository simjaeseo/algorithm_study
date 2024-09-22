import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K;
    static int[] spentTime, countWay;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }

    private static void solve() {

        spentTime = new int[100001];
        countWay = new int[100001];

        for (int i = 0; i < 100001; i++) {
            spentTime[i] = -1;
        }

        bfs();

        System.out.println(spentTime[K]);
        System.out.println(countWay[K]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        spentTime[N] = 0;
        countWay[N] = 1;
        q.add(N);


        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == K) {
                return;
            }

            int[] nextPositions = {current - 1, current + 1, current * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000) {

                    if (spentTime[next] == -1) {
                        spentTime[next] = spentTime[current] + 1;
                        countWay[next] = countWay[current];
                        q.add(next);
                    } else if (spentTime[next] == spentTime[current] + 1) {
                        countWay[next] += countWay[current];
                    }
                }
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

}