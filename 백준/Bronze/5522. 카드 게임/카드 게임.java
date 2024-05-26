import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[][], previousDPNumber;
    static String A, B;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
//        process();
    }

    private static void process() {



    }

    private static void init() throws IOException {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println(sum);
    }

}