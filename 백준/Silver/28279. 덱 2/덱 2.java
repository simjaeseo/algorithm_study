import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n, k;
    private static Deque<Integer> dq = new ArrayDeque<>();
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
        while (n-- > 0) {

            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int X = 0;

            switch (command) {
                case 1:
                    X = Integer.parseInt(st.nextToken());
                    dq.addFirst(X);
                    break;
                case 2:
                    X = Integer.parseInt(st.nextToken());
                    dq.addLast(X);
                    break;
                case 3:
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    break;
                case 4:
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
                    break;
                case 5:
                    sb.append(dq.size()).append('\n');
                    break;
                case 6:
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7:
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;
                case 8:
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
            }
        }
        sb.delete(sb.length()-1, sb.length());
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
    }
}