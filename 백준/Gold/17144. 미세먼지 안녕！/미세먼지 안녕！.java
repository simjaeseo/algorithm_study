import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T, map[][], spreadMap[][], sum;
    static AirCleaner[] airCleaners = new AirCleaner[2];
    static int dr[] = new int[]{-1,1,0,0};
    static int dc[] = new int[]{0,0,-1,1};
    static int upsideAirCleanerDr[] = new int[]{0,-1,0,1};
    static int upsideAirCleanerDc[] = new int[]{1,0,-1,0};
    static int downsideAirCleanerDr[] = new int[]{0,1,0,-1};
    static int downsideAirCleanerDc[] = new int[]{1,0,-1,0};

    static ArrayList<int[]> microdusts = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        while(T>0){

            spreadMicrodust();
//            for (int i = 0; i < R; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            workUpsideAirCleaner(airCleaners[0].r, airCleaners[0].c);
            workDownsideAirCleaner(airCleaners[1].r,airCleaners[1].c);

            T--;
//            for (int i = 0; i < R; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) sum += map[i][j];
            }
        }
        System.out.println(sum);

    }

    private static void workUpsideAirCleaner(int r, int c) {

        //아래쪽
        for (int i = r-1; i > 0 ; i--) {
            if(r == 1){
                map[i-1][0] = 0;
            }else{
                map[i][0] = map[i-1][0];
                map[i-1][0] = 0;
            }
        }
        //왼쪽
        for (int i = 0; i < C-1 ; i++) {
            map[0][i] = map[0][i+1];
//            map[0][i+1] = 0;
        }
        //위쪽
        for (int i = 0; i < r ; i++) {
            map[i][C-1] = map[i+1][C-1];
//            map[i+1][C-1]=0;
        }
        //오른쪽
        for (int i = C-1; i > 1 ; i--) {
            map[r][i] = map[r][i-1];
//            map[r][i-1] = 0;
        }
        map[r][c+1] = 0;
    }

    private static void workDownsideAirCleaner(int r, int c) {
        //위쪽
        for (int i = r+1; i < R-1 ; i++) {
            if(r==R-1) {
                map[i+1][c] = 0;
            }else{
                map[i][0] = map[i+1][0];
                map[i+1][c] = 0;
            }
        }
        //왼쪽
        for (int i = 0; i < C-1 ; i++) {
            map[R-1][i] = map[R-1][i+1];
//            map[R-1][i+1] = 0;
        }
        //아래쪽
        for (int i = R-1; i > r ; i--) {
            map[i][C-1] = map[i-1][C-1];
//            map[i-1][C-1] = 0;
        }
        //오른쪽
        for (int i = C-1; i > 1 ; i--) {
            map[r][i] = map[r][i-1];
//            map[r][i-1] = 0;
        }
        map[r][c+1] = 0;

    }


    private static void spreadMicrodust() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0){
                    microdusts.add(new int[]{i,j});
                }
            }
        }
        for(int[] microdust : microdusts){
            spread(microdust[0],microdust[1]);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += spreadMap[i][j];
                spreadMap[i][j] = 0;
            }
        }

        microdusts.clear();

    }

    private static void spread(int r, int c) {
        int count = 0;
        int microdust = map[r][c] / 5;

        for (int i = 0; i < 4; i++) {
            int mr = r + dr[i];
            int mc = c + dc[i];

            if(mr>=R || mc>=C || mr<0 || mc<0 || map[mr][mc] == -1){
                count++;
                continue;
            }

            spreadMap[mr][mc] += microdust;
        }
        map[r][c] = map[r][c] - microdust * (4-count);
    }


    private static void init() throws IOException {

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        spreadMap = new int[R][C];

        int airCleanerIndex = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == -1){
                    airCleaners[airCleanerIndex++] = new AirCleaner(i,j);
                }
            }
        }
    }

    static class AirCleaner{
        int r;
        int c;

        public AirCleaner(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}