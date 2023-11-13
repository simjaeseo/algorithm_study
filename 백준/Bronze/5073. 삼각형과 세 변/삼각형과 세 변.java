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


        while(true){
            int[] side = new int[3];

            st = new StringTokenizer(br.readLine());
            side[0] = Integer.parseInt(st.nextToken());
            side[1] = Integer.parseInt(st.nextToken());
            side[2] = Integer.parseInt(st.nextToken());

            if(side[0] == side[1] && side[2] == side[1] && side[0] == 0){
                break;
            }

            Arrays.sort(side);

            if(side[0] + side[1] <= side[2]){
                System.out.println("Invalid");
                continue;
            }

            if(side[0] == side[1] && side[2] == side[1]){
                System.out.println("Equilateral");
                continue;
            }

            if(side[0] == side[1] && side[1] != side[2]
                    || side[0] != side[1] && side[1] == side[2]
                    || side[0] == side[2] && side[1] != side[2]){
                System.out.println("Isosceles");
                continue;
            }

            if(side[0] != side[1] && side[1] != side[2] && side[0] != side[2]){
                System.out.println("Scalene");
            }
        }



    }


}