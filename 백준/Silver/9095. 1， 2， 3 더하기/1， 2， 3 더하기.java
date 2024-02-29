import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, t,count;
    static Integer dp[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void progress() {

        recursion(0);
        System.out.println(count);

    }

    private static void recursion(int sum) {
        if(sum == n){
            count++;
            return;
        }

        if(sum+1 <= n) recursion(sum+1);
        if(sum+2 <= n) recursion(sum+2);
        if(sum+3 <= n) recursion(sum+3);
    }


    private static void init() throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            count=0;
            progress();
        }
    }

}