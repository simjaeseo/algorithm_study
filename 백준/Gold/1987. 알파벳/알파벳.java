import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int R,C,max = 1;
    static char map[][];
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        dfs(0,0,1 << (map[0][0] - 'A'), 1);

        System.out.println(max);
    }

    private static void dfs(int r, int c, int alpabetBit, int count) {
        max = Math.max(count, max);

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue;
            int nextAlphabetBit = 1 << (map[nextR][nextC] - 'A');
            if((alpabetBit & nextAlphabetBit) != 0 ) continue;

            dfs(nextR, nextC, alpabetBit | nextAlphabetBit, count+1);

        }



    }


    private static void init() throws IOException {

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                map[i][j] = inputs[j];
            }
        }
    }

}