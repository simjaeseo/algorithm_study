import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n, k;
    private static Deque<Integer> qs = new ArrayDeque<>();
    private static boolean[] isQueue;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {

    }

    private static void print() throws IOException {
    }

    private static void init() throws IOException {
        int N = Integer.parseInt(br.readLine());
        isQueue = new boolean[N];

        st = new StringTokenizer(br.readLine());

        int count = 0;
        int index = 0;
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                isQueue[index] = true;
                count++;
            }
            index++;
        }

        st = new StringTokenizer(br.readLine());

        index = 0;
        while (st.hasMoreTokens()) {
            int b = Integer.parseInt(st.nextToken());

            if (isQueue[index]) {
                qs.addLast(b);
            }

            index++;
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int c = Integer.parseInt(st.nextToken());

            if(!qs.isEmpty()){
                qs.addFirst(c);
                c = qs.pollLast();
            }

            sb.append(c).append(' ');
        }
        System.out.println(sb);
    }

    static class QueueStack {
        int type;
        int number;

        QueueStack(int type) {
            this.type = type;
        }
    }

}

// q s s q