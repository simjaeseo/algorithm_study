import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, kR, kC, map[][], tempMap[][];
    static int dr[] = new int[]{0,0,-1,1};
    static int dc[] = new int[]{-1,1,0,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
        int n1 = 0;
        int n2 = 1;

        n1 = previousK();
        if(K != 0) {
            n2 = nextK();
        }
        System.out.println(n1 * n2);
    }

    private static int nextK() {

        for (int i = kC; i < M; i++) {
            tempMap[kR][i] = 1;
        }

        for (int i = kR; i < N; i++) {
            tempMap[i][kC] = 1;
        }


        for (int r = kR+1; r < N; r++) {
            for (int c = kC+1; c < M; c++) {
                int mr = r -1;
                int mc = c - 1;

                tempMap[r][c] = tempMap[mr][c] + tempMap[r][mc];
            }
        }

        return tempMap[N-1][M-1];
    }

    private static int previousK() {
        if(K == 0){
            kR = N-1;
            kC = M-1;
        }

        for (int i = 0; i < M; i++) {
            tempMap[0][i] = 1;
        }

        for (int i = 0; i < N; i++) {
            tempMap[i][0] = 1;
        }

        for (int r = 1; r < kR+1; r++) {
            for (int c = 1; c < kC + 1; c++) {
                int mr = r -1;
                int mc = c - 1;

                tempMap[r][c] = tempMap[mr][c] + tempMap[r][mc];
            }
        }

        return tempMap[kR][kC];

    }


    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tempMap = new int[N][M];


        if(K != 0){
            kR = K / M;
            kC = (K % M) - 1;
        }else{
            kR = -1;
            kC = -1;
        }

    }

}