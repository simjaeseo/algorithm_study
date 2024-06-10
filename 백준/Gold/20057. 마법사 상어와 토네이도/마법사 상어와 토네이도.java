import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, map[][], outSandAmount;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{-1, 0, 1, 0};
    // 모래 흩날림 비율
    static int[][] spreadR = {
            {-1, 1, -2, 2, 0, -1, 1, -1, 1},
            {-1, -1, 0, 0, 2, 0, 0, 1, 1},
            {1, -1, 2, -2, 0, 1, -1, 1, -1},
            {1, 1, 0, 0, -2, 0, 0, -1, -1}
    };
    static int[][] spreadC = {
            {1, 1, 0, 0, -2, 0, 0, -1, -1},
            {-1, 1, -2, 2, 0, -1, 1, -1, 1},
            {-1, -1, 0, 0, 2, 0, 0, 1, 1},
            {1, -1, 2, -2, 0, 1, -1, 1, -1}
    };
    static int[] spreadPercent = {1, 1, 2, 2, 5, 7, 7, 10, 10};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();

        System.out.println(outSandAmount);
    }

    private static void process() {

        int r = N / 2;
        int c = N / 2;
        int countMoving = 0;
        int repeatNumber = 1;
        int directinoIndex = 0;
        int mr = r;
        int mc = c;

        while (true) {
            if (mr == 0 && mc == 0) break;

            if (countMoving == 2) {
                repeatNumber++;
                countMoving = 0;

                if (mr == 0) repeatNumber = N - 1;
            }

            for (int i = 0; i < repeatNumber; i++) {

                mr += dr[directinoIndex];
                mc += dc[directinoIndex];

//                System.out.println(mr + " " + mc);

                tonado(mr, mc, directinoIndex);
            }
            directinoIndex = (directinoIndex + 1) % 4;
            countMoving++;
        }


    }

    private static void tonado(int mr, int mc, int directinoIndex) {

        int sandAmount = map[mr][mc];
        int alphaSandAmount = sandAmount;

        for (int i = 0; i < spreadPercent.length; i++) {

            int nextR = mr + spreadR[directinoIndex][i];
            int nextC = mc + spreadC[directinoIndex][i];
            int spreadSandAmount = (int) (sandAmount * 0.01 * spreadPercent[i]);

            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
                outSandAmount += spreadSandAmount;
            } else {
                map[nextR][nextC] += spreadSandAmount;
            }

            alphaSandAmount -= spreadSandAmount;

        }

        int alphaR = mr + dr[directinoIndex];
        int alphaC = mc + dc[directinoIndex];

        if (alphaR < 0 || alphaC < 0 || alphaR >= N || alphaC >= N) {
            outSandAmount += alphaSandAmount;
        } else {
            map[alphaR][alphaC] += alphaSandAmount;
        }

        map[mr][mc] = 0;

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}