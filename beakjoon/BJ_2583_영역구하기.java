package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기 {
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] map;
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> l = new LinkedList<>();

		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			for (int j = ly; j < ry; j++) {
				for (int j2 = lx; j2 < rx; j2++) {
					map[j][j2] = 1;
				}
			}
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					l.add(bfs(i, j));
					cnt++;
				}
			}
		}
		
		Collections.sort(l);

//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		

		System.out.println(cnt);
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
	}

	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		int cnt = 0;
		map[r][c] = 1;
		cnt++;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int i = 0; i < 4; i++) {
				int mr = p[0] + dr[i];
				int mc = p[1] + dc[i];

				if (mr < 0 || mc < 0 || mr >= M || mc >= N || map[mr][mc] == 1)
					continue;
				
				q.add(new int[] {mr,mc});
				map[mr][mc] = 1;
				cnt++;
			}
			
//			for (int i = 0; i < M; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();

		}
		
		return cnt;

	}

}
