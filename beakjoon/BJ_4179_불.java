package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_불 {
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] map, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new int[row][col];

		Queue<int[]> jQ = new LinkedList<>();
		Queue<int[]> fQ = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if (s[j] == '#') {
					map[i][j] = -1;
				} else if (s[j] == 'J') {
					map[i][j] = 1;
					jQ.add(new int[] { i, j });
				} else if (s[j] == 'F') {
					map[i][j] = -2;
					fQ.add(new int[] { i, j });
				} else {
					map[i][j] = 0;
				}
			}
		}

		int cnt = 0;

		while (true) {
			cnt++;

			int fireSize = fQ.size();
			while (fireSize > 0) {
				fireSize--;

				int[] position = fQ.poll();

				for (int i = 0; i < 4; i++) {
					int mr = position[0] + dr[i];
					int mc = position[1] + dc[i];

					if (mr < 0 || mc < 0 || mr >= row || mc >= col)
						continue;
					if (map[mr][mc] >= 0) {
						// 'J'이거나 '.' 이라면
						fQ.add(new int[] { mr, mc });
						map[mr][mc] = -2;
					}

				}

			}

			int jSize = jQ.size();
			while (jSize > 0) {
				jSize--;
				int[] position = jQ.poll();
				for (int i = 0; i < 4; i++) {

					int mr = position[0] + dr[i];
					int mc = position[1] + dc[i];

					if (mr < 0 || mc < 0 || mr >= row || mc >= col) {
						System.out.println(cnt);
						return;
					}
					if (map[mr][mc] == 0) {
						// '.' 이라면
						jQ.add(new int[] { mr, mc });
						map[mr][mc] = 1;
					}

				}

			}

			if (jQ.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				return;
			}

		}

	}

}
