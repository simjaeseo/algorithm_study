import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static List<Integer> positive = new ArrayList<>();
    static List<Integer> negative = new ArrayList<>();


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        int totalDistance = 0;

        // 오름차순 정렬 (양수는 큰 순서로, 음수는 작은 순서로 처리해야 하므로)
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        // 양수 처리: 큰 위치부터 처리
        for (int i = 0; i < positive.size(); i+=M) {
            totalDistance += positive.get(i) * 2;
        }

        // 음수 처리: 작은 위치부터 처리
        for (int i = 0; i < negative.size(); i+=M) {
            totalDistance += Math.abs(negative.get(i)) * 2;
        }

        int maxDistance = 0;
        // 가장 먼 지점은 편도만 고려
        if(!positive.isEmpty() && !negative.isEmpty()){
            maxDistance = Math.max(positive.get(0), Math.abs(negative.get(0)));
        }else if(!positive.isEmpty()){
            maxDistance = positive.get(0);
        }else if(!negative.isEmpty()){
            maxDistance = Math.abs(negative.get(0));
        }

        System.out.println(totalDistance - maxDistance);
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int position = Integer.parseInt(st.nextToken());

            if(position > 0) positive.add(position);
            else negative.add(position);
        }
    }

}


/*
6 2
-1 3 4 5 6 11

-1
3 4
5 6
11

2
6
10
11

21
23 32

7 2
-39 -37 -29 -28 -6 2 11

2 11
-6
-29 -28
-39 -37

22
12
58
39

34
97
131

1. 음수 양수중, 가장 긴 거리가 짧은쪽부터 다녀오기
2. 개수가 M이랑 딱 떨어지지 않는경우
8 3
-45 -26 -18 -9 -4 22 40 50

-4 -9 -18 -26 -45
8 18 36 58 90
22 40 50

-9 -4
-45 -26 -18
22 40 50

18
90
50

158


 */