import java.util.*;
import java.io.*;

public class Main {
    static int numbers[], B, max = -1;
    static boolean isSelected[];
    static char[] A;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        permutation(0);

        System.out.println(max);
    }

    private static void permutation(int numberOfDraw) {
        if(numberOfDraw == A.length){
            if (numbers[0] == 0) return; // 선행 0 처리
            for(int num : numbers){
                sb.append(num);
            }
            int num = Integer.parseInt(new String(sb.toString()));
            if(num < B && num > max){
                max = num;
            }
            sb.setLength(0);
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if(isSelected[i])   continue;

            numbers[numberOfDraw] = A[i] - '0';
            isSelected[i] = true;
            permutation(numberOfDraw+1);
            isSelected[i] = false;
        }
    }

    private static void init() throws IOException {

        st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());

        numbers = new int[A.length];
        isSelected = new boolean[A.length];

//        for (int i = 0; i < A.length; i++) {
//            numbers[i] = A[i];
//        }
    }
}