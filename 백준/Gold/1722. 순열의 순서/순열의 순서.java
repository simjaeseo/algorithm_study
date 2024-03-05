import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, problemNumber, numbers[];
    static long factorial[], answer, k;
    static boolean isSelected[], flag = true;
    static LinkedList<Integer> answerList = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        progress();
    }

    private static void progress() {

    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
//        inputs = new int[N];
        numbers = new int[N + 1];
        isSelected = new boolean[N + 1];

        // 순열의 범위만큼 팩토리얼 미리 초기화 해놓기
        factorial = new long[21];
        factorial[0] = 1;
        for (int i = 1; i < 21; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());

        problemNumber = Integer.parseInt(st.nextToken());

        if (problemNumber == 1) {
            k = Long.parseLong(st.nextToken());

            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (isSelected[j]) continue;
                    if (k - factorial[(N-1)-i] > 0){
                        k -= factorial[(N-1)-i];
                    }else{
                        answerList.add(j);
                        isSelected[j] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < answerList.size(); i++) {
                sb.append(answerList.get(i)).append(' ');
            }
            System.out.print(sb);


        } else {
            int index = 0;

            while (st.hasMoreTokens()) {
                numbers[index++] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < numbers[i]; j++) {
                    if(!isSelected[j]){
                        answer += factorial[N-1-i];
                    }
                }
                isSelected[numbers[i]] = true;
            }

            System.out.print(answer+1l);
        }
    }

}