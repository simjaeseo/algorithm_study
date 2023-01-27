import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        if (progress(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static boolean progress(String T) {

        if (S.length() == T.length()) {
            if (S.equals(T)) {
                return true;
            } else {
                return false;
            }
        }

        if (T.charAt(T.length() - 1) == 'A') {
            if (progress(T.substring(0, T.length() - 1))) {
                return true;
            }
        }

        if (T.charAt(0) == 'B') {
            StringBuilder reverse = new StringBuilder();
            reverse.append(T.substring(1, T.length()));

            if (progress(reverse.reverse().toString())) {
                return true;
            }

        }
        return false;
    }
}