import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, T, x, d, k, map[][], rotationStartIndex;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        print();
    }

    private static void print() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    sum += map[i][j];
                }
            }
        }
        System.out.println(sum);

    }

    private static void solve() throws IOException {

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            rotationStartIndex = x - 1;

            for (int j = rotationStartIndex; j < N; j += x) {
                // 번호가 x의 배수인 원판을 d 방향으로 k칸 회전시키기
                rotation(map[j]);
            }

            // 원판에 수가 남아있는지 체크
            if(isExistedNumber()){
                // 회전 후, 인접하면서 같은 수 지우기 (가로 세로 각각 인접 체크)
                boolean isInjub = checkInjub();

                //원판 적힌 수의 평균 구하고 평균보다 큰 수에서 +1, 작은수는 +1
                if(!isInjub) findAverageAndPlusMinus();
            }else{
                return;
            }


        }
        //원판 적인 수의 합 구하기
    }

    private static boolean isExistedNumber() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    return true;
                }
            }
        }
        return false;
    }

    private static void findAverageAndPlusMinus() {
        float sum = 0;
        float count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    sum += map[i][j];
                    count++;
                }
            }
        }

        float average = sum / count;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    if((float) map[i][j] > average){
                        map[i][j]--;
                    }else if((float) map[i][j] < average){
                        map[i][j]++;
                    }
                }
            }
        }
    }

    private static boolean checkInjub() {
        boolean isInjub = false;
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        // 행들 먼저 인접 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    int leftIndex = (j - 1 + M) % M;
                    int rightIndex = (j+1) % M;
                    boolean flag = false;

                    if(map[i][j] == map[i][leftIndex]){
                        newMap[i][leftIndex] = 0;
                        isInjub = true;
                        flag = true;
                    }
                    if(map[i][j] == map[i][rightIndex]){
                        newMap[i][rightIndex] = 0;
                        isInjub = true;
                        flag = true;
                    }
                    if(flag) newMap[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[j][i] != 0){
                    if(j == 0){
                        if(map[j][i] == map[j+1][i]){
                            newMap[j][i] = 0;
                            newMap[j+1][i] = 0;
                            isInjub = true;
                        }
                    }else if( j == N-1){
                        if(map[j][i] == map[j-1][i]){
                            newMap[j][i] = 0;
                            newMap[j-1][i] = 0;
                            isInjub = true;
                        }
                    }else{
                        boolean flag = false;
                        if(map[j][i] == map[j+1][i]){
                            newMap[j+1][i] = 0;
                            isInjub = true;
                            flag = true;
                        }
                        if(map[j][i] == map[j-1][i]){
                            newMap[j-1][i] = 0;
                            isInjub = true;
                            flag = true;
                        }
                        if(flag) newMap[j][i] = 0;
                    }
                }
            }
        }
        map = newMap;
        return isInjub;
    }

    private static void rotation(int[] circlePan) {
        int temp = 0;

        if(d == 0){
            // 시계방향
            for (int number = 0; number < k; number++) {
                temp = circlePan[M-1];

                for (int i = M-1; i > 0 ; i--) {
                    circlePan[i] = circlePan[i-1];
                }

                circlePan[0] = temp;
            }
        }else{
            // 반시계방향
            for (int number = 0; number < k; number++) {
                temp = circlePan[0];

                for (int i = 0; i < M - 1; i++) {
                    circlePan[i] = circlePan[i+1];
                }

                circlePan[M-1] = temp;
            }
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}