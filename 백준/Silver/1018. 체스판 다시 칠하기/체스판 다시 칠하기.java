import java.io.*;
import java.util.*;


public class Main {
    static int r, m;
    static char[][] map;
    static int minNumber = Integer.MAX_VALUE;

    static char[][] chess1 = new char[][] {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
    };

    static char[][] chess2 = new char[][] {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };

    public static void main(String[] args) throws IOException {
        init();

        findMinimum();

        System.out.println(minNumber);
    }

    private static void findMinimum() {

        for (int startR = 0; startR < r; startR++) {
            if(r - (startR+8) < 0) break;
            for (int startC = 0; startC < m; startC++) {
                if(m - (startC+8) < 0) break;

                int chessIndexR = 0;

                int count1 = 0;
                int count2 = 0;
                for (int indexR = startR; indexR < startR + 8; indexR++) {
                    int chessIndexC = 0;

                    for (int indexC = startC; indexC < startC + 8; indexC++) {
                        if(map[indexR][indexC] != chess1[indexR - startR][indexC - startC]){
                            count1++;
                        }
                        if(map[indexR][indexC] != chess2[indexR - startR][indexC - startC]){
                            count2++;
                        }
                    }
                }

                minNumber = Math.min(minNumber, count1);
                minNumber = Math.min(minNumber, count2);



            }
        }

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[r][m];

        for (int i = 0; i < r; i++) {
            char[] inputs = br.readLine().toCharArray();

            map[i] = inputs;
        }



    }

}