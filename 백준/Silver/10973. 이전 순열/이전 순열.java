import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, numbers[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }

    private static void solve() {
        // 2314 -> 2143 -< 2314
        // 53421 -> 54123
        // 54123 -> 54132

        // 1. 뒤에서부터 탐색하면서 바닥 index 찾기
        int bottomIndex = findBottomIndex();

        if(bottomIndex == 0){
            System.out.println(-1);
            return;
        }

        // 2. 뒤에서부터 bottomIndex까지 탐색하면서, numbers[bottomIndex - 1] 보다 작은 수 찾기
        int numberIndex = findNumberIndex(bottomIndex);

        swap(bottomIndex-1, numberIndex);

        int leftIndex = bottomIndex;
        int rightIndex = N-1;
        while(leftIndex < rightIndex){
            swap(leftIndex++, rightIndex--);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    private static void swap(int index1, int index2) {
        int temp = numbers[index1];

        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private static int findNumberIndex(int bottomIndex) {

        for (int i = N-1; i >= bottomIndex; i--) {
            if(numbers[bottomIndex-1] > numbers[i]) return i;
        }

        return 0;


    }

    private static int findBottomIndex() {

        for (int i = N-1; i > 0; i--) {
            if(numbers[i-1] > numbers[i])   return i;
        }
        return 0;

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

}