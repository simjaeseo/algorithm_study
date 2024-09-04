import java.util.Scanner;

public class Main {

    // 스위치 누르기 함수
    static void toggle(int[] bulbs, int index) {
        // 자신, 왼쪽, 오른쪽 전구의 상태를 바꾼다.
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < bulbs.length) {
                bulbs[i] = 1 - bulbs[i];
            }
        }
    }

    // 최소 조작 횟수 계산 함수
    static int getMinSwitches(int[] initial, int[] target, boolean firstSwitchPressed) {
        int n = initial.length;
        int[] bulbs = initial.clone();
        int switchCount = 0;

        // 첫 번째 스위치를 누르는 경우 처리
        if (firstSwitchPressed) {
            toggle(bulbs, 0);
            switchCount++;
        }

        // 두 번째 전구부터 처리
        for (int i = 1; i < n; i++) {
            // 이전 전구가 목표 상태와 다르면 스위치 눌러야 함
            if (bulbs[i - 1] != target[i - 1]) {
                toggle(bulbs, i);
                switchCount++;
            }
        }

        // 마지막 전구 상태가 목표 상태와 일치하는지 확인
        if (bulbs[n - 1] != target[n - 1]) {
            return Integer.MAX_VALUE; // 불가능한 경우
        }

        return switchCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String initialStr = sc.next();
        String targetStr = sc.next();

        int[] initial = new int[n];
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            initial[i] = initialStr.charAt(i) - '0';
            target[i] = targetStr.charAt(i) - '0';
        }

        // 첫 번째 스위치를 누르지 않은 경우와 누른 경우를 각각 계산
        int result1 = getMinSwitches(initial, target, false);
        int result2 = getMinSwitches(initial, target, true);

        // 최소 조작 횟수 출력
        int result = Math.min(result1, result2);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1); // 불가능한 경우
        } else {
            System.out.println(result);
        }

        sc.close();
    }
}