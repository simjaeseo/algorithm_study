import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static long N, A, B, K, sum;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

//        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        System.out.println(N*4);

    }


}