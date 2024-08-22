
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K;
    static String table;
    static boolean[] isAte;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        isAte = new boolean[N];
        int count = 0;

        for (int i = 0; i < table.length(); i++) {

            if(table.charAt(i) == 'P'){

                int startIndex = Math.max(0, i-K);
                int endIndex = Math.min(N-1, i+K);

                for (int j = startIndex; j <= endIndex; j++) {
                    if(!isAte[j] && table.charAt(j) == 'H'){
                        isAte[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);


    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = br.readLine();


    }
}