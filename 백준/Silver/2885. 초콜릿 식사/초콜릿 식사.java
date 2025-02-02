import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int K;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        int minimumSize = 1;
        int count = 0;

        while(minimumSize < K) minimumSize *= 2;

        System.out.print(minimumSize + " ");

        while(K > 0){
            if(K >= minimumSize){
                K -= minimumSize;
            }else{
                minimumSize /= 2;
                count++;
            }
        }

        System.out.println(count);
    }


    private static void init() throws IOException {
        K = Integer.parseInt(br.readLine());

    }
}