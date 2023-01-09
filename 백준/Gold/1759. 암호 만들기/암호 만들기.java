import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int L, C;
    public static char[] inputCharacters;
    public static char[] pickedCharacters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        inputCharacters = new char[C];
        pickedCharacters = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            inputCharacters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(inputCharacters);

        combination(0, 0);
    }

    public static void combination(int startIndex,int drawOfNumber) {


        if (drawOfNumber == L) {
            // 최소 한개의 모음, 최소 2개의 자음인지 확인
            if (isValid()) {
                System.out.println(pickedCharacters);
            }
            return;
        }

        for (int i = startIndex; i < C; i++) {
            pickedCharacters[drawOfNumber] = inputCharacters[i];
            combination(i+1, drawOfNumber + 1);
        }
    }

    private static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : pickedCharacters) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}