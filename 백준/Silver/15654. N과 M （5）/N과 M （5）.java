import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] isSelected;
    static int[] inputNumbers, pickedNumbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N];
        inputNumbers = new int[N];
        pickedNumbers = new int[M];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            inputNumbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNumbers);

        permutation(0);
    }

    static public void permutation(int drawOfNumber) {
        if (drawOfNumber == M) {
//            for (int i = 0; i < M; i++) {
//                System.out.print(pickedNumbers[i] + " ");
//            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            sb.append(inputNumbers[i]);
            sb.append(" ");
//            pickedNumbers[drawOfNumber] = inputNumbers[i];
            permutation(drawOfNumber + 1);
            sb.setLength(sb.length() - String.valueOf(inputNumbers[i]).length() - 1);
            isSelected[i] = false;

        }
    }
}