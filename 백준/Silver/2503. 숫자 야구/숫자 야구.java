import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());

        int[][] minhyukQuestions = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int j = 0;

            minhyukQuestions[i][j++] = Integer.parseInt(st.nextToken());
            minhyukQuestions[i][j++] = Integer.parseInt(st.nextToken());
            minhyukQuestions[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 123; i <= 987; i++) {

            if(searchNumber(minhyukQuestions, i)){
                answer++;
            }
        }
        System.out.println(answer);

    }

    private static boolean searchNumber(int[][] minhyukQuestions, int number) {

        if (!isValidNumber(number)) {
            return false;
        }

        // 0이랑 중복되는 수 있는지는 다 체크 된 상태

        for (int i = 0; i < n; i++) {
            if(!isCandidate(minhyukQuestions[i], number)){
                return false;
            }

        }
        return true;
    }


    private static boolean isValidNumber(int number) {
        String youngsuNumber = String.valueOf(number);

        char[] youngsuNumbers = youngsuNumber.toCharArray();

        for (int i = 0; i < 3; i++) {
            if(youngsuNumbers[i] == '0'){
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (youngsuNumbers[i] == youngsuNumbers[j]) {
                    return false;
                }
            }
        }

        return true;
    }



    private static boolean isCandidate(int[] minhyukQuestion, int number) {
        char[] youngsuNumbers = String.valueOf(number).toCharArray();
        char[] questionNumbers = String.valueOf(minhyukQuestion[0]).toCharArray();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(youngsuNumbers[i] == questionNumbers[j] && i == j){
                    strike++;
                }else if(youngsuNumbers[i] == questionNumbers[j] && i != j){
                    ball++;
                }
            }
        }

        if(strike == minhyukQuestion[1] && ball == minhyukQuestion[2]){
            return true;
        }

        return false;

    }



}