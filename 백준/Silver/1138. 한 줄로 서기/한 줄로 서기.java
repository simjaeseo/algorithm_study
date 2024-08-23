import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, heights[], lines[];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        for (int i = 0; i < N; i++) {
            lines[i] = -1; // 아직 줄 안섰다는 의미의 초기화
        }


        for (int i = 0; i < N; i++) {
            int numberOfFront = heights[i];
            int positionIndex = 0;

            for (int j = 0; j < N; j++) {
                if(lines[j] == -1){

                    if(numberOfFront == 0){
                        lines[positionIndex] = i+1;
                        break;
                    }

                    numberOfFront--;
                }
                positionIndex++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(lines[i] + " ");
        }

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        lines = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
    }

}