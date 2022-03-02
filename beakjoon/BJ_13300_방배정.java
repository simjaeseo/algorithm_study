package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] students = new int[7][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0) {
				// 여학생일때,
				students[Integer.parseInt(st.nextToken())][0]++;
			} else {
				// 남학생일때,
				students[Integer.parseInt(st.nextToken())][1]++;
			}
		}
		
		int cnt = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				while(students[i][j]>0) {
					cnt++;
					students[i][j] -= K;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
