import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static String[] vocas;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        Integer[] alphabetWeights = new Integer[26];

        for (int i = 0; i < 26; i++) {
            alphabetWeights[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            String voca = vocas[i];

            for (int j = 0; j < voca.length(); j++) {
                alphabetWeights[voca.charAt(j) - 'A'] += (int) Math.pow(10, voca.length() - j - 1);
            }
        }

        Arrays.sort(alphabetWeights, Collections.reverseOrder());

        int sum = 0;
        int number = 9;

        for (int i = 0; i < 26; i++) {
            if(alphabetWeights[i] == 0) break;

            sum += number * alphabetWeights[i];
            number--;
        }


        System.out.println(sum);
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        vocas = new String[N];

        for (int i = 0; i < N; i++) {
            vocas[i] = br.readLine();
        }
    }

}