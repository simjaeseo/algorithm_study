import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade, sum;
    static char[] input;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        readVerticalVoca();

        System.out.println(sb);
    }

    private static void readVerticalVoca() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {

                if(map[j][i] != ' '){
                    sb.append(map[j][i]);
                }
            }
        }



    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] inputCharArray = br.readLine().toCharArray();

            Arrays.fill(map[i], ' ');

            int index = 0;
            for(char c : inputCharArray){
                map[i][index++] = c;
            }
        }

    }


}