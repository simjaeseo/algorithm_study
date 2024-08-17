import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

    }


    private static void init() throws IOException {
        char[] numbers = br.readLine().toCharArray();

        int sum = 0;
        boolean isExistedZero = false;

        for(char number : numbers){
            sum += number - '0';
            if(number - '0' == 0) isExistedZero = true;
        }

        if(!isExistedZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(numbers);
        System.out.println(new StringBuilder(new String(numbers)).reverse());






    }

}
