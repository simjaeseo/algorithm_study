package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592_영식이와친구들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] circle = new int[N];
		int idx = 0;
		int cnt = 0;
		while (circle[idx % N] != M) {
			cnt++;
			circle[idx % N]++;
			if (circle[idx % N] == M)
				break;
			if (circle[idx % N] % 2 == 1) {
				idx += L;
				if (idx >= N)
					idx %= N;
			} else {
				for (int i = 0; i < L; i++) {
					if (idx > 0) {
						idx--;
					} else {
						if (idx == 0) {
							idx = N - 1;
							continue;
						}
						idx--;
					}
				}
			}
		}
		System.out.println(cnt - 1);
	}
}
