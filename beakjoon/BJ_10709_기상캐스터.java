package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10709_기상캐스터 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		char[][] JOI = new char[H][W];
		int[][] JOI2 = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				JOI[i][j] = tmp[j];
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = W-1; j >= 0; j--) {
				
				if(JOI[i][j] == 'c') {
					JOI[i][j] = '0';
					for (int j2 = j+1; j2 < W; j2++) {
						if(JOI[i][j2] == '.') {
							int sec = j2-j;
							JOI[i][j2] = (char) (j2-j + '0');
							JOI2[i][j2] = j2-j;
							
						}
					}
				}		
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(JOI[i][j] == '.')  {
					JOI[i][j] = (char) ('0'-1);
					JOI2[i][j] = -1;
				}
			}
		}
			
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(JOI2[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
