import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K;
    static int[] time;
    static final int MAX = 100001;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        time = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            time[i] = -1;
        }

        bfs();
        System.out.println(time[K]);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        time[N] = 0;
        q.add(N);

        while(!q.isEmpty()){
            int current = q.poll();

            if(current == K) return;

            int[] nextPositions = {current * 2,current-1, current+1};
            for(int next : nextPositions){
                if(next < 0 || next > 100000) continue;

                if(time[next] == -1){

                    if(next == current * 2){
                        time[next] = time[current];
                    }else{
                        time[next] = time[current] + 1;
                    }
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