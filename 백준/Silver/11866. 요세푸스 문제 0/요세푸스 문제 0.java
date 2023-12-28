import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n, k;
    private static Queue<Integer> q = new LinkedList<>();
    private static LinkedList<Integer> l = new LinkedList<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int number = k;
        sb.append('<');
        while(!q.isEmpty()){
            number = k;

            while(number-- > 1){
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append('>');
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }
}