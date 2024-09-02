import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static long numbers[] , sum, previousSum;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        if(N == 1){
            System.out.println(0);
            return;
        }

        int number1 = 0;
        int number2 = 0;
        int sum = 0;

        while(pq.size() > 1){
            number1 = pq.poll();
            number2 = pq.poll();

            sum += number1 + number2;

            pq.add(number1 + number2);
        }


        System.out.println(sum);
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
    }

}
