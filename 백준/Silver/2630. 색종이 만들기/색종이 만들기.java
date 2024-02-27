import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], white, blue;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        process();

        System.out.println(white);
        System.out.println(blue);
    }

    private static void process() {
        recursion(0, 0, N);
    }

    private static void recursion(int startR, int startC, int size) {
        boolean isAllBlue = true;
        boolean isAllWhite = true;

        for (int i = startR; i < startR + size; i++) {
            for (int j = startC; j < startC + size; j++) {
                if (map[i][j] == 0) isAllBlue = false;
                else isAllWhite = false;
            }
        }

        if(isAllBlue){
            blue++;
        }else if(isAllWhite){
            white++;
        }else{
            recursion(startR, startC, size/2);
            recursion(startR, startC + size/2,size/2);
            recursion(startR+size/2, startC,size/2);
            recursion(startR + size/2, startC + size/2,size/2);
        }
    }

    public static void init() throws IOException {
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