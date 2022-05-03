package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5212_지구온난화 {
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static char[][] map;
	static int row, col;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		check = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				map[i][j] = s[j];
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j] == 'X') {
					checkSea(i,j);
				}
			}
		}
		
		int minr = Integer.MAX_VALUE;
		int minc = Integer.MAX_VALUE;
		int maxr = Integer.MIN_VALUE;
		int maxc = Integer.MIN_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(check[i][j] == true) {
					map[i][j] = '.';
				}
				if(map[i][j] == 'X') {
					minr = Math.min(minr, i);
					minc = Math.min(minc, j);
					maxr = Math.max(maxr, i);
					maxc = Math.max(maxc, j);
				}
			}
		}
		
		for (int i = minr; i <= maxr; i++) {
			for (int j = minc; j <= maxc; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		

	}

	private static void checkSea(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			
			if(mr<0||mc<0||mr>=row||mc>=col) {
				cnt++;
				continue;
			}
			
			if(map[mr][mc] == '.') {
				cnt++;
			}
		}
		if(cnt>=3) {
			check[r][c] = true;
		}
	}

}
