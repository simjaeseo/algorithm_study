import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                int n = pq.isEmpty() ? 0 : pq.poll();
                sb.append(n).append('\n');
            }else{
                pq.add(x);
            }
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.print(sb);
    }
}