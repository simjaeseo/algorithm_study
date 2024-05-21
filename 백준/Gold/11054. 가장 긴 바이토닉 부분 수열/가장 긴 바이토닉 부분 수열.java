import java.util.*;
import java.io.*;

public class Main {
    static int N, maxLength = 0, numbers[];
    static Integer increaseDP[], decreaseDP[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < i; j++) {
                if(numbers[j] < numbers[i] && increaseDP[j] + 1 > increaseDP[i]) increaseDP[i] = increaseDP[j] + 1;
            }
        }

        for (int i = N-1; i >= 0; i--) {

            for (int j = N-1; j > i; j--) {
                if(numbers[j] < numbers[i] && decreaseDP[j] + 1 > decreaseDP[i]) decreaseDP[i] = decreaseDP[j] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            maxLength = Math.max(increaseDP[i] + decreaseDP[i], maxLength);
        }

        System.out.println(maxLength - 1);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        increaseDP = new Integer[N];
        decreaseDP = new Integer[N];
        numbers = new int[N];

        int index = 0;
        while(st.hasMoreTokens()){
            numbers[index++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            increaseDP[i] = 1;
            decreaseDP[i] = 1;
        }
        
    }
}