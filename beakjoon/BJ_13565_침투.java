package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13565_침투 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int row, col;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			String[] c = br.readLine().split("");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(c[j]);
			}
		}

		if(bfs()) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		

	}

	private static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < col; i++) {
			if(map[0][i] == 0) 	{
				q.add(new int[] {0,i});
				map[0][i] = 2;
			}
		}
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			if(c[0] == row-1)	return true;
			
			for (int i = 0; i < 4; i++) {
				int moveR = c[0] + dr[i];
				int moveC = c[1] + dc[i];
				
				if(moveR <0 || moveC <0 || moveR>= row || moveC >= col) continue;
				if(map[moveR][moveC] >= 1)	continue;
				
				map[moveR][moveC] = 2;
				q.add(new int[] {moveR,moveC});
			}
			
		}
		
		return false;

	}
	
}
