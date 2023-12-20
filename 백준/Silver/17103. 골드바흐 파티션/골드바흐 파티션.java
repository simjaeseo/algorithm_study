import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    //    static Set<String> originTreesSet = new TreeSet<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, Integer> map2 = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        boolean[] primeArray = eratosthenes();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            int count = 0;

            for (int j = 2; j <= number / 2; j++) {
                if(!primeArray[j] && !primeArray[number - j])   count++;
            }
//            https://sehyeok.tistory.com/175
//            https://st-lab.tistory.com/91
            System.out.println(count);
        }

    }

    private static boolean[] eratosthenes() {
        boolean[] primeArray = new boolean[1000001];
        primeArray[0] = primeArray[1] = true;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (primeArray[i]) continue;

            for (int j = i + i; j < 1000001; j += i) {
                primeArray[j] = true;
            }
        }

        return primeArray;
    }


}