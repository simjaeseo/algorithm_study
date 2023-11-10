import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N,sum;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();


    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

//        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());

            returnChange(number);
        }
    }

    private static void returnChange(int number) {

        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        while(number != 0){
            if(number >= 25){
                quarter = number / 25;
                number = number - (25 * quarter);
            }else if(number>=10){
                dime = number / 10;
                number = number - (10 * dime);
            }else if(number >= 5){
                nickel = number / 5;
                number = number - (5 * nickel);
            }else{
                penny = number / 1;
                number = 0;
            }
        }


        System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
    }


}