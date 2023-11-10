import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        printStar();

        System.out.print(sb);

    }

    private static void printStar() {
        int starNumber = 0;
        int spaceNumber = 0;

        for (int i = 1; i <= N; i++) {
            starNumber = i * 2 - 1;
            spaceNumber = N - (starNumber/2 + 1);

            for (int j = 0; j < spaceNumber; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < starNumber; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        for (int i = N-1; i >= 0; i--) {
            starNumber = i * 2 - 1;
            spaceNumber = N - (starNumber/2 + 1);

            for (int j = 0; j < spaceNumber; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < starNumber; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

    }

}