import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N, B;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        recur(0, 4);

    }

    private static void recur(int divideNumber, int pointNumber) {
        if(divideNumber == N - 1){
            System.out.println((int) Math.pow(Math.sqrt(pointNumber) + 1, 2));

            return;
        }

        recur(divideNumber+1, pointNumber * 4);




    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
    }


}