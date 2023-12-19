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

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long C = Integer.parseInt(st.nextToken());
        long D = Integer.parseInt(st.nextToken());

        long bunja = 0;
        long bunmo = 0;

        // 분모가 같은 경우
        if (B == D) {
            bunmo = B;
            bunja = A + C;
        }else{
            bunmo = B * D;
            bunja = A * D + C * B;
        }

        long[] result = yagbun(bunja, bunmo);

        System.out.println(result[0] + " " + result[1]);


    }

    private static long[] yagbun(long bunja, long bunmo) {

        long maxNumber = Math.max(bunja,bunmo);
        long minNumber = Math.min(bunja,bunmo);

        for (long i = 2; i <= minNumber; i++) {

            while(minNumber % i == 0 && maxNumber % i == 0){
                bunmo /= i;
                bunja /= i;

                 maxNumber = Math.max(bunja,bunmo);
                 minNumber = Math.min(bunja,bunmo);
            }


        }


        return new long[] { bunja, bunmo};

    }


}