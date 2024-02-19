import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,T, dp[];
    static LinkedList<Character> l = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    //https://st-lab.tistory.com/148
    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
        int sum = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            int temp = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while(st2.hasMoreTokens()){
                temp += Integer.parseInt(st2.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }

    public static void init() throws IOException {

        st = new StringTokenizer(br.readLine(), "-");

    }
}