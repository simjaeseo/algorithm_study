import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int[] array = new int[N + 1];

        getPrime(array);

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if(array[i] != 0){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    private static void getPrime(int[] array) {
        for (int i = 2; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 2; i < array.length; i++) {
            if(array[i] == 0)   continue;

            for (int j = i+i; j < array.length; j += i) {
                array[j] = 0;
            }
        }

    }
}