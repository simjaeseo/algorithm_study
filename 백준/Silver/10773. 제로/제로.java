import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Stack<Integer> s = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
//        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                s.pop();
            } else {
                s.add(number);
            }
        }

        int sum = 0;
        for(int number : s){
            sum += number;
        }
        System.out.println(sum);

    }
}