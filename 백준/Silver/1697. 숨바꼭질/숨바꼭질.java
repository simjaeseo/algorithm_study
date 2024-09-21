import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K;
    static int[] isVisited;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        isVisited = new int[100001];

        for (int i = 0; i < 100001; i++) {
            isVisited[i] = -1;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        isVisited[N] = 0;
        q.add(N);


        while(!q.isEmpty()){
            int current = q.poll();

            if(current == K)    {
                System.out.println(isVisited[current]);
                return;
            }

            int[] nextPositions = {current -1, current+1, current*2};
            for(int next : nextPositions){
                if(next >=0 && next <= 100000 && isVisited[next] == -1){
                    isVisited[next] = isVisited[current] + 1;
                    q.add(next);
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