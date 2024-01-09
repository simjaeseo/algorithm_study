import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static int n, k;
    private static ArrayList<Integer> l = new ArrayList<>();
    private static Set<String> s = new HashSet<>();

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

        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if(str.equals("ENTER")){
                count += s.size();
                s.clear();
            }else{
                s.add(str);
            }
        }
        count += s.size();

        System.out.println(count);
    }
}