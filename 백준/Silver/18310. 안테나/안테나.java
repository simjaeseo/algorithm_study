import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, houses[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {


        Arrays.sort(houses);

        if(houses.length % 2 != 0){
            System.out.println(houses[houses.length/2]);
        }else{
            System.out.println(houses[houses.length/2 - 1]);
        }

        /*
        안테나로부터 모든 집까지의 거리의 총 합이 최소.

        - 집 위치를 정렬해야함.
        - 집 위치 중 가장 가운데에 설치해야함.

         */

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        houses = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }
    }
}
