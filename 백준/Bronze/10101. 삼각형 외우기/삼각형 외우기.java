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


//        N = Integer.parseInt(br.readLine());

        int[] angle = new int[3];

        for (int i = 0; i < 3; i++) {
//            st = new StringTokenizer(br.readLine());
            angle[i] = Integer.parseInt(br.readLine());

            sum += angle[i];
        }

        if(sum != 180) {
            System.out.println("Error");
            return;
        }

        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if(angle[i] != 60)  flag =true;
        }

        if(!flag){
            System.out.println("Equilateral");
            return;
        }

        if(angle[0] != angle[1] && angle[1] != angle[2] && angle[0] != angle[2]){
            System.out.println("Scalene");
            return;
        }

        if(angle[0] == angle[1] && angle[1] != angle[2]
        || angle[0] != angle[1] && angle[1] == angle[2]
        || angle[0] == angle[2] && angle[1] != angle[2]){
            System.out.println("Isosceles");
        }

    }


}