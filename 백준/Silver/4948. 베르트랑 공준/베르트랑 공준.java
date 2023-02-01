import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int[] arr = new int[2 * n + 1];

            sb.append(getPrime(arr) + "\n");
        }
        System.out.println(sb);
    }

    private static int getPrime(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < arr.length; i++) {
            for (int j = i + i; j < arr.length; j += i) {
                if (arr[j] == 0) continue;

                arr[j] = 0;
            }
        }

        int primeCount = 0;
        for (int i = n+1; i < arr.length; i++) {
            if (arr[i] != 0) primeCount++;
        }

        return primeCount;
    }
}