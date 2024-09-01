import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static Integer cranes[];
    static List<Integer> boxes = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        // 크레인과 박스를 내림차순으로 정렬
        Arrays.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        // 가장 무거운 박스를 들 수 있는 크레인이 없으면 불가능
        if (boxes.get(0) > cranes[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        // 모든 박스를 옮길 때까지 반복
        while (!boxes.isEmpty()) {
            int boxIndex = 0, craneIndex = 0;

            while(craneIndex < N){
                if(boxIndex == boxes.size())    break;
                else if(cranes[craneIndex] >= boxes.get(boxIndex)){
                    boxes.remove(boxIndex);
                    craneIndex++;
                }else{
                    boxIndex++;
                }
            }
            time++;
        }

        System.out.println(time);
    }

    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        cranes = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
    }
}