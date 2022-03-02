package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157_자리배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] hall = new int[row][col];
		
		int K = Integer.parseInt(br.readLine());
		int[] idx = {0,row-1,col-1,0}; // 좌하우상
		
		for (int i = 1; i <= K; i++) {
			
			//gk
			for (int j = 0; j < row; j++) {
				if(hall[j][idx[0]] == 0) {
					hall[j][idx[0]] = 0;
				}
			}
			idx[0]++;
			
			
			
			
		}
		
	}

}
