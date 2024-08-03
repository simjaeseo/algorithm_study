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

        //1. 뒤에서부터 탐색하면서, 꼭대기가 어디인지 인덱스 구하자.
        int topIndex = findTopIndex();

        // 꼭대기가 0이라는것은 맨 마지막 수열이라는 것.
        if(topIndex == 0){
            System.out.println(-1);
            return;
        }

        // 2. 뒤에서부터 꼭대기까지 탐색하면서, topIndex-1보다 큰 수를 찾기
        int numberIndex = findNumberIndexHigherThanTopNumber(topIndex);

        // 3. numbers[topIndex-1]과 numbers[numberIndex] swap
        swap(topIndex-1, numberIndex);

        // 4. 뒤에서부터 꼭대기사이의 값들 정렬
        int left = topIndex;
        int right = N-1;
        while(left < right){
            swap(left++, right--);
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

    private static int findNumberIndexHigherThanTopNumber(int topIndex) {

        for (int i = N-1; i >= topIndex; i--) {
            if(numbers[topIndex-1] < numbers[i])    return i;
        }

        return 0;
    }

    private static int findTopIndex() {

        for (int i = N-1; i > 0; i--) {
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