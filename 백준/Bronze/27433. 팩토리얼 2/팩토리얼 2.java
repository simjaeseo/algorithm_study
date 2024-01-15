import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static long n, k;
    private static ArrayList<Integer> l = new ArrayList<>();
    private static Map<Integer, Integer> m = new HashMap<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {

        n = Long.parseLong(br.readLine());

        System.out.println(factorial(n));
    }

    private static Long factorial(long n) {
        if(n <= 1){
            return 1l;
        }else{
            return n * factorial(n-1);
        }
    }
}