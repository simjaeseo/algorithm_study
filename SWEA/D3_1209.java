package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D3_1209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			
			
			int[][] arr = new int[100][100];
			
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < 100; j2++) {
					int num = Integer.parseInt(st.nextToken());
					arr[j][j2] = num;
				}
			}
			

			int max = 0;
			
//			for (int j = 0; j < 100; j++) {
//				for (int j2 = 0; j2 < 100; j2++) {
//					System.out.print(arr[j][j2] + " ");
//				}
//				System.out.println();
//			}
//			
			
			
			// 행 합
			for (int j = 0; j < 100; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < 100; j2++) {
					sum += arr[j][j2];
				}
				if(max < sum)	max = sum;
			}
			
			// 열 합
			for (int j = 0; j < 100; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < 100; j2++) {
					sum += arr[j2][j];
				}
				if(max < sum)	max = sum;
			}
			
			int sum = 0;
			//우하향
			for (int j = 0; j < 100; j++) {
				sum += arr[j][j];
			}
			if(max < sum)	max = sum;
			
			sum = 0;
			int j2 = 0;
			//좌하향
			for (int j = 99; j <= 0; j--) {
				sum += arr[j2][j];
				j2++;
			}
			if(max < sum)	max = sum;
			
			System.out.printf("#%d %d", i+1, max);
			System.out.println();
		}
		
		
		
	}

}
