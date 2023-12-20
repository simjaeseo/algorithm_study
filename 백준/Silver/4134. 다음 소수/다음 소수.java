import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static ArrayList<Integer> originTrees = new ArrayList<>();
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

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());



            while(true) {
                boolean isPrimeNumber = true;
                for (int j = 2; j <= Math.sqrt(number); j++) {
                    if (number % j == 0) {
                        isPrimeNumber = false;
                        break;
                    }
                }
                if (isPrimeNumber) {
                    if(number == 1 || number == 0){
                        number = 2;
                    }
                    System.out.println(number);
                    break;
                }
                number++;
            }

        }


    }


}