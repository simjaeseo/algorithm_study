package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] permutation = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}

		int increaseCnt = 1;
		int increaseCntMax = 1;
		int decreaseCnt = 1;
		int decreaseCntMax = 1;
		int previousNum = permutation[0];
		for (int i = 1; i < N; i++) {
			if(permutation[i] >= previousNum) {
				increaseCnt++;
			}else {
				increaseCnt = 1;
			}
			previousNum = permutation[i];
			increaseCntMax = Math.max(increaseCnt, increaseCntMax);
			if(i == N-1 && increaseCntMax == 1)	increaseCntMax = increaseCnt;
		}
		
		previousNum = permutation[0];
		for (int i = 1; i < N; i++) {
			if(permutation[i] <= previousNum) {
				decreaseCnt++;
			}else {
				decreaseCnt = 1;
			}
			decreaseCntMax = Math.max(decreaseCnt, decreaseCntMax);
			previousNum = permutation[i];
			if(i == N-1 && decreaseCntMax == 1)	decreaseCntMax = decreaseCnt;
		}
		int result = Math.max(increaseCntMax, decreaseCntMax);
		if(permutation.length == 1)	result = 1;
		System.out.println(result);

	}

}
