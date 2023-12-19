import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    static Set<String> set2 = new TreeSet<>(Collections.reverseOrder());
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> map2 = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int bunja = 0;
        int bunmo = 0;

        bunmo = B * D;
        bunja = A * D + C * B;

        int a = Math.max(bunja, bunmo);
        int b = Math.min(bunja, bunmo);

        int gcd = euclidGCD(a, b);

        System.out.println(bunja/gcd + " " + bunmo/gcd);


    }

    private static int euclidGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return euclidGCD(b, a%b);
    }


}