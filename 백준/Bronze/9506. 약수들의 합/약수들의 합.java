import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N, A, B, K, sum;
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


        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == -1) break;

            sum = 0;
            for (int i = 1; i < N; i++) {
                if(N%i == 0){
                    sum += i;
                }
            }

            if(sum == N){
                StringBuilder sb = new StringBuilder();

                sb.append(N).append(" = ");

                for (int i = 1; i < N; i++) {
                    if(N%i == 0){
                        sb.append(i).append(" + ");
                    }
                }
                sb.delete(sb.length()-3,sb.length()-1);
                System.out.println(sb);
            }else{
                System.out.println(N +" is NOT perfect.");
            }



        }


    }


}