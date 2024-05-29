import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x,y,k;
    static int map[][], dice[];
    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{1,-1,0,0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);


    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map= new int[N][M];
        dice = new int[6];

        int index = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                map[i][index++] = Integer.parseInt(st.nextToken());
            }
            index = 0;
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }


        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int command = Integer.parseInt(st.nextToken());

            roll(command, x, y);
        }
    }

    private static void roll(int command, int r, int c) {

        int mr = r + dr[command-1];
        int mc = c + dc[command-1];

        if(mr >= N || mc >= M || mr < 0 || mc < 0){
            return;
        }

        x = mr;
        y = mc;

//        System.out.println(x + " " + y);

        int temp = 0;

        if(command == 1){
            temp = dice[4];

            dice[4] = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;

        }else if(command == 2){
            temp = dice[4];

            dice[4] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[0];
            dice[0] = temp;

        }else if(command == 3){
            temp = dice[3];

            dice[3] = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;


        }else if(command == 4){
            temp = dice[3];

            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[0];
            dice[0] = temp;
        }

        if(map[x][y] == 0){
            map[x][y] = dice[0];
        }else{
            dice[0] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(dice[2]).append("\n");
    }

}