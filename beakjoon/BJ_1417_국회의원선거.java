package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1417_국회의원선거 {
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] candidate = new int[N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			candidate[i] =  Integer.parseInt(br.readLine());
			max = Math.max(max, candidate[i]);
		}
		
		while(!check(candidate)) {
			maesu(candidate);
			cnt++;
		}
		System.out.println(cnt);

	}

	private static void maesu(int[] candidate) {
		int maxCheck = 0;
		// 먼저, max 값과 같은 수가 있는지 탐색
		for (int i = 1; i < candidate.length; i++) {
			//max값과 같은 값이 있다면
			if(max == candidate[i]) {
				// 다솜이표 1개 증가
				candidate[0]++;
				// 해당 후보 표 1개 감소
				candidate[i]--;
				return;
			}
			// 위의 코드로 인해 다솜 제외 후보의 표가 max보다 작아질 수 있으니 현재 기준 최대 max값을 maxCheck에 저장
			maxCheck = Math.max(maxCheck, candidate[i]);
		}
		// max값을 재설정 하고 재귀형태로 다시 반복
		max = maxCheck;
		maesu(candidate);
	}

	private static boolean check(int[] candidate) {
		for (int i = 1; i < candidate.length; i++) {
			if(candidate[0] <= candidate[i] )	return false;
		}
		return true;
	}

}
