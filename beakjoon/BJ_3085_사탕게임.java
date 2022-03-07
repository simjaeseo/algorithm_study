package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3085_사탕게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j];
			}
		}
		
		int max = 0;
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				int rowCnt = 0;
//				int colCnt = 0;
//				
//				// 현재 기준 행 카운트
//				for (int j2 = 0; j2 < N ; j2++) {
//					if(map[i][j] == map[j2][j])	rowCnt++;
//					if(map[i][j] == map[i][j2])	colCnt++;
//				}
//				
//				max = Math.max(max, rowCnt);
//				max = Math.max(max, colCnt);
//				
//			}
//		}
		
		// 상, 하, 좌, 우
		int[][] dd = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				for (int j2 = 0; j2 < 4; j2++) {
					int row = i+dd[j2][0];
					int col = j+dd[j2][1];
					
					if(row>=0 && col>=0 && row<N && col<N && map[i][j] != map[row][col]) {
						char tmp = map[i][j];
						map[i][j] = map[row][col];
						map[row][col] = tmp;
						
						
						for (int l = 0; l < N; l++) {
							int rowCnt = 1;
							int colCnt = 1;
							for (int k = 0; k < N-1; k++) {
								if(map[k][l] == map[k+1][l])	rowCnt++;
								else	rowCnt=1;
								
								if(map[l][k] == map[l][k+1])	colCnt++;
								else colCnt=1;
								
								max = Math.max(max, rowCnt);
								max = Math.max(max, colCnt);
								
//								for (int q = 0; q < N; q++) {
//									System.out.println(Arrays.toString(map[q]));
//								}
//								System.out.println();
//								
//								System.out.println(l);
//								System.out.println(k);
//								System.out.println(rowCnt);
//								System.out.println(colCnt);
							}
							
						}
						
						
						
						tmp = map[i][j];
						map[i][j] = map[row][col];
						map[row][col] = tmp;
					}
					
				}
				
				
			}
		}
		System.out.println(max);
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
	}
}
