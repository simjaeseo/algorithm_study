import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K, weightLimit[];
    static long total;
    static Jewel jewels[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(jewels, new Comparator<Jewel>(){
            @Override
            public int compare(Jewel o1, Jewel o2){
                return o1.weight - o2.weight;
            }
        });

        Arrays.sort(weightLimit);

        int idx = 0;
        for (int i = 0; i < K; i++) {

            while(idx < N && jewels[idx].weight <= weightLimit[i]){
                pq.add(jewels[idx].value);
                idx++;
            }

            if(!pq.isEmpty()) total += pq.poll();
        }

        System.out.println(total);
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        weightLimit = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            jewels[i] = new Jewel();
            jewels[i].weight = Integer.parseInt(st.nextToken());
            jewels[i].value = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            weightLimit[i] = Integer.parseInt(br.readLine());
        }
    }

    public static class Jewel{
        public int weight, value;
    }
}
