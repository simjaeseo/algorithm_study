import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n;
    private static Deque<Integer> q = new ArrayDeque<>();



    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    int number = Integer.parseInt(st.nextToken());
                    q.add(number);
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.pop()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
                    break;
            }
        }
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

    }
}