import java.util.*;
import java.io.*;

public class Main {
    static int N, max, previousSum, numbers[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        // 첫 번째 요소로 초기화
        previousSum = numbers[0];
        max = numbers[0];

        // 두 번째 요소부터 순회
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];

            // previousSum을 현재 숫자와 현재 숫자 + previousSum 중 큰 값으로 갱신
            previousSum = Math.max(number, previousSum + number);
            // max를 max와 previousSum 중 큰 값으로 갱신
            max = Math.max(max, previousSum);
        }

        System.out.println(max);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];

        int index = 0;
        while (st.hasMoreTokens()) {
            numbers[index++] = Integer.parseInt(st.nextToken());
        }
    }
}