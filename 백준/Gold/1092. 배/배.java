import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, crain[], boxes[], numberOfBoxesRemaining;
    static boolean isSelectedBoxes[];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        int startIndex = 0;
        int time = 0;
        int boxIndex = 0;

        Arrays.sort(crain);
        Arrays.sort(boxes);

        while (true) {
            if(numberOfBoxesRemaining == 0) {
                System.out.println(time);
                break;
            }

            if(startIndex >= N) {
                System.out.println(-1);
                break;
            }

            for (int i = startIndex; i < crain.length; i++) {
                if(numberOfBoxesRemaining == 0) break;
                if(startIndex >= N) break;

                boolean isCarry = false;
                for (int j = M-1; j >= 0; j--) {

                    // 크레인이 들 수 있는 무게이면서, 아직 안 옮긴 박스라면?
                    if(crain[i] >= boxes[j] && !isSelectedBoxes[j]){
                        isSelectedBoxes[j] = true;
                        numberOfBoxesRemaining--;
                        isCarry = true;
                        break;
                    }

                }
                // i번째 크레인이 들 수 있는 박스가 없다면? 다음 시간에서는 i번째가 들 수 있는 박스가 아예 없다는 의미이니, 시작 인덱스를 +1 해줘야 최적화됨
                if(!isCarry) startIndex++;

            }

            time++;
        }
    }

/*
3
5 6 10
11
6 6 6 6 6 8 8 8 9 9 9

 */
    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        crain = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        boxes = new int[M];
        isSelectedBoxes = new boolean[M];
        numberOfBoxesRemaining = M;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
    }

}