import java.io.*;
import java.util.*;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        init();

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
//        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        char[] inputs = String.valueOf(N).toCharArray();

        Character[] numbers = new Character[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = inputs[i];
        }

        Arrays.sort(numbers, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(char number : numbers){
            sb.append(number);
        }

        System.out.println(sb);
    }

}