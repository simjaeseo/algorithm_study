import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int T, N, rank[][];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

    }


    private static void solve() {

        Arrays.sort(rank, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int maxRank = rank[0][1];
        int count = 1;

        for (int i = 1; i < N; i++) {

            if(maxRank > rank[i][1]){
                count++;
                maxRank = rank[i][1];
            }
        }

        System.out.println(count);


//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(rank[i]));
//        }

    }


    private static void init() throws IOException {
        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            rank = new int[N][2];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }

            solve();
        }
    }

}

/*
1 4
2 3
3 2
4 1
5 5
 */