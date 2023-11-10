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

        changeBRule();

        System.out.println(sb.reverse());
    }

    private static void changeBRule() {
        int number = -1;

        while (true) {
            if(N/B >= B){
                number = N % B;

                if (number < 10) {
                    sb.append(number);
                } else {
                    sb.append(changeAlphabet(number));
                }

                N = N / B;

            }


            if (N / B < B ) {
                number = N % B;

                if (number < 10) {
                    sb.append(number);
                } else {
                    sb.append(changeAlphabet(number));
                }

                number = N / B;

                if(number != 0){
                    if (number < 10) {
                        sb.append(number);
                    } else {
                        sb.append(changeAlphabet(number));
                    }
                }
                break;
            }
        }
    }

    private static char changeAlphabet(int number) {
        return (char) (number - 10 + 'A');
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }


}