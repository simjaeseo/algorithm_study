import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int map[], N, M;
    static boolean isVisited[];
    static Map<Integer, Integer> laddersAndSnakes = new HashMap<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        bfs();

    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        isVisited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;

                if (next == 100) {
                    System.out.print(map[current]+1);
                    return;
                }

                if (next > 100) continue;

                if (laddersAndSnakes.containsKey(next)) {
                    next = laddersAndSnakes.get(next);
                }

                if (isVisited[next]) continue;

                q.add(next);
                isVisited[next] = true;
                map[next] = map[current] + 1;
            }
        }
    }


    private static void init() throws IOException {
        map = new int[101];
        isVisited = new boolean[101];

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            laddersAndSnakes.put(start, end);
        }
    }
}
