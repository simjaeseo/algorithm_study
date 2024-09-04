import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int[] inital, target;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        int result1 = getMinimumSwitch(false);
        int result2 = getMinimumSwitch(true);

        int result = Math.min(result1, result2);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

    }

    private static int getMinimumSwitch(boolean firstSwitchPressed) {
        int countSwitch = 0;
        int[] bulbs = new int[N];

        for (int i = 0; i < N; i++) {
            bulbs[i] = inital[i];
        }

        if(firstSwitchPressed){
            toggle(bulbs, 0);
            countSwitch++;
        }

        for (int i = 1; i < N; i++) {
            if(bulbs[i-1] != target[i-1]){
                toggle(bulbs, i);
                countSwitch++;
            }
        }

        if(bulbs[N-1] != target[N-1]) return Integer.MAX_VALUE;

        return countSwitch;

    }

    private static void toggle(int[] bulbs, int index) {
        for (int i = index - 1; i <= index + 1; i++) {
            if(i >= 0 && i < N){
                bulbs[i] = 1 - bulbs[i];
            }
        }
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        inital = new int[N];
        target = new int[N];

        char[] inputs = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            inital[i] = inputs[i] - '0';
        }

        inputs = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            target[i] = inputs[i] - '0';
        }

    }

}