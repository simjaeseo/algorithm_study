import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, minimumPakage = Integer.MAX_VALUE, minimumLine = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minimumPakage = Math.min(minimumPakage, Integer.parseInt(st.nextToken()));
            minimumLine = Math.min(minimumLine, Integer.parseInt(st.nextToken()));
        }

        int sum = 0;


        if( N < 6){

            if(minimumPakage < minimumLine * N) sum = minimumPakage;
            else sum = minimumLine * N;

        }else{
            if(minimumPakage < minimumLine * 6){
                sum += (N / 6) * minimumPakage;

                if(minimumPakage < (N % 6) * minimumLine) sum += minimumPakage;
                else sum += (N % 6) * minimumLine;

            }else{
                sum = minimumLine * N;
            }

        }

        System.out.println(sum);
    }

}