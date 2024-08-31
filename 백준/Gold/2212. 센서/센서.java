import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K, sensors[];
    static Set<Integer> set = new HashSet<>();
    static List<Integer> distances = new ArrayList<>();
    static List<Integer> cutPoint = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        // 센서들의 간격들을 List에 먼저 저장.
        for (int i = 0; i < sensors.length - 1; i++) {
            distances.add(sensors[i+1] - sensors[i]);
        }

        // 내림차순으로 정렬
        Collections.sort(distances, Collections.reverseOrder());

        // N-1개를 cutPoint 리스트에 저장
        for (int i = 0; i < Math.min(sensors.length - 1, K - 1); i++) {
            cutPoint.add(distances.get(i));
        }

        int result = 0;
        for (int i = 0; i < sensors.length-1; i++) {
            int distance = sensors[i+1] - sensors[i];

            if(cutPoint.contains(distance)){
                cutPoint.remove(new Integer(distance));
                continue;
            }

            result += distance;
        }

        System.out.println(result);


    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        sensors = new int[set.size()];

        int i = 0;
        for(int number : set){
            sensors[i++] = number;
        }
        Arrays.sort(sensors);

    }

}
/*
6
2
1 6 9 3 6 7
1 3 6 6 7 9
1 ~ 9


10
5
3 6 7 8 10 12 14 15 18 20
 3 1 1 2  2  2  1  3  2

3 3 2 2 2 2 1 1 1

3 3 2 2

3/ 6 7 8/ 10 12/ 14 15/ 18/ 20


10개를 5개가 커버
집중국 1개당 최대 2개까지 커버해야함


0   2     2     1    2
1 3 2 2 2

 1개당 4개 이하


17 -> 5개가 커버
3.4개

3 ~ 20

17




 */