package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2840_행운의바퀴 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] circle = new char[N];
		int point = 0;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			char alpha = st.nextToken().charAt(0);

			point = (point + S) % N;

			if (circle[point] != 0 && circle[point] != alpha) {
				System.out.println("!");
				return;
			}
			circle[point] = alpha;

		}

		int[] check = new int[27];
		for (int i = 0; i < N; i++) {
			if (circle[i] != 0)
				check[circle[i] - 'A']++;
		}

		for (int i = 0; i < 27; i++) {
			if (check[i] > 1) {
				System.out.println("!");
				return;
			}
		}

		for (int i = point; i >= 0; i--) {
			if (circle[i] == 0)
				System.out.print("?");
			else
				System.out.print(circle[i]);
		}

		for (int i = N - 1; i > point; i--) {
			if (circle[i] == 0)
				System.out.print("?");
			else
				System.out.print(circle[i]);
		}

	}

}
