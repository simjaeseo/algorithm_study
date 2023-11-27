import java.io.*;
import java.math.BigInteger;
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





        st = new StringTokenizer(br.readLine());

        int a1, a0, c, n0;

        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());

        if(a0 <= c * n0 - a1 * n0 && a1<=c){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

//    https://small-stepping.tistory.com/330

}