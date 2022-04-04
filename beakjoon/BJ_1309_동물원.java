package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1309_동물원 {
	static int N, cnt, moveR, moveC;
	static int[][] zoo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] D = new int[N + 1][3];

		D[1][0] = 1;
		D[1][1] = 1;
		D[1][2] = 1;
		for (int i = 2; i <= N; i++) {
			D[i][0] = (D[i - 1][0] + D[i - 1][1] + D[i - 1][2]) % 9901;
			D[i][1] = (D[i - 1][0] + D[i - 1][2]) % 9901;
			D[i][2] = (D[i - 1][0] + D[i - 1][1]) % 9901;
		}

		System.out.println((D[N][0] + D[N][1] + D[N][2]) % 9901);
	}

}
