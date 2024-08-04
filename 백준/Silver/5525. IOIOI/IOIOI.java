import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, countPn;
    static String s;
    static StringBuilder sb = new StringBuilder("I");
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        int count = 0; // IOI 패턴의 개수를 셀 변수
        int result = 0; // 결과값을 저장할 변수
        int i = 1; // 반복문을 위한 인덱스 변수

        // 문자열 S를 순회하면서 IOI 패턴을 찾음
        while (i < M - 1) {
            // 현재 위치에서 IOI 패턴을 찾으면
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                count++; // IOI 패턴 카운트 증가
                // 패턴이 N번 반복되는 경우 결과값 증가
                if (count == N) {
                    result++;
                    count--; // 중복 카운팅을 피하기 위해 count 감소
                }
                i += 2; // IOI 패턴을 찾은 경우 인덱스를 2 증가시킴
            } else {
                count = 0; // 패턴이 끊긴 경우 count를 초기화
                i++; // 인덱스 1 증가
            }
        }

        System.out.println(result);
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        s = br.readLine();
    }

}