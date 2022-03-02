package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M1 {
	static int N, M;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
//		input = new int[N];
//
//		for (int i = 1; i <= N; i++) {
//			input[i - 1] = i;
//		}

		permutation(0, 0);
	}

	static void permutation(int idx, int flag) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)	continue;
			numbers[idx] = i+1;
			permutation(idx + 1, flag | 1 << i);
		}
	}

}
