import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, numbers[], inputs[];
    static boolean isSelected[];

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[m];
        inputs = new int[n];
        isSelected = new boolean[n];

        for (int i = 1; i <= n; i++) {
            inputs[i-1]= i;
        }

        permutation(0);
        sb.delete(sb.length() - 1, sb.length());

        System.out.print(sb);
    }

    private static void permutation(int drawOfNumber) {
        if(drawOfNumber == m){
            for(int number : numbers){
                sb.append(number).append(' ');
            }

            sb.delete(sb.length() - 1, sb.length());
            sb.append('\n');

            return;
        }


        for (int i = 0; i < n; i++) {


            if(drawOfNumber == 0 || numbers[drawOfNumber-1] <= inputs[i]) {
                numbers[drawOfNumber] = inputs[i];
                permutation(drawOfNumber+1);
            }
        }
    }

}