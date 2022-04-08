package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소_심재서 {
	static int row, col, map[][],copyMap[][], max=Integer.MIN_VALUE;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		copyMap = new int[row][col];

		for (int j = 0; j < row; j++) {
			st = new StringTokenizer(br.readLine());
			for (int j2 = 0; j2 < col; j2++) {
				map[j][j2] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0,0,0);
		System.out.println(max);
	}

	private static void makeWall(int startR, int startC, int wallCnt) {
		if(wallCnt==3) {
			copy();
			bfs();
			max = Math.max(max, safeCnt() );
			
//			for (int j = 0; j < row; j++) {
//				System.out.println(Arrays.toString(copyMap[j]));
//			}
//			System.out.println();
			return;
		}
		
		for (int j = 0; j < row; j++) {
			for (int j2 = 0; j2 < col; j2++) {
				if(map[j][j2] == 0) {
					map[j][j2] = 1;
					makeWall(j, j2+1, wallCnt+1);
					map[j][j2] = 0;
				}
			}
		}
	}

	private static int safeCnt() {
		int safeSpace = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(copyMap[i][j] == 0) safeSpace++;
			}
		}
		return safeSpace;
	}

	private static void copy() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for (int j = 0; j < row; j++) {
			for (int j2 = 0; j2 < col; j2++) {
				if(copyMap[j][j2] == 2) {
					q.add(new int[] {j,j2});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] virus = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int mr = virus[0] + dr[i];
				int mc = virus[1] + dc[i];
				
				if(mr<0||mc<0||mr>=row||mc>=col)	continue;
				if(copyMap[mr][mc] != 0)	continue;
				
				copyMap[mr][mc] = 2;
				q.add(new int[] {mr,mc});
			}
		}
		
		return 0;
	}

}
