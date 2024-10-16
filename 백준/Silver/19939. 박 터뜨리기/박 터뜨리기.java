import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        int minimum = minimum(K);

        if(N < minimum) System.out.println(-1);
        else{
            int buckets[] = new int[K];

            for (int i = 1; i <= K; i++) {
                buckets[i-1] = i;
            }

            if( (N-minimum) % K > 0){
                System.out.println(buckets[K-1] - buckets[0] + 1);
            }else{
                System.out.println(buckets[K-1] - buckets[0]);
            }

        }

    }

    public static int minimum(int K){
        int sum = 0;

        for (int i = 1; i <= K; i++) {
            sum += i;
        }

        return sum;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }


}


/*



2567

24 25 26 2


        /*

20 21 22 23
4

3456 18 5
4567 22 5
5678 26

20 21 22 23 24
5

12345 14
23456 19
34567


3456 18
4567 22
5678 26
         */







