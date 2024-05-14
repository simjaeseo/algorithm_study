import java.util.*;
import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE, sum, numbers[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        sum = numbers[0];
        max = numbers[0];

        int number = 0;

        for (int i = 1; i < numbers.length; i++) {
            number = numbers[i];

            sum = Math.max(number, sum + number);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }


    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        numbers = new int[N];

        int number = 0;
        int index = 0;
        while(st.hasMoreTokens()){
            number = Integer.parseInt(st.nextToken());

            numbers[index++] = number;
        }

    }

}