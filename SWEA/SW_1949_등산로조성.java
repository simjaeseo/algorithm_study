package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1949_등산로조성 {
	static int K, N, map[][], max;
	static boolean isVisited[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			int heightMax = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
					if (heightMax < map[j][j2])
						heightMax = map[j][j2];
				}
			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (heightMax == map[j][j2]) {
						isVisited = new boolean[N][N];
						isVisited[j][j2] = true;
						dfs(j, j2, 1, 0);
					}
				}
			}

			System.out.println("#" + i + " " + max);
			// tc 반복 끝
		}

	}

	private static void dfs(int r, int c, int cnt, int kCnt) {
		if (max < cnt)
			max = cnt;

		for (int i = 0; i < 4; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];

			if (mr < 0 || mc < 0 || mr >= N || mc >= N)
				continue;

			if (map[r][c] > map[mr][mc] && !isVisited[mr][mc]) {
				isVisited[mr][mc] = true;
				dfs(mr, mc, cnt + 1, kCnt);
				isVisited[mr][mc] = false;
			} else if (map[mr][mc] - map[r][c] + 1 <= K && kCnt == 0 && !isVisited[mr][mc]) {
				for (int j = 1; j <= K; j++) {
					map[mr][mc] -= j;
					if (map[r][c] > map[mr][mc]) {
						isVisited[mr][mc] = true;
						dfs(mr, mc, cnt + 1, kCnt + 1);
						isVisited[mr][mc] = false;
					}
					map[mr][mc] += j;
				}
			}

		}

	}

	/*
	 * dfs로 들어가기 1. 4방탐색 (현재 높이보다 낮으면 바로 dfs, 다음 높이 - 현재 높이 + 1 <= K && kCnt == 0 라면
	 * for문을 통해 1개씩 깎으면서 K번 시도해야함. kCnt+1, cnt+1 하고 dfs 2.
	 * 
	 * 
	 */

}
