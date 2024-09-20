import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, arr[], start;
    static boolean isVisited[], result[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N+1];
            start = i;
            dfs(i);
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if(result[i]) count++;
        }

        sb.append(count).append('\n');
        for (int i = 1; i <= N; i++) {
            if(result[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);


    }

    private static void dfs(int current) {

        if(isVisited[current]) return;

        isVisited[current] = true;
        int next = arr[current];
        dfs(next);

        if(start == next){
            result[current] = true;
        }
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        result = new boolean[N+1];


        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

}