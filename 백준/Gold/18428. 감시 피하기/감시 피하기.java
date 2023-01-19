import com.sun.org.apache.xpath.internal.operations.Neg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean isAvoided, answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        completeSearch(0);
        if(answer){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static void completeSearch(int count) {

        if (count == 3) {
            isAvoided = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'T') {
                        search(i, j);
                    }
                }
            }
            if(isAvoided) answer = true;
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    completeSearch(count + 1);
                    map[i][j] = 'X';
                }
            }
        }

    }

    private static void search(int r, int c) {

        for (int i = 0; i < 4; i++) {
            int mr = r + dr[i];
            int mc = c + dc[i];

            while (!(mr < 0 || mc < 0 || mr >= N || mc >= N)) {
                if (map[mr][mc] == 'O') {
                    break;
                }

                if (map[mr][mc] == 'S') {
                    isAvoided = false;
                }

                mr = mr + dr[i];
                mc = mc + dc[i];
            }

        }


    }
}