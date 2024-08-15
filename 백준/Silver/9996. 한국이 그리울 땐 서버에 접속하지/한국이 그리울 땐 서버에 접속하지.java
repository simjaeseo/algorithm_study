import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, lengthAfterStar;
    static char[] patterns;
    static String prefix, suffix, pattern[];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        pattern = br.readLine().split("\\*");

        prefix = pattern[0];
        suffix = pattern[1];

        for (int i = 0; i < N; i++) {
            String filename = br.readLine();

            if(filename.startsWith(prefix) && filename.endsWith(suffix) && filename.length() >= prefix.length() + suffix.length()) sb.append("DA").append('\n');
            else sb.append("NE").append('\n');
        }

        System.out.print(sb);
    }

}