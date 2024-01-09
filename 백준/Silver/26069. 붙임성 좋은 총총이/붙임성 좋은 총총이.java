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
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        int count = 0;
        int isDancing = 0;
        s.add("ChongChong");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            isDancing = 0;
            if(s.contains(A)){
                isDancing++;
            }
            if(s.contains(B)){
                isDancing++;
            }

            if(isDancing != 0){
                s.add(A);
                s.add(B);
            }

        }

        System.out.println(s.size());
    }
}