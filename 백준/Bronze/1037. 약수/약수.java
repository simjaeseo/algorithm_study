import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static int n, k;
    private static ArrayList<Integer> l = new ArrayList<>();

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
        System.out.println(sb);
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            k = Integer.parseInt(st.nextToken());

            l.add(k);
        }

        Collections.sort(l);

        if(l.size() == 1){
            sb.append((int) Math.pow(l.get(0), 2));
        }else{
            sb.append(l.get(0) * l.get(l.size()-1));
        }
    }
}