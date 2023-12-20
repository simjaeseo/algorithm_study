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
            int position = Integer.parseInt(br.readLine());

            originTrees.add(position);
        }

        int distance = 0;
        int gcd = 0;

        for (int i = 0; i < originTrees.size() - 1; i++) {
            distance = originTrees.get(i+1) - originTrees.get(i);

            gcd = euclidGCD(distance, gcd);
        }
        System.out.println((originTrees.get(originTrees.size()-1) - originTrees.get(0)) / gcd + 1 - originTrees.size() );



    }

    private static int euclidGCD(int A, int B) {
        if(B == 0){
            return A;
        }
        return euclidGCD(B, A % B);
    }


}