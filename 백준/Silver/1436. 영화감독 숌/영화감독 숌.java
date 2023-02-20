import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int devilNumber = 0;

        int[] devilNumberBeforeSix = {666, 1666, 2666, 3666, 4666, 5666};

        if (N <= 6) {
            System.out.println(devilNumberBeforeSix[N - 1]);
            return;
        }

        devilNumber = devilNumberBeforeSix[5]++;

        while (true) {
            if (count == N-5) {
                break;
            }

            if (isDevilNumber(devilNumber++)) {
                count++;
            }

        }

        System.out.println(--devilNumber);

    }

    private static boolean isDevilNumber(int devilNumber) {

        char[] devilNumberArray = String.valueOf(devilNumber).toCharArray();

        int count = 0;
        for (int i = 0; i < devilNumberArray.length - 2; i++) {

            if (devilNumberArray[i] == '6' && devilNumberArray[i + 1] == '6' && devilNumberArray[i + 2] == '6') {
                return true;
            }
        }

        return false;

    }
}