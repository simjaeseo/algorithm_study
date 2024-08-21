import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, positions[];
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        Arrays.sort(positions);

        System.out.println(positions[(N-1)/2]);
    }



    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        positions = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            positions[i] = (Integer.parseInt(st.nextToken()));
        }

    }
}