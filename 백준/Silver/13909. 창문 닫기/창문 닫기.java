import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    static LinkedList<Integer> enter = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        System.out.println(count);

    }
}