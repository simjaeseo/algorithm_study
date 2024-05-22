import java.util.*;
import java.io.*;

public class Main {
    static int N, maxLength = 0, lines[][];
    static Integer dp[], decreaseDP[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        Arrays.sort(lines, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(lines[j][1] < lines[i][1] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > maxLength)   maxLength = dp[i];
        }

        System.out.println(N - maxLength);
    }

    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

        lines = new int[N][2];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
    }
}