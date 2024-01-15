import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static int n, k;
    private static ArrayList<Integer> l = new ArrayList<>();
    private static Map<Integer, Integer> m = new HashMap<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            k = 0;
            sb.append(isPalindrome(s)).append(' ').append(k+1).append('\n');

        }
        System.out.println(sb);

    }

    private static int isPalindrome(String s) {

        return recursion(s, 0, s.length() - 1);

    }

    private static int recursion(String s, int leftIndex, int rightIndex) {
        if(leftIndex >= rightIndex)  return 1;
        else if(s.charAt(leftIndex) != s.charAt(rightIndex))     return 0;
        else {
            k++;
            return recursion(s, leftIndex+1, rightIndex-1);
        }

    }

}