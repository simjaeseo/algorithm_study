import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int[] numbers = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        generateCombinations(0,  0,0);
        System.out.println(set.size());
    }

    private static void generateCombinations(int startIndex, int count, int sum) {
        if (count == N) {
            set.add(sum);
            return;
        }

        for (int i = startIndex; i < 4; i++) {
            generateCombinations(i,count + 1,  sum + numbers[i]);
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}