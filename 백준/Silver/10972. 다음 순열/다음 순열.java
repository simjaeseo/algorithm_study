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
        //뒤에서부터 꼭대기 찾기
        int topIndex = findTopIndex();

        if(topIndex == 0){
            System.out.println(-1);
            return;
        }

        // 뒤에서부터 꼭대기까지 숫자 중 꼭대기 바로 앞 숫자보다 큰 숫자 찾기
        int numberIndex = findNumberIndex(topIndex);

        int temp = numbers[topIndex-1];

        numbers[topIndex-1] = numbers[numberIndex];
        numbers[numberIndex] = temp;


        topSort(topIndex);

        for (int i = 0; i < N; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    private static void topSort(int topIndex) {
        int left = topIndex;
        int right = N-1;


        while(left < right){
            swap(left++, right--);

        }
    }

    private static void swap(int topIndex, int numberIndex) {
        int temp = numbers[topIndex];

        numbers[topIndex] = numbers[numberIndex];
        numbers[numberIndex] = temp;
    }

    private static int findNumberIndex(int topIndex) {

        for (int i = N-1; i >= topIndex; i--) {
            if(numbers[topIndex - 1] < numbers[i]) return i;
        }
        return 0;
    }

    // 54321
    // 52143

    private static int findTopIndex() {

        for (int i = N-1; i > 0 ; i--) {
            if(numbers[i-1] < numbers[i]) return i;
        }

        return 0;



    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

}
/*
1234
1243
1324
1342
1423
1432
2134




 */