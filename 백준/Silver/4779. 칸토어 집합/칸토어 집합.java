import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, size, numbers[], inputs[];
    static String s;
    static char[] charArray;
//    static ArrayList<Integer> l = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void print() {
        System.out.println(charArray);
    }


    private static void progress() {
        size = (int) Math.pow(3, N);
        charArray = new char[size];

        for (int i = 0; i < size; i++) {
            charArray[i] = '-';
        }

        recursion(size, 0);
    }

    private static void recursion(int size, int start) {
        if (size <= 1) return;

        int newSize = size / 3;

        for (int i = start + newSize; i < start + newSize * 2; i++) {
            charArray[i] = ' ';
        }

        recursion(newSize, start); // 3등분한 문자열에서 첫번째 부분
        recursion(newSize, start + newSize * 2); // 3등분한 문자열의 세번째 부분
    }

    private static void init() throws IOException {
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            N = Integer.parseInt(s);

            progress();
            print();

        }

    }


}
