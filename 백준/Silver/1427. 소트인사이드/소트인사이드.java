import java.io.*;
import java.util.*;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        init();

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
//        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        String input = String.valueOf(N);

        int[] countingArray = new int[10];

        for (int i = 0; i < input.length(); i++) {
            countingArray[input.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = countingArray.length - 1; i >= 0 ; i--) {

            if(countingArray[i] == 0)   continue;

            for (int j = 0; j < countingArray[i]; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb);

    }

}