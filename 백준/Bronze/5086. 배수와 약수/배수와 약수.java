import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N, A, B;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0)  break;

            //1
            if(B / A > 0 && B % A == 0) System.out.println("factor");
            else if(A / B > 0 && A % B == 0) System.out.println("multiple");
            else System.out.println("neither");


            //2

            //3

        }
    }


}