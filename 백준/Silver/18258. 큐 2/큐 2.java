import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static int n;
    private static LinkedList<Integer> q = new LinkedList<>();



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
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.pop()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.peek()).append('\n');
                    break;
                case "back":
                    if(q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.get(q.size()-1)).append('\n');
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