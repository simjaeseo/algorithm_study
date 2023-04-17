import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int numbers[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         numbers = new int[M];

        permutation(0);
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);

    }

    private static void permutation(int numberOfDraw) {
        if( numberOfDraw == M){
            for(int n : numbers){
                sb.append(n).append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            numbers[numberOfDraw] = i;
            permutation(numberOfDraw+1);
        }
    }
}