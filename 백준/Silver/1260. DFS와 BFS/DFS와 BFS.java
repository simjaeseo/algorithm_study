import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static int adjMatrix[][];
    static boolean isVisited[];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
        isVisited = new boolean[N];
        dfs(V-1);
        sb.append('\n');
        isVisited = new boolean[N];
        bfs(V-1);
        System.out.println(sb);

    }

    private static void bfs(int vertex) {

        Queue<Integer> q = new LinkedList<>();

        q.add(vertex);
        isVisited[vertex] = true;
        sb.append(vertex+1).append(' ');

        while(!q.isEmpty()){
            int currentVertex = q.poll();

            for (int i = 0; i < N; i++) {
                if(!isVisited[i] && adjMatrix[currentVertex][i] > 0){
                    q.add(i);
                    isVisited[i] = true;
                    sb.append(i+1).append(' ');
                }
            }
        }

//        System.out.println(sb);

    }


    public static void dfs(int vertex){

        isVisited[vertex] = true;
        sb.append(vertex+1).append(' ');

        for (int i = 0; i < N; i++) {
            if(!isVisited[i] && adjMatrix[vertex][i] > 0){
                dfs(i);
            }
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjMatrix = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            adjMatrix[from][to] = adjMatrix[to][from] = 1;
        }
    }
}