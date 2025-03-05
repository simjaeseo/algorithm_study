import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, lectures[][];
    static List<Integer> endTimes = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {


        Arrays.sort(lectures, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]) return o1[2] - o2[2];

                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            method(lectures[i][1], lectures[i][2]);
        }

        System.out.println(endTimes.size());
    }

    private static void method(int startTime, int endTime) {

        boolean flag = false;
        for (int i = 0; i < endTimes.size(); i++) {
            if(endTimes.get(i) <= startTime){
                endTimes.set(i, endTime);
                flag = true;
                break;
            }
        }

        if(!flag) endTimes.add(endTime);

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        lectures = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
            lectures[i][2] = Integer.parseInt(st.nextToken());
        }


    }
}