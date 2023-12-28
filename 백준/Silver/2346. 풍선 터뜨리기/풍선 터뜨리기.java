import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n, k;
    private static Deque<Balloon> dq = new ArrayDeque<>();
    private static LinkedList<Integer> l = new LinkedList<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {

        while(!dq.isEmpty()){
            Balloon balloon = dq.poll();

            int number = balloon.number;
            int order = balloon.order;

            sb.append(order).append(' ');

            if(!dq.isEmpty()){
                if(number > 0){
                    for (int i = 0; i < number - 1; i++) {
                        dq.add(dq.pollFirst());
                    }
                }else{
                    for (int i = 0; i < number * -1; i++) {
                        dq.addFirst(dq.pollLast());
                    }
                }
            }
        }
    }

    private static void print() throws IOException {
        System.out.println(sb);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int order = 1;
        while(st.hasMoreTokens()){
            dq.add(new Balloon(order++, Integer.parseInt(st.nextToken())));
        }
    }

    static class Balloon{
        int order;
        int number;

        Balloon(int order, int number){
            this.order = order;
            this.number = number;
        }
    }
}