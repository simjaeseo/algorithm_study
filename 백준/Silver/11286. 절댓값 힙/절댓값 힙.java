import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
    }

    public static void init() throws IOException {
        Comparator<Integer> c = new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2){
                BigInteger bi1 = BigInteger.valueOf(o1);
                BigInteger bi2 = BigInteger.valueOf(o2);


                if(  Math.abs(o1) != Math.abs(o2)){
                    return bi1.abs().compareTo(bi2.abs());
                }
                return bi1.compareTo(bi2);

            }
        };


        PriorityQueue<Integer> pq = new PriorityQueue<>(c);



        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                int n = pq.isEmpty() ? 0 : pq.poll();
                sb.append(n).append('\n');
            }else{
                pq.add(x);
            }
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.print(sb);
    }
}