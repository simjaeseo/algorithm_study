import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> bucket = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            bucket.add(i+1);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int order1 = Integer.parseInt(st.nextToken());
            int order2 = Integer.parseInt(st.nextToken());


            int leftIndex = order1-1;
            int rightIndex = order2-1;

            for (int j = 0; j < (order2 - order1+ 1) / 2; j++) {
                int num1 = bucket.get(leftIndex);
                int num2 = bucket.get(rightIndex);

                bucket.set(leftIndex++, num2);
                bucket.set(rightIndex--, num1);
            }

        }



        for (int i = 0; i < N; i++) {
            System.out.print(bucket.get(i) + " ");
        }
    }
}