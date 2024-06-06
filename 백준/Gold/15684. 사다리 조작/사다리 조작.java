import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H, minimum = 4;
    static boolean ladders[][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        dfs(0,1,1);

        if(minimum == 4) System.out.println(-1);
        else System.out.println(minimum);
    }

    private static void dfs(int count, int r, int c) {
        if(count >= minimum)    return;

        if(check()){
            minimum = count;
            return;
        }


        for (int i = r; i <= H; i++, c=1) {

            for (int j = c; j < N; j++) {
                //인접한 가로선이 없다면
                if(!ladders[i][j-1] && !ladders[i][j] && !ladders[i][j+1] ){
                    ladders[i][j] = true;
                    dfs(count+1, i, j);
                    ladders[i][j] = false;
                }
            }
        }



    }

    private static boolean check() {

        for (int i = 1; i <= N; i++) {
            int startLadderNumber = i;

            for (int j = 1; j <= H; j++) {
                if(ladders[j][startLadderNumber])   startLadderNumber++;
                else if(startLadderNumber > 1 && ladders[j][startLadderNumber-1])   startLadderNumber--;
            }
            if(startLadderNumber != i)  return false;
        }

        return true;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladders = new boolean[H+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladders[a][b] = true;
        }
    }


}