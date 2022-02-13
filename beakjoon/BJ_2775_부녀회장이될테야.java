package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2775_부녀회장이될테야 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] apart = new int[k+1][n];
			
			for (int j = 0; j < n; j++) {
				apart[0][j] = j+1;
			}
		
			
			for (int j = 1; j < k+1; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < n; j2++) {
					sum += apart[j-1][j2];
					apart[j][j2] = sum;
				}
			}
//			for (int j = 0; j < k+1; j++) {
//				for (int j2 = 0; j2 < n; j2++) {
//					System.out.print(apart[j][j2] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(apart[k][n-1]);
			
		}
		
		
	}

}
